/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.eptsreports.reporting.library.queries.data.quality;

public class Ec2Queries {
  /** Get the combined query for EC2 patient listing */
  public static String getEc2CombinedQuery() {
    String query =
        "SELECT pe.person_id as patient_id,  "
            + "pid.identifier AS NID, "
            + "concat(ifnull(pn.given_name,''),' ',ifnull(pn.middle_name,''),' ',ifnull(pn.family_name,'')) AS Name, "
            + "DATE_FORMAT(pe.birthdate, '%d-%m-%Y') AS birthdate, "
            + "IF(pe.birthdate_estimated = 1, 'Yes','No') AS Estimated_dob, "
            + "pe.gender AS Sex, "
            + "DATE_FORMAT(pe.date_created, '%d-%m-%Y %H:%i:%s') AS First_entry_date, "
            + "DATE_FORMAT(pe.date_changed, '%d-%m-%Y %H:%i:%s') AS Last_updated, "
            + "lactante.criteria criteria, "
            + "DATE_FORMAT(lactante.data_parto, '%d-%m-%Y') AS data_parto, "
            + "prog.state state, "
            + "prog.date_enrolled state_date, "
            + "l.name location_name FROM  person pe  "
            + "inner join  ( "
            + "Select p.patient_id,o.value_datetime data_parto, 'BC1' AS criteria from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=5599 and e.encounter_type in (5,6) and o.value_datetime  between :startDate and :endDate  and e.location_id in(:location) "
            + "union "
            + "Select p.patient_id,o.obs_datetime data_parto, 'BC2' AS criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=6334 and o.value_coded=6332 and e.encounter_type in (5,6) and  o.obs_datetime between :startDate and :endDate  and e.location_id in(:location) "
            + "union "
            + "Select p.patient_id,o.obs_datetime data_parto, 'BC3' AS criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=6332 and o.value_coded=1065 and e.encounter_type=6 and o.obs_datetime between :startDate and :endDate  and e.location_id in(:location) "
            + "union  "
            + "Select p.patient_id, e.encounter_datetime data_parto, 'BC4' as criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "inner join obs obsART on e.encounter_id=obsART.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and o.concept_id=6332 and o.value_coded=1065 and  e.encounter_type=53 and  "
            + "e.location_id in (:location) and  obsART.value_datetime between :startDate and :endDate and  obsART.concept_id=1190 and obsART.voided=0 "
            + "union "
            + "select pp.patient_id,pp.date_enrolled data_lactante, 'BC5' AS criteria  from patient_program pp  "
            + "inner join patient_state ps on pp.patient_program_id=ps.patient_program_id "
            + "where pp.program_id=8 and ps.state=27 and pp.voided=0 and pp.date_enrolled between :startDate and :endDate  and pp.location_id in(:location) "
            + ") lactante on lactante.patient_id=pe.person_id  "
            + "left join (select pid1.* from patient_identifier pid1 "
            + "inner join ( "
            + "select patient_id,min(patient_identifier_id) id from patient_identifier "
            + "where voided=0 "
            + "group by patient_id "
            + ") pid2 "
            + "where pid1.patient_id=pid2.patient_id and pid1.patient_identifier_id=pid2.id "
            + ") pid on pid.patient_id=pe.person_id "
            + "left join ( select pn1.* from person_name pn1 "
            + "inner join ( "
            + "select person_id,min(person_name_id) id from person_name "
            + "where voided=0 "
            + "group by person_id "
            + ") pn2 "
            + "where pn1.person_id=pn2.person_id and pn1.person_name_id=pn2.id "
            + ") pn on pn.person_id=pe.person_id "
            + "left join location l on l.location_id=pid.location_id "
            + "LEFT JOIN ( "
            + "SELECT pa.patient_id AS patientId,  "
            + "DATE_FORMAT(pg.date_enrolled, '%d-%m-%Y') AS date_enrolled,  "
            + "case  "
            + "when ps.state = 25 then 'PREGNANT'  "
            + "when ps.state = 26 then 'PREGNANCY TERMINATION' "
            + "when ps.state = 27 then 'DELIVERY'  "
            + "end AS state FROM patient pa "
            + "INNER JOIN patient_program pg ON pa.patient_id=pg.patient_id  "
            + "INNER JOIN patient_state ps ON pg.patient_program_id=ps.patient_program_id  "
            + "WHERE  pg.program_id=8 AND ps.state=27 "
            + "AND ps.start_date IS NOT NULL AND ps.end_date IS NULL GROUP BY pa.patient_id "
            + ") prog ON lactante.patient_id=prog.patientId "
            + "where pe.voided = 0 and pe.gender='M' and lactante.patient_id is not null  "
            + "GROUP BY pe.person_id ";
    return query;
  }

