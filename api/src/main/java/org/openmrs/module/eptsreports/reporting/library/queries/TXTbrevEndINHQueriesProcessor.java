package org.openmrs.module.eptsreports.reporting.library.queries;

public interface TXTbrevEndINHQueriesProcessor {

  class QUERY {

    public static final String processPatientsByMaxInFichaClinicaFichaResumoFichaSeguimento =
        "select final.patient_id, final.data_final_tpi from ( "
            + "select p.patient_id,max(o.value_datetime) data_final_tpi from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "where e.voided=0 and p.voided=0 and o.value_datetime between :startDate - interval 6 month and :endDate and  "
            + "o.voided=0 and o.concept_id=6129 and e.encounter_type in (6,9,53) and e.location_id=:location  "
            + "and e.patient_id in(:patientIds) "
            + "group by p.patient_id  "
            + "union "
            + "select p.patient_id,max(e.encounter_datetime) data_final_tpi from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate and o.voided=0  "
            + "and o.concept_id=6122 and o.value_coded=1257 and e.encounter_type=6 and  e.location_id=:location and "
            + "e.patient_id in(:patientIds) "
            + "group by p.patient_id "
            + ") final";

    public static final String findMaxEncounterDateByPatientMin6EncountersOnFichaClinicaWithINH =
        "select sixEncounters.patient_id,sixEncounters.data_inicio_tpi from (  "
            + "select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate  "
            + "and o.voided=0 and o.concept_id=6122 and e.encounter_type=6  and o.value_coded in(1256,1257) and e.location_id=:location  "
            + "and e.patient_id in(:patientIds) "
            + "group by p.patient_id   "
            + ")  sixEncounters  "
            + "inner join encounter e on e.patient_id=sixEncounters.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "where e.encounter_type=6 and o.concept_id=6122 and o.value_coded in (1257,1065) and o.voided=0 and e.location_id=:location  "
            + "group by sixEncounters.patient_id having count(*)>=6  "
            + "order by sixEncounters.patient_id ";

    public static final String
        findMaxEncounterDateByPatientMin2FlitsEncountersWithQuartelyDespensation =
            "select twoFlits.patient_id,twoFlits.data_inicio_tpi from (  "
                + "select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p  "
                + "inner join encounter e on p.patient_id=e.patient_id  "
                + "inner join obs o on o.encounter_id=e.encounter_id  "
                + "inner join obs obsTrimestral on obsTrimestral.encounter_id=e.encounter_id "
                + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate "
                + "and o.voided=0 and o.concept_id=23985 and e.encounter_type=60 and o.value_coded in(656,23982) and e.location_id=:location "
                + "and obsTrimestral.concept_id=23986  and obsTrimestral.value_coded=23720 and obsTrimestral.voided=0 "
                + "and e.patient_id in(:patientIds) "
                + "group by p.patient_id "
                + ") twoFlits  "
                + "inner join encounter e on e.patient_id=twoFlits.patient_id  "
                + "inner join obs o on o.encounter_id=e.encounter_id  "
                + "inner join obs obsTrimestral on obsTrimestral.encounter_id=e.encounter_id "
                + "where e.encounter_type=60 and o.concept_id=23985 and o.value_coded in (656,23982) and o.voided=0 and e.location_id=:location "
                + "and obsTrimestral.concept_id=23986  and obsTrimestral.value_coded=23720 and obsTrimestral.voided=0 "
                + "group by twoFlits.patient_id having count(*)>=2  "
                + "order by twoFlits.patient_id ";

    public static final String
        findMaxEncounterDateByPatientMin6FlitsEncountersWithMontlyDespensation =
            "select sixFlits.patient_id,sixFlits.data_inicio_tpi from (  "
                + "select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p  "
                + "inner join encounter e on p.patient_id=e.patient_id  "
                + "inner join obs o on o.encounter_id=e.encounter_id  "
                + "inner join obs obsMensal on obsMensal.encounter_id=e.encounter_id "
                + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate  "
                + "and o.voided=0 and o.concept_id=23985 and e.encounter_type=60 and o.value_coded in(656,23982) and e.location_id=:location  "
                + "and obsMensal.concept_id=23986  and obsMensal.value_coded=1098 and obsMensal.voided=0 "
                + "and e.patient_id in(:patientIds) "
                + "group by p.patient_id   "
                + ")  sixFlits  "
                + "inner join encounter e on e.patient_id=sixFlits.patient_id  "
                + "inner join obs o on o.encounter_id=e.encounter_id  "
                + "inner join obs obsMensal on obsMensal.encounter_id=e.encounter_id "
                + "where e.encounter_type=60 and o.concept_id=23985 and o.value_coded in (656,23982) and o.voided=0 and e.location_id=:location  "
                + "and obsMensal.concept_id=23986  and obsMensal.value_coded=1098 and obsMensal.voided=0 "
                + "group by sixFlits.patient_id having count(*)>=6  "
                + "order by sixFlits.patient_id  ";

