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
    definition.addSearch(
        "FICHAFICABEM",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1(),
            mappings));

    definition.addSearch(
        "SECONDCONSULTATION",
        EptsReportUtils.map(
            this.findPatientsWithSecondArtConsultationDuringReportingPeriodOtherSources(),
            mappings));

    definition.addSearch(
        "CV",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWithHighViralLoadResultInOtherSources(),
            mappings));

    definition.addSearch(
        "PSYCHOSOCIALFACTORS",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWithScreeningCriteriaPsychosocialFactorsOnOtherSorces(),
            mappings));

    definition.setCompositionString(
        "FICHAFICABEM AND (SECONDCONSULTATION OR CV OR PSYCHOSOCIALFACTORS)");

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
        "COMMUNMENTAL",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreReferedTwoFollowUpCommonMentalDiseaseIndicator4(),
            mappings));

    definition.setCompositionString("INDICATOR2 AND COMMUNMENTAL");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator7")
  public CohortDefinition getIdicator7() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator7");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SUICEDE",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoHaveatAtLeastOneSuicideAttemptAtTheEntranceIndicator7(),
            mappings));

    definition.setCompositionString("INDICATOR5 AND SUICEDE");

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
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SMCETA8",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator8(), mappings));

    definition.setCompositionString("INDICATOR5 AND SMCETA8");

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
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SMCETA9",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator9(), mappings));

    definition.setCompositionString("INDICATOR5 AND SMCETA9");

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
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SMCETA10",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator10(),
            mappings));

    definition.setCompositionString("INDICATOR5 AND SMCETA10");

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
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SMCETA11",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator11(),
            mappings));

    definition.setCompositionString("INDICATOR5 AND SMCETA11");

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
        "INDICATOR5",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries
                .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator5(),
            mappings));

    definition.addSearch(
        "SMCETA12",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoStartedSMCetaIndicator12(),
            mappings));

    definition.setCompositionString("INDICATOR5 AND SMCETA12");

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
        "INDICATOR13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator13(),
            mappings));

    definition.addSearch(
        "IT14",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator14(),
            mappings));

    definition.setCompositionString("INDICATOR13 AND IT14");

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
        "INDICATOR13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator13(),
            mappings));

    definition.addSearch(
        "IT15",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator15(),
            mappings));

    definition.setCompositionString("INDICATOR13 AND IT15");

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
        "INDICATOR13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator13(),
            mappings));

    definition.addSearch(
        "IT16",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreReintegretedIndicator16(),
            mappings));

    definition.setCompositionString("INDICATOR13 AND IT16");

    return definition;
  }

  @DocumentedDefinition(value = "getIdicator17")
  public CohortDefinition getIdicator17() {
    final CompositionCohortDefinition definition = new CompositionCohortDefinition();

    definition.setName("getIdicator16");

    definition.addParameter(new Parameter("startDate", "Data Inicio Inclusão", Date.class));
    definition.addParameter(new Parameter("endDate", "Data Fim Inclusão", Date.class));
    definition.addParameter(new Parameter("location", "location", Date.class));

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    definition.addSearch(
        "INDICATOR13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator13(),
            mappings));

    definition.addSearch(
        "IT17",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreDiedIndicator17(), mappings));

    definition.setCompositionString("INDICATOR13 AND IT17");

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
        "INDICATOR13",
        EptsReportUtils.map(
            this.resumoMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator13(),
            mappings));

    definition.addSearch("INDICATOR14", EptsReportUtils.map(this.getIdicator14(), mappings));

    definition.addSearch("INDICATOR15", EptsReportUtils.map(this.getIdicator15(), mappings));
    definition.addSearch("INDICATOR16", EptsReportUtils.map(this.getIdicator16(), mappings));

    definition.addSearch("INDICATOR17", EptsReportUtils.map(this.getIdicator17(), mappings));

    definition.setCompositionString(
        "INDICATOR13 NOT(INDICATOR14 OR INDICATOR15 OR INDICATOR16 OR INDICATOR17)");

    return definition;
  }
}
