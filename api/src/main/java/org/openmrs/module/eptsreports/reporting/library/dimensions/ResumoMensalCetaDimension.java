package org.openmrs.module.eptsreports.reporting.library.dimensions;

import java.util.Date;
import org.openmrs.Location;
import org.openmrs.module.eptsreports.reporting.library.cohorts.GenericCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.queries.ResumoMensalCetaQueries;
import org.openmrs.module.eptsreports.reporting.utils.EptsReportUtils;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.indicator.dimension.CohortDefinitionDimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumoMensalCetaDimension {

  @Autowired private GenericCohortQueries genericCohortQueries;

  public CohortDefinitionDimension getResumoMensalDimension() {

    final CohortDefinitionDimension dimension = new CohortDefinitionDimension();
    String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    dimension.addParameter(new Parameter("startDate", "Start Date", Date.class));
    dimension.addParameter(new Parameter("endDate", "End Date", Date.class));
    dimension.addParameter(new Parameter("location", "location", Location.class));
    dimension.setName("Get patient states");

    dimension.addCohortDefinition(
        "second-consultation",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "2a consulta TARV",
                ResumoMensalCetaQueries.QUERY
                    .findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm),
            mappings));

    dimension.addCohortDefinition(
        "high-vl",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "CV>1000 cp/ml",
                ResumoMensalCetaQueries.QUERY.findPatientsWithHighViralLoadResultInCetaInitialForm),
            mappings));

    dimension.addCohortDefinition(
        "reintegreted",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Reintegrado / Ma Adesao",
                ResumoMensalCetaQueries.QUERY
                    .findPatientsWithScreeningCriteriaEqualsReintegratedOrPooradherenceInCetaForm),
            mappings));

    dimension.addCohortDefinition(
        "psychosocial-factors",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Factores Psicossociais",
                ResumoMensalCetaQueries.QUERY
                    .findPatientsWithScreeningCriteriaPsychosocialFactorsOnCetaInitialForm),
            mappings));

    dimension.addCohortDefinition(
        "exclusion",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Factores Psicossociais", ResumoMensalCetaQueries.QUERY.exclusion),
            mappings));

    return dimension;
  }
}