  public static String getEc2Total() {
    String query =
        "SELECT pe.person_id as patient_id FROM person pe  "
            + "inner join  ( "
            + "Select p.patient_id,o.value_datetime data_parto, 'BC1' AS criteria from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=5599 and e.encounter_type in (5,6) and o.value_datetime  between :startDate and :endDate  and e.location_id in(:location) "
            + "union "
            + "Select p.patient_id,o.obs_datetime data_parto, 'BC2' AS criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=6334 and o.value_coded=6332 and e.encounter_type in (5,6) and  o.obs_datetime between :startDate and :endDate  and e.location_id in(:location) "
            + "union "
            + "Select p.patient_id,o.obs_datetime data_parto, 'BC3' AS criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and concept_id=6332 and o.value_coded=1065 and e.encounter_type=6 and o.obs_datetime between :startDate and :endDate  and e.location_id in(:location) "
            + "union  "
            + "Select p.patient_id, e.encounter_datetime data_parto, 'BC4' as criteria  from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on e.encounter_id=o.encounter_id  "
            + "inner join obs obsART on e.encounter_id=obsART.encounter_id  "
            + "where p.voided=0 and e.voided=0 and o.voided=0 and o.concept_id=6332 and o.value_coded=1065 and  e.encounter_type=53 and  "
            + "e.location_id in (:location) and  obsART.value_datetime between :startDate and :endDate and  obsART.concept_id=1190 and obsART.voided=0 "
            + "union "
            + "select pp.patient_id,pp.date_enrolled data_lactante, 'BC5' AS criteria  from patient_program pp  "
            + "inner join patient_state ps on pp.patient_program_id=ps.patient_program_id "
            + "where pp.program_id=8 and ps.state=27 and pp.voided=0 and pp.date_enrolled between :startDate and :endDate  and pp.location_id in(:location) "
            + ") lactante on lactante.patient_id=pe.person_id  "
            + "left join (select pid1.* from patient_identifier pid1 "
            + "inner join ( "
            + "select patient_id,min(patient_identifier_id) id from patient_identifier "
            + "where voided=0 "
            + "group by patient_id "
            + ") pid2 "
            + "where pid1.patient_id=pid2.patient_id and pid1.patient_identifier_id=pid2.id "
            + ") pid on pid.patient_id=pe.person_id "
            + "left join ( select pn1.* from person_name pn1 "
            + "inner join ( "
            + "select person_id,min(person_name_id) id from person_name "
            + "where voided=0 "
            + "group by person_id "
            + ") pn2 "
            + "where pn1.person_id=pn2.person_id and pn1.person_name_id=pn2.id "
            + ") pn on pn.person_id=pe.person_id "
            + "left join location l on l.location_id=pid.location_id "
            + "LEFT JOIN ( "
            + "SELECT pa.patient_id AS patientId,  "
            + "DATE_FORMAT(pg.date_enrolled, '%d-%m-%Y') AS date_enrolled,  "
            + "case  "
            + "when ps.state = 25 then 'PREGNANT'  "
            + "when ps.state = 26 then 'PREGNANCY TERMINATION' "
            + "when ps.state = 27 then 'DELIVERY'  "
            + "end AS state FROM patient pa "
            + "INNER JOIN patient_program pg ON pa.patient_id=pg.patient_id  "
            + "INNER JOIN patient_state ps ON pg.patient_program_id=ps.patient_program_id  "
            + "WHERE  pg.program_id=8 AND ps.state=27 "
            + "AND ps.start_date IS NOT NULL AND ps.end_date IS NULL GROUP BY pa.patient_id "
            + ") prog ON lactante.patient_id=prog.patientId "
            + "where pe.voided = 0 and pe.gender='M' and lactante.patient_id is not null  "
            + "GROUP BY pe.person_id ";

    return query;
  }
}
