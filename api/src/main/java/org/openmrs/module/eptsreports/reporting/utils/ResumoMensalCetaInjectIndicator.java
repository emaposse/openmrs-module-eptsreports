package org.openmrs.module.eptsreports.reporting.utils;

import java.util.Map;
import org.apache.commons.collections.map.HashedMap;
import org.openmrs.module.eptsreports.reporting.library.cohorts.ResumoMensalCetaCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.cohorts.ResumoMensalCohortQueriesComposition;
import org.openmrs.module.eptsreports.reporting.library.indicators.EptsGeneralIndicator;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumoMensalCetaInjectIndicator {

  @Autowired private ResumoMensalCohortQueriesComposition resumoMensalCohortQueriesComposition;
  @Autowired private ResumoMensalCetaCohortQueries reMensalCetaCohortQueries;
  @Autowired private EptsGeneralIndicator eptsGeneralIndicator;

  public CohortIndicator inject(int param) {

    @SuppressWarnings("unchecked")
    Map<Integer, CohortIndicator> cohorteMap = new HashedMap();

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    cohorteMap.put(
        0,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 0",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator0(), mappings)));

    cohorteMap.put(
        1,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 1",
            EptsReportUtils.map(
                this.reMensalCetaCohortQueries
                    .findPatientsWhoHaveFichaFicaBemDuringReportingPeriodIndicator1(),
                mappings)));

    cohorteMap.put(
        2,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 2",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator2(), mappings)));

    cohorteMap.put(
        3,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 3",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator3(), mappings)));

    cohorteMap.put(
        4,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 4",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator4(), mappings)));

    cohorteMap.put(
        5,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 5",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator5(), mappings)));

    cohorteMap.put(
        6,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 6",
            EptsReportUtils.map(
                this.reMensalCetaCohortQueries
                    .findPatientsWhoAreStartedSMTretmentInCetaInitialFormIndicator6(),
                mappings)));

    cohorteMap.put(
        7,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 7",
            EptsReportUtils.map(
                this.reMensalCetaCohortQueries
                    .findPatientsWhoAreFollowpCetaUntilTheEndOfMonthIndicator7(),
                mappings)));

    cohorteMap.put(
        8,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 8",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator8(), mappings)));

    cohorteMap.put(
        9,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 9",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator9(), mappings)));

    cohorteMap.put(
        10,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 10",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator10(), mappings)));

    cohorteMap.put(
        11,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 11",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator11(), mappings)));

    cohorteMap.put(
        12,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 12",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator12(), mappings)));

    cohorteMap.put(
        13,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 13",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator13(), mappings)));

    cohorteMap.put(
        14,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 13",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator14(), mappings)));

    cohorteMap.put(
        15,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 15",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator15(), mappings)));

    cohorteMap.put(
        16,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 16",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator16(), mappings)));

    cohorteMap.put(
        17,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 17",
            EptsReportUtils.map(
                this.reMensalCetaCohortQueries.findPatientsWhoAreInterruptTretmentIndicator17(),
                mappings)));

    cohorteMap.put(
        18,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 18",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator18(), mappings)));

    cohorteMap.put(
        19,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 19",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator19(), mappings)));

    cohorteMap.put(
        20,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 20",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator20(), mappings)));

    cohorteMap.put(
        21,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 21",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator21(), mappings)));

    cohorteMap.put(
        22,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 22",
            EptsReportUtils.map(
                this.resumoMensalCohortQueriesComposition.getIdicator22(), mappings)));

    cohorteMap.put(
        23,
        this.eptsGeneralIndicator.getIndicator(
            "indicator 23",
            EptsReportUtils.map(
                this.reMensalCetaCohortQueries.findPatientsWhoEndTrementIndicator23(), mappings)));

    return cohorteMap.get(param);
  }
}
