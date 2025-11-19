package org.openmrs.module.eptsreports.reporting.library.cohorts;

import java.util.Date;
import org.openmrs.module.eptsreports.reporting.utils.EptsReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.CompositionCohortDefinition;
import org.openmrs.module.reporting.definition.library.DocumentedDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumoMensalCohortQueriesComposition {
  @Autowired private ResumoMensalCetaCohortQueries resumoMensalCetaCohortQueries;

  @DocumentedDefinition(
      value = "findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources")
  public CohortDefinition findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "SECONDCONSULTATION",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources(),
            mappings));

    definition.addSearch(
        "TROUT",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreTranferedOut(), mappings));

    definition.setCompositionString("SECONDCONSULTATION NOT TROUT");

    return definition;
  }

  @DocumentedDefinition(
      value = "findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources")
  public CohortDefinition getIdicator0() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    final String mappingsFicaBem =
        "startDate=${startDate-12m+1d},endDate=${startDate},location=${location}";

    definition.addSearch(
        "FICHAFICABEM",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1(),
            mappings));

    definition.addSearch(
        "FICHAFICABEMEEXCLUSION",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1(),
            mappingsFicaBem));

    definition.addSearch(
        "SECONDCONSULTATION",
        EptsReportUtils.map(
            this.findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources(),
            mappings));

    definition.addSearch(
        "TRIN",
        EptsReportUtils.map(resumoMensalCetaCohortQueries.findPatientsWhoTransferedIn(), mappings));

    definition.addSearch(
        "CV",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWithHighViralLoadResultInOtherSources(),
            mappings));

    definition.addSearch(
        "REINTEGRETED",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithScreeningCriteriaEqualsReintegratedOrPooradherenceInOtherSources(),
            mappings));

    definition.addSearch(
        "PSYCHOSOCIALFACTORS",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithScreeningCriteriaPsychosocialFactorsOnOtherSorces(),
            mappings));

    definition.setCompositionString(
        "FICHAFICABEM  OR (((SECONDCONSULTATION NOT TRIN)  OR CV OR REINTEGRETED OR PSYCHOSOCIALFACTORS) NOT(FICHAFICABEMEEXCLUSION))");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator2")
  public CohortDefinition getIdicator2() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator2");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "FICHAFICABEM",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1(),
            mappings));

    definition.addSearch(
        "POSITIVERESULT",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHavePositiveResultOnFichaFicaBemDuringReportingPeriodIndicator2(),
            mappings));

    definition.setCompositionString("FICHAFICABEM AND POSITIVERESULT");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator3")
  public CohortDefinition getIdicator3() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator3");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch("INDICATOR2", EptsReportUtils.map(this.getIdicator2(), mappings));

    definition.addSearch(
        "SEVEREMENTAL",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreReferedTwoFollowUpSeverelMentalDiseaseIndicator3(),
            mappings));

    definition.setCompositionString("INDICATOR2 AND SEVEREMENTAL");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator4")
  public CohortDefinition getIdicator4() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator4");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch("INDICATOR2", EptsReportUtils.map(this.getIdicator2(), mappings));

    definition.addSearch(
        "EPILEPSYP",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveEpilepsyPositiveResulteIndicator4(),
            mappings));

    definition.setCompositionString("INDICATOR2 AND EPILEPSYP");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator5")
  public CohortDefinition getIdicator5() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator5");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch("INDICATOR2", EptsReportUtils.map(this.getIdicator2(), mappings));

    definition.addSearch(
        "COMMUNMENTAL",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator5(),
            mappings));

    definition.setCompositionString("INDICATOR2 AND COMMUNMENTAL");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator8")
  public CohortDefinition getIdicator8() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator8");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA8",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveaIdeationSuicideAttemptAtTheEntranceIndicator8(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA8");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator9")
  public CohortDefinition getIdicator9() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator9");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA9",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator9(), mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA9");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator10")
  public CohortDefinition getIdicator10() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator10");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA10",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithHomicideIdeationAtTheEntranceIndicator10(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA10");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator11")
  public CohortDefinition getIdicator11() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator11");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA11",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithAtLeastOneAttemptedHomicedeAtEntry11(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA11");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator12")
  public CohortDefinition getIdicator12() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator12");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA12",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWithDepressionSymptomsIndicator12(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA12");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator13")
  public CohortDefinition getIdicator13() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator13");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "SMCETA13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWithAnxietySymptomsIndicator13(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND SMCETA13");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator14")
  public CohortDefinition getIdicator14() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator14");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "IT14",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWithTraumaSymptomsIndicator14(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND IT14");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator15")
  public CohortDefinition getIdicator15() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator15");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "IT15",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientswhoAbuseAlcoholicBeveragesIndicator15(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND IT15");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator16")
  public CohortDefinition getIdicator16() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator16");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "IT16",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientswhoConsumeOthePsychoactiveSubtancesIndicator16(),
            mappings));

    definition.setCompositionString("INDICATOR6 AND IT16");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator18")
  public CohortDefinition getIdicator18() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator16");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR17",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator17(),
            mappings));
    definition.addSearch(
        "REFERED",
        EptsReportUtils.map(
            resumoMensalCetaCohortQueries.findPatientsWhoAreReferedIndicator18(), mappings));

    definition.setCompositionString("INDICATOR17 AND REFERED");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator19")
  public CohortDefinition getIdicator19() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator19");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR17",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator17(),
            mappings));
    definition.addSearch(
        "TRANSFERED",
        EptsReportUtils.map(
            resumoMensalCetaCohortQueries.findPatientsWhoAreTransferedIndicator19(), mappings));

    definition.setCompositionString("INDICATOR17 AND TRANSFERED");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator20")
  public CohortDefinition getIdicator20() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator20");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR7",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator7(),
            mappings));

    definition.addSearch(
        "INDICATOR6",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
            mappings));

    definition.addSearch(
        "REINTEGRETED",
        EptsReportUtils.map(
            resumoMensalCetaCohortQueries.findPatientsWhoAreReintegretedIndicator20(), mappings));

    definition.setCompositionString("(INDICATOR7 NOT INDICATOR6) AND REINTEGRETED");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator21")
  public CohortDefinition getIdicator21() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator21");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR17",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator17(),
            mappings));
    definition.addSearch(
        "DIED",
        EptsReportUtils.map(
            resumoMensalCetaCohortQueries.findPatientsWhoAreDiedIndicator21(), mappings));

    definition.setCompositionString("INDICATOR17 AND DIED");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator22")
  public CohortDefinition getIdicator22() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator21");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR17",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator17(),
            mappings));
    definition.addSearch("INDICATOR18", EptsReportUtils.map(this.getIdicator18(), mappings));

    definition.addSearch("INDICATOR19", EptsReportUtils.map(this.getIdicator19(), mappings));

    definition.addSearch("INDICATOR20", EptsReportUtils.map(this.getIdicator20(), mappings));

    definition.addSearch("INDICATOR21", EptsReportUtils.map(this.getIdicator21(), mappings));

    definition.setCompositionString(
        "INDICATOR17 NOT(INDICATOR18 OR INDICATOR19 OR INDICATOR20 OR INDICATOR21)");

    return definition;
  }
}
