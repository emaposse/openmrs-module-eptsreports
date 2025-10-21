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

  @DocumentedDefinition(value = "findPatientsWhoHaveEpilepsyPositiveResulteIndicator4")
  public CohortDefinition findPatientsWhoHaveEpilepsyPositiveResulteIndicator4() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientsWhoHaveEpilepsyPositiveResulteIndicator4;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator5")
  public CohortDefinition findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator5() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator5");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator5;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6")
  public CohortDefinition findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator7")
  public CohortDefinition findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator7() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator7;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoHaveaIdeationSuicideAttemptAtTheEntranceIndicator8")
  public CohortDefinition findPatientsWhoHaveaIdeationSuicideAttemptAtTheEntranceIndicator8() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoHaveaIdeationSuicideAttemptAtTheEntranceIndicator8");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoHaveaIdeationSuicideAttemptAtTheEntranceIndicator8;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator9")
  public CohortDefinition findPatientsWhoStartedSMCetaIndicator9() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator9");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY
            .findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator9;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithHomicideIdeationAtTheEntranceIndicator10")
  public CohortDefinition findPatientsWithHomicideIdeationAtTheEntranceIndicator10() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithHomicideIdeationAtTheEntranceIndicator10");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientsWithHomicideIdeationAtTheEntranceIndicator10;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithAtLeastOneAttemptedHomicedeAtEntry11")
  public CohortDefinition findPatientsWithAtLeastOneAttemptedHomicedeAtEntry11() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithAtLeastOneAttemptedHomicedeAtEntry11");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientsWithAtLeastOneAttemptedHomicedeAtEntry11;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithDepressionSymptomsIndicator12")
  public CohortDefinition findPatientsWithDepressionSymptomsIndicator12() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithDepressionSymptomsIndicator12");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWithDepressionSymptomsIndicator12;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithAnxietySymptomsIndicator13")
  public CohortDefinition findPatientsWithAnxietySymptomsIndicator13() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWithAnxietySymptomsIndicator13;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWithTraumaSymptomsIndicator14")
  public CohortDefinition findPatientsWithTraumaSymptomsIndicator14() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWithTraumaSymptomsIndicator14;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientswhoAbuseAlcoholicBeveragesIndicator15")
  public CohortDefinition findPatientswhoAbuseAlcoholicBeveragesIndicator15() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWithScreeningCriteriaSegundARTConsultationInCetaInitialForm");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientswhoAbuseAlcoholicBeveragesIndicator15;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientswhoConsumeOthePsychoactiveSubtancesIndicator16")
  public CohortDefinition findPatientswhoConsumeOthePsychoactiveSubtancesIndicator16() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientswhoConsumeOthePsychoactiveSubtancesIndicator16");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query =
        ResumoMensalCetaQueries.QUERY.findPatientswhoConsumeOthePsychoactiveSubtancesIndicator16;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreInterruptTretmentIndicator17")
  public CohortDefinition findPatientsWhoAreInterruptTretmentIndicator17() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreInterruptTretmentIndicator17");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreInterruptTretmentIndicator17;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreReferedIndicator18")
  public CohortDefinition findPatientsWhoAreReferedIndicator18() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreReferedIndicator18");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreReferedIndicator18;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreTransferedIndicator19")
  public CohortDefinition findPatientsWhoAreTransferedIndicator19() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreTransferedIndicator19");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreTransferedIndicator19;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreReintegretedIndicator20")
  public CohortDefinition findPatientsWhoAreReintegretedIndicator20() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreReintegretedIndicator20");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreReintegretedIndicator20;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoAreDiedIndicator21")
  public CohortDefinition findPatientsWhoAreDiedIndicator21() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreDiedIndicator21");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoAreDiedIndicator21;

    definition.setQuery(query);

    return definition;
  }

  @DocumentedDefinition(value = "findPatientsWhoEndTrementIndicator23")
  public CohortDefinition findPatientsWhoEndTrementIndicator23() {

    final SqlCohortDefinition definition = new SqlCohortDefinition();

    definition.setName("findPatientsWhoAreDiedIndicator21");
    definition.addParameter(new Parameter("startDate", "Start Date", Date.class));
    definition.addParameter(new Parameter("endDate", "End Date", Date.class));
    definition.addParameter(new Parameter("location", "Location", Location.class));

    String query = ResumoMensalCetaQueries.QUERY.findPatientsWhoEndTrementIndicator23;

    definition.setQuery(query);

    return definition;
  }
}
