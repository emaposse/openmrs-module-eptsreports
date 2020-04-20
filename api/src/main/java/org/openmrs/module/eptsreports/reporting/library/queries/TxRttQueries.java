/** */
package org.openmrs.module.eptsreports.reporting.library.queries;

/** @author Stélio Moiane */
public interface TxRttQueries {

  class QUERY {

    public static final String findPatientsWithEncountersInASpecificPeriod =
        "SELECT p.patient_id FROM patient p "
            + "INNER JOIN encounter e ON e.patient_id = p.patient_id "
            + "WHERE p.voided = 0 AND e.voided = 0 AND e.encounter_type IN (6,9,18) AND "
            + "e.encounter_datetime >= :startDate AND e.encounter_datetime <= :endDate AND e.location_id = :location GROUP BY p.patient_id "
            + "UNION "
            + "SELECT p.patient_id FROM patient p "
            + "INNER JOIN encounter e ON e.patient_id = p.patient_id "
            + "INNER JOIN obs o ON o.encounter_id = e.encounter_id "
            + "WHERE p.voided = 0 AND e.voided = 0 AND o.voided = 0 AND o.concept_id = 23866 AND "
            + "e.encounter_type = 52 AND o.value_datetime >= :startDate AND o.value_datetime <= :endDate AND e.location_id = :location "
            + "GROUP BY p.patient_id ";

    public static final String findEncountersByPatient =
        "SELECT encounters.patient_id, encounters.encounter_datetime FROM ( "
            + "SELECT p.patient_id, e.encounter_datetime FROM patient p "
            + "INNER JOIN encounter e ON p.patient_id = e.patient_id "
            + "WHERE e.voided = 0 AND e.encounter_type IN (6,9) AND e.encounter_datetime >= :startDate AND e.encounter_datetime <= :endDate AND e.location_id = :location GROUP BY p.patient_id, e.encounter_datetime "
            + "UNION "
            + "SELECT p.patient_id, e.encounter_datetime FROM patient p "
            + "INNER JOIN encounter e ON p.patient_id = e.patient_id "
            + "WHERE e.voided = 0 AND e.encounter_type = 18 AND e.encounter_datetime >= :startDate AND e.encounter_datetime <= :endDate AND e.location_id = :location GROUP BY p.patient_id, e.encounter_datetime "
            + "UNION "
            + "SELECT p.patient_id, o.value_datetime encounter_datetime FROM patient p "
            + "INNER JOIN encounter e ON p.patient_id = e.patient_id "
            + "INNER JOIN obs o ON o.encounter_id = e.encounter_id "
            + "WHERE e.voided = 0 AND o.voided = 0 AND e.encounter_type = 52 AND o.value_datetime >= :startDate AND o.value_datetime <= :endDate AND e.location_id = :location AND o.concept_id = 23866 "
            + "GROUP BY p.patient_id, o.value_datetime ) encounters "
            + "WHERE encounters.patient_id IN (:patients) ORDER BY encounters.encounter_datetime DESC ";

    public static final String findLastNextPickupDateOnThePreviousPickupEncounterByPatient =
        "SELECT MAX(value_datetime) value_datetime FROM ( "
            + "SELECT pickup.patient_id, o.value_datetime FROM ( "
            + "SELECT p.patient_id, MAX(e.encounter_datetime) encounter_datetime FROM patient p "
            + "INNER JOIN encounter e ON e.patient_id = p.patient_id "
            + "INNER JOIN obs o ON o.encounter_id = e.encounter_id "
            + "WHERE p.voided = 0 AND e.voided = 0 AND o.voided = 0 AND o.concept_id = 5096 AND "
            + "e.encounter_type = 18 AND e.encounter_datetime < :encounterDate AND e.location_id = :location AND p.patient_id = :patientId "
            + "GROUP BY p.patient_id) pickup "
            + "INNER JOIN obs o ON pickup.patient_id = o.person_id AND o.concept_id = 5096 AND o.voided = 0 AND pickup.encounter_datetime = o.obs_datetime "
            + "UNION "
            + "SELECT p.patient_id,(MAX(o.value_datetime) + INTERVAL 30 DAY) value_datetime FROM patient p "
            + "INNER JOIN encounter e ON e.patient_id = p.patient_id "
            + "INNER JOIN obs o ON o.encounter_id = e.encounter_id "
            + "WHERE p.voided = 0 AND e.voided = 0 AND o.voided = 0 AND o.concept_id = 23866 AND "
            + "e.encounter_type = 52 AND o.value_datetime < :encounterDate AND e.location_id = :location AND p.patient_id = :patientId "
            + "GROUP BY p.patient_id) next_pickup "
            + "WHERE next_pickup.value_datetime IS NOT NULL "
            + "group by next_pickup.patient_id ";

    public static final String
        findLastNextEncounterScheduledDateOnThePreviousFolloupEncounterByPatient =
            "SELECT o.value_datetime FROM ( "
                + "SELECT p.patient_id, MAX(e.encounter_datetime) encounter_datetime FROM patient p "
                + "INNER JOIN encounter e ON e.patient_id = p.patient_id "
                + "INNER JOIN obs o ON o.encounter_id = e.encounter_id "
                + "WHERE p.voided = 0 AND e.voided = 0 AND o.voided = 0 AND o.concept_id = 1410 "
                + "AND e.encounter_type IN (6,9) AND e.encounter_datetime < :encounterDate AND e.location_id = :location AND p.patient_id = :patientId "
                + "GROUP BY p.patient_id)max_encounter INNER JOIN obs o ON max_encounter.patient_id = o.person_id "
                + "AND o.concept_id = 1410 AND o.voided = 0 AND max_encounter.encounter_datetime = o.obs_datetime "
                + "AND o.value_datetime IS NOT NULL;";
  }
}