    public static final String findMaxEncounterDateByPatientMin2EncountersWithINHandDTINH =
        "select twoEncounters.patient_id,twoEncounters.data_inicio_tpi from ("
            + " select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p  "
            + "inner join encounter e on p.patient_id=e.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "inner join obs obsDTINH on obsDTINH.encounter_id=e.encounter_id  "
            + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate  "
            + "and o.voided=0 and o.concept_id=6122 and e.encounter_type=6  and o.value_coded in(1256,1257) and e.location_id=:location "
            + "and obsDTINH.concept_id=1719 and obsDTINH.value_coded=23955 and obsDTINH.voided=0 "
            + "and e.patient_id in(:patientIds) "
            + "group by p.patient_id   "
            + ") twoEncounters  "
            + "inner join encounter e on e.patient_id=twoEncounters.patient_id  "
            + "inner join obs o on o.encounter_id=e.encounter_id  "
            + "inner join obs obsDTINH on obsDTINH.encounter_id=e.encounter_id  "
            + "where e.encounter_type=6 and o.concept_id=6122 and o.value_coded in (1256,1257) and o.voided=0 and e.location_id=:location  "
            + "and obsDTINH.concept_id=1719 and obsDTINH.value_coded=23955 and obsDTINH.voided=0 "
            + "group by twoEncounters.patient_id having count(*)>=2  "
            + "order by twoEncounters.patient_id ";

    public static final String
        findMaxEncounterDateByPatientMin2EncountersFichaClinicaWithINHandOneFichaClinicaWithDTINH =
            "select INH.patient_id,INH.data_inicio_tpi from ( "
                + "select twoEncounters.patient_id,twoEncounters.data_inicio_tpi from ( "
                + "select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p   "
                + "inner join encounter e on p.patient_id=e.patient_id   "
                + "inner join obs o on o.encounter_id=e.encounter_id   "
                + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate "
                + "and o.voided=0 and o.concept_id=6122 and e.encounter_type=6  and o.value_coded in(1256,1257) and e.location_id=:location "
                + "and e.patient_id in(:patientIds) "
                + "group by p.patient_id    "
                + ") twoEncounters   "
                + "inner join encounter e on e.patient_id=twoEncounters.patient_id   "
                + "inner join obs o on o.encounter_id=e.encounter_id   "
                + "where e.encounter_type=6 and o.concept_id=6122 and o.value_coded in (1256,1257) and o.voided=0 and e.location_id=:location "
                + "group by twoEncounters.patient_id having count(*)>=2   "
                + "order by twoEncounters.patient_id  "
                + ")INH "
                + "inner join  ( "
                + "select oneEncounters.patient_id,oneEncounters.data_inicio_tpi from ( "
                + "select p.patient_id,max(e.encounter_datetime) data_inicio_tpi from patient p   "
                + "inner join encounter e on p.patient_id=e.patient_id   "
                + "inner join obs o on o.encounter_id=e.encounter_id   "
                + "where e.voided=0 and p.voided=0 and e.encounter_datetime between :startDate - interval 6 month and :endDate "
                + "and o.voided=0 and o.concept_id=1719 and e.encounter_type=6  and o.value_coded in(23955) and e.location_id=:location "
                + "and e.patient_id in(:patientIds) "
                + "group by p.patient_id "
                + ") oneEncounters   "
                + "inner join encounter e on e.patient_id=oneEncounters.patient_id   "
                + "inner join obs o on o.encounter_id=e.encounter_id   "
                + "where e.encounter_type=6 and o.concept_id=1719 and o.value_coded in (23955) and o.voided=0 and e.location_id=:location "
                + "group by oneEncounters.patient_id having count(*)=1  "
                + "order by oneEncounters.patient_id  "
                + ") DTINH  on DTINH.patient_id=INH.patient_id ";
  }
}
