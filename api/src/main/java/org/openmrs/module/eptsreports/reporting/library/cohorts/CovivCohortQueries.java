package org.openmrs.module.eptsreports.reporting.library.cohorts;

import java.util.Date;
import org.openmrs.Location;
import org.openmrs.module.eptsreports.reporting.library.queries.CovivQueries;
import org.openmrs.module.eptsreports.reporting.library.queries.Eri4MonthsQueries;
import org.openmrs.module.eptsreports.reporting.library.queries.ErimType;
import org.openmrs.module.eptsreports.reporting.utils.EptsReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CompositionCohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.definition.library.DocumentedDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CovivCohortQueries {
  @Autowired private ResumoMensalCohortQueries resumoMensalCohortQueries;

  @DocumentedDefinition(value = "ret12Months")
  public CohortDefinition ret12Months() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(CovivQueries.QUERY.ret12Months);

    return definition;
  }

  @DocumentedDefinition(value = "pvlsDen")
  public CohortDefinition pvlsDen() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(
        CovivQueries.QUERY
            .findPatientsWhoHaveMoreThan3MonthsOnArtWithViralLoadRegisteredInTheLast12Months);

    return definition;
  }

  @DocumentedDefinition(value = "pvlsNun")
  public CohortDefinition pvlsNun() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(
        CovivQueries.QUERY
            .findPatientsWhoHaveMoreThan3MonthsOnArtWithViralLoadRegisteredInTheLast12MonthsNun);

    return definition;
  }

  @DocumentedDefinition(value = "ret12Months")
  public CohortDefinition ret12MonthsNumerator() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    definition.addSearch("A", EptsReportUtils.map(this.ret12Months(), mappings));
    definition.addSearch(
        "B",
        EptsReportUtils.map(
            this.resumoMensalCohortQueries.findPatientsWhoAreCurrentlyEnrolledOnArtMOHB13(),
            mappings));

    definition.setCompositionString("A AND B");

    return definition;
  }

  @DocumentedDefinition(value = "ret4MonthsDenominator")
  public CohortDefinition ret4MonthsDenominator() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(
        Eri4MonthsQueries
            .findPatientsWhoHaveEitherClinicalConsultationOrDrugsPickupBetween61And120ForASpecificPatientType(
                ErimType.TOTAL));

    return definition;
  }

  @DocumentedDefinition(value = "ret4MonthsNumerator")
  public CohortDefinition ret4MonthsNumerator() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("12 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    definition.addSearch("A", EptsReportUtils.map(this.ret4MonthsDenominator(), mappings));
    definition.addSearch(
        "B",
        EptsReportUtils.map(
            this.resumoMensalCohortQueries.findPatientsWhoAreCurrentlyEnrolledOnArtMOHB13(),
            mappings));

    definition.setCompositionString("A AND B");

    return definition;
  }

  @DocumentedDefinition(value = "ret6MonthsDenominator")
  public CohortDefinition ret6MonthsDenominator() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("6 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(CovivQueries.QUERY.ret6Months);

    return definition;
  }

  @DocumentedDefinition(value = "ret6MonthsNumerator")
  public CohortDefinition ret6MonthsNumerator() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("6 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    definition.addSearch("A", EptsReportUtils.map(this.ret6MonthsDenominator(), mappings));
    definition.addSearch(
        "B",
        EptsReportUtils.map(
            this.resumoMensalCohortQueries.findPatientsWhoAreCurrentlyEnrolledOnArtMOHB13(),
            mappings));

    definition.setCompositionString("A AND B");

    return definition;
  }

  @DocumentedDefinition(value = "ret6MonthsDenominator")
  public CohortDefinition ret9MonthsDenominator() {
    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("6 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    definition.setQuery(CovivQueries.QUERY.ret9Months);

    return definition;
  }

  @DocumentedDefinition(value = "ret9MonthsNumerator")
  public CohortDefinition ret9MonthsNumerator() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("9 meses");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "location", Location.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    definition.addSearch("A", EptsReportUtils.map(this.ret6MonthsDenominator(), mappings));
    definition.addSearch(
        "B",
        EptsReportUtils.map(
            this.resumoMensalCohortQueries.findPatientsWhoAreCurrentlyEnrolledOnArtMOHB13(),
            mappings));

    definition.setCompositionString("A AND B");

    return definition;
  }
}
