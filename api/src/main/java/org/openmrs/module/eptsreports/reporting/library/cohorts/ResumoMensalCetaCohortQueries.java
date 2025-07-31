package org.openmrs.module.eptsreports.reporting.library.cohorts;

import java.util.Date;
import org.openmrs.Location;
import org.openmrs.module.eptsreports.reporting.library.queries.ResumoMensalCetaQueries;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.definition.library.DocumentedDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

@Component
public class ResumoMensalCetaCohortQueries {

  @DocumentedDefinition(value = "findPatientsWhoAreTranferedOut")
  public CohortDefinition findPatientsWhoAreTranferedOut() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreTranferedOut");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreTranferedOut;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources")
  public CohortDefinition findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithHighViralLoadResultInOtherSources")
  public CohortDefinition findPatientsWithHighViralLoadResultInOtherSources() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWithHighViralLoadResultInOtherSources;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWithScreeningCriteriaEqualsReintegratedOrPooradherenceInOtherSources")
  public CohortDefinition
      findPatientsWithScreeningCriteriaEqualsReintegratedOrPooradherenceInOtherSources() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWithScreeningCriteriaEqualsReintegratedOrPooradherenceInOtherSources;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWithScreeningCriteriaPsychosocialFactorsOnCetaInitialForm")
  public CohortDefinition findPatientsWithScreeningCriteriaPsychosocialFactorsOnCetaInitialForm() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWithScreeningCriteriaPsychosocialFactorsOnCetaInitialForm;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithScreeningCriteriaPsychosocialFactorsOnOtherSorces")
  public CohortDefinition findPatientsWithScreeningCriteriaPsychosocialFactorsOnOtherSorces() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWithScreeningCriteriaPsychosocialFactorsOnOtherSorces;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1")
  public CohortDefinition findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWhoHavePositiveResultOnFichaFicaBemDuringReportingPeriodIndicator2")
  public CohortDefinition
      findPatientsWhoHavePositiveResultOnFichaFicaBemDuringReportingPeriodIndicator2() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoHavePositiveResultOnFichaFicaBemDuringReportingPeriodIndicator2;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWhoAreReferedTwoFollowUpSeverelMentalDiseaseIndicator3")
  public CohortDefinition findPatientsWhoAreReferedTwoFollowUpSeverelMentalDiseaseIndicator3() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoAreReferedTwoFollowUpSeverelMentalDiseaseIndicator3;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator4")
  public CohortDefinition findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator4() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator4;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5")
  public CohortDefinition findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator6")
  public CohortDefinition findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator6() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator6;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator7")
  public CohortDefinition findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator7() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator7;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoStartedSMCetaIndicator8")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator8() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoStartedSMCetaIndicator8;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoStartedSMCetaIndicator9")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator9() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoStartedSMCetaIndicator9;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoStartedSMCetaIndicator10")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator10() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoStartedSMCetaIndicator10;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoStartedSMCetaIndicator11")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator11() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoStartedSMCetaIndicator11;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoStartedSMCetaIndicator12")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator12() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoStartedSMCetaIndicator12;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreInterruptTretmentIndicator13")
  public CohortDefinition findPatientsWhoAreInterruptTretmentIndicator13() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreInterruptTretmentIndicator13;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreInterruptTretmentIndicator14")
  public CohortDefinition findPatientsWhoAreInterruptTretmentIndicator14() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreInterruptTretmentIndicator14;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreInterruptTretmentIndicator15")
  public CohortDefinition findPatientsWhoAreInterruptTretmentIndicator15() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreInterruptTretmentIndicator15;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreReintegretedIndicator16")
  public CohortDefinition findPatientsWhoAreReintegretedIndicator16() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreReintegretedIndicator16;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreDiedIndicator17")
  public CohortDefinition findPatientsWhoAreDiedIndicator17() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreDiedIndicator17;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoEndTrementIndicator19")
  public CohortDefinition findPatientsWhoEndTrementIndicator19() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoEndTrementIndicator19;

    definition.setQuery(query);

    return definition;
  }
}
