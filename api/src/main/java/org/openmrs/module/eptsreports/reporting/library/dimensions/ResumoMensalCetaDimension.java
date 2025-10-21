package org.openmrs.module.eptsreports.reporting.library.dimensions;

import java.util.Date;
import org.openmrs.Location;
import org.openmrs.module.eptsreports.reporting.library.cohorts.GenericCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.queries.Ceta;
import org.openmrs.module.eptsreports.reporting.utils.CetaType;
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
                "2a consulta TARV", Ceta.findCetaDesagragation(CetaType.One)),
            mappings));

    dimension.addCohortDefinition(
        "high-vl",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "CV>1000 cp/ml", Ceta.findCetaDesagragation(CetaType.Two)),
            mappings));

    dimension.addCohortDefinition(
        "reintegreted",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Reintegrado/Ma Adesao", Ceta.findCetaDesagragation(CetaType.Tree)),
            mappings));

    dimension.addCohortDefinition(
        "psychosocial-factors",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Factores Psicossociais", Ceta.findCetaDesagragation(CetaType.Four)),
            mappings));

    dimension.addCohortDefinition(
        "exclusion",
        EptsReportUtils.map(
            this.genericCohortQueries.generalSql(
                "Sem Informacao", Ceta.findCetaDesagragation(CetaType.Five)),
            mappings));

    return dimension;
  }
}
