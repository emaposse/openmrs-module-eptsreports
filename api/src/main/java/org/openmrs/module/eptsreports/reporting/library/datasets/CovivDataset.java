package org.openmrs.module.eptsreports.reporting.library.datasets;

import java.util.Arrays;
import java.util.List;
import org.openmrs.module.eptsreports.reporting.library.cohorts.CovivCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.cohorts.ResumoMensalCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.cohorts.TxNewCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.dimensions.AgeDimensionCohortInterface;
import org.openmrs.module.eptsreports.reporting.library.dimensions.EptsCommonDimension;
import org.openmrs.module.eptsreports.reporting.library.indicators.EptsGeneralIndicator;
import org.openmrs.module.eptsreports.reporting.utils.EptsReportUtils;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CovivDataset extends BaseDataSet {
  @Autowired private EptsCommonDimension eptsCommonDimension;
  @Autowired private EptsGeneralIndicator eptsGeneralIndicator;
  @Autowired private TxNewCohortQueries txNewCohortQueries;
  @Autowired private CovivCohortQueries covivCohortQueries;
  @Autowired private ResumoMensalCohortQueries resumoMensalCohortQueries;

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public DataSetDefinition constructDatset() {
    final CohortIndicatorDataSetDefinition dataSetDefinition =
        new CohortIndicatorDataSetDefinition();
    dataSetDefinition.setParameters(getParameters());

    String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";

    dataSetDefinition.addDimension(
        "age",
        EptsReportUtils.map(
            eptsCommonDimension.age(ageDimensionCohort), "effectiveDate=${endDate}"));

    dataSetDefinition.addDimension("gender", EptsReportUtils.map(eptsCommonDimension.gender(), ""));

    dataSetDefinition.addDimension(
        "breastfeeding",
        EptsReportUtils.map(this.eptsCommonDimension.findPatientsWhoAreBreastfeeding(), mappings));

    // TX New
    final CohortDefinition patientEnrolledInART =
        this.txNewCohortQueries.getTxNewCompositionCohortMISAU("patientEnrolledInART");

    final CohortIndicator patientEnrolledInHIVStartedARTIndicator =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator",
            EptsReportUtils.map(patientEnrolledInART, mappings));

    // retencao 12 meses

    final CohortDefinition ret12MonthDen = covivCohortQueries.ret12Months();
    final CohortIndicator patientret12MontIndicatorDen =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(ret12MonthDen, mappings));
    final CohortDefinition ret12MonthNun = covivCohortQueries.ret12MonthsNumerator();
    final CohortIndicator patientret12MontIndicatorNun =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(ret12MonthNun, mappings));

    // PVLS NUN DEN

    final CohortDefinition pvlsDen = covivCohortQueries.pvlsDen();
    final CohortIndicator patientretPvlsIndicatorDen =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(pvlsDen, mappings));

    final CohortDefinition pvlsNun = covivCohortQueries.pvlsNun();
    final CohortIndicator patientPvlsIndicatorNun =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(pvlsNun, mappings));

    // TX CURR
    final CohortDefinition patientActiveInART =
        resumoMensalCohortQueries.findPatientsWhoAreCurrentlyEnrolledOnArtMOHB13();

    final CohortIndicator patientActiveIARTIndicator =
        this.eptsGeneralIndicator.getIndicator(
            "patientActiveInART", EptsReportUtils.map(patientActiveInART, mappings));

    // Ret 4 Months NUN DEN

    final CohortDefinition ret4MonthsDen = covivCohortQueries.ret4MonthsDenominator();
    final CohortIndicator patientret4MonthsIndicatorDen =
        this.eptsGeneralIndicator.getIndicator(
            "patientret4MonthsIndicatorDen", EptsReportUtils.map(ret4MonthsDen, mappings));

    final CohortDefinition ret4MonthsNun = covivCohortQueries.ret4MonthsNumerator();
    final CohortIndicator patientret4MonthsIndicatorNun =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(ret4MonthsNun, mappings));

    // Ret 6 Months NUN DEN

    final CohortDefinition ret6MonthsDen = covivCohortQueries.ret6MonthsDenominator();
    final CohortIndicator patientret6MonthsIndicatorDen =
        this.eptsGeneralIndicator.getIndicator(
            "patientret4MonthsIndicatorDen", EptsReportUtils.map(ret6MonthsDen, mappings));

    final CohortDefinition ret6MonthsNun = covivCohortQueries.ret6MonthsNumerator();
    final CohortIndicator patientret6MonthsIndicatorNun =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(ret6MonthsNun, mappings));

    // Ret 9 Months NUN DEN

    final CohortDefinition ret9MonthsDen = covivCohortQueries.ret9MonthsDenominator();
    final CohortIndicator patientret9MonthsIndicatorDen =
        this.eptsGeneralIndicator.getIndicator(
            "patientret4MonthsIndicatorDen", EptsReportUtils.map(ret9MonthsDen, mappings));

    final CohortDefinition ret9MonthsNun = covivCohortQueries.ret9MonthsNumerator();
    final CohortIndicator patientret9MonthsIndicatorNun =
        this.eptsGeneralIndicator.getIndicator(
            "patientNewlyEnrolledInHIVIndicator", EptsReportUtils.map(ret9MonthsNun, mappings));

    dataSetDefinition.addColumn(
        "TXNEWTOTAL",
        "TX_NEW",
        EptsReportUtils.map(patientEnrolledInHIVStartedARTIndicator, mappings),
        "");
    addRow(
        dataSetDefinition,
        "N",
        "TX New",
        EptsReportUtils.map(patientEnrolledInHIVStartedARTIndicator, mappings),
        getColumns());

    dataSetDefinition.addColumn(
        "RET12TOTAL",
        "RET12TOTAL",
        EptsReportUtils.map(patientret12MontIndicatorDen, mappings),
        "");
    dataSetDefinition.addColumn(
        "RET12TOTALN",
        "RET12TOTALN",
        EptsReportUtils.map(patientret12MontIndicatorNun, mappings),
        "");

    addRow(
        dataSetDefinition,
        "RT12D",
        "RT12D",
        EptsReportUtils.map(patientret12MontIndicatorDen, mappings),
        getColumns());

    addRow(
        dataSetDefinition,
        "RT12N",
        "RT12N",
        EptsReportUtils.map(patientret12MontIndicatorDen, mappings),
        getColumns());

    // adicionando coluns PVLS

    dataSetDefinition.addColumn(
        "PVLSTOTALDEN",
        "PVLSTOTALDEN",
        EptsReportUtils.map(patientretPvlsIndicatorDen, mappings),
        "");

    addRow(
        dataSetDefinition,
        "P",
        "P",
        EptsReportUtils.map(patientretPvlsIndicatorDen, mappings),
        getColumns());

    dataSetDefinition.addColumn(
        "PVLSTOTALDNUN",
        "PVLSTOTALDNUN",
        EptsReportUtils.map(patientPvlsIndicatorNun, mappings),
        "");
    addRow(
        dataSetDefinition,
        "PN",
        "PN",
        EptsReportUtils.map(patientPvlsIndicatorNun, mappings),
        getColumns());

    // adicionando Colunas TX_CURR

    dataSetDefinition.addColumn(
        "TXCURRTOTAL",
        "TXCURRTOTAL",
        EptsReportUtils.map(patientActiveIARTIndicator, mappings),
        "");
    addRow(
        dataSetDefinition,
        "C",
        "TX Curr",
        EptsReportUtils.map(patientActiveIARTIndicator, mappings),
        getColumns());

    // adicionando colunas 4 meses

    dataSetDefinition.addColumn(
        "RET4TOTAL", "RET4TOTAL", EptsReportUtils.map(patientret4MonthsIndicatorDen, mappings), "");
    dataSetDefinition.addColumn(
        "RET4TOTALN",
        "RET4TOTALN",
        EptsReportUtils.map(patientret4MonthsIndicatorNun, mappings),
        "");

    addRow(
        dataSetDefinition,
        "RT4D",
        "RT4D",
        EptsReportUtils.map(patientret4MonthsIndicatorDen, mappings),
        getColumns());

    addRow(
        dataSetDefinition,
        "RT4N",
        "RT4N",
        EptsReportUtils.map(patientret4MonthsIndicatorNun, mappings),
        getColumns());

    // adicionando colunas 6 meses

    dataSetDefinition.addColumn(
        "RET6TOTAL", "RET6TOTAL", EptsReportUtils.map(patientret6MonthsIndicatorDen, mappings), "");
    dataSetDefinition.addColumn(
        "RET6TOTALN",
        "RET6TOTALN",
        EptsReportUtils.map(patientret6MonthsIndicatorNun, mappings),
        "");

    addRow(
        dataSetDefinition,
        "RT6D",
        "RT6D",
        EptsReportUtils.map(patientret4MonthsIndicatorDen, mappings),
        getColumns());

    addRow(
        dataSetDefinition,
        "RT6N",
        "RT6N",
        EptsReportUtils.map(patientret4MonthsIndicatorNun, mappings),
        getColumns());

    // adicionando colunas 9 meses

    dataSetDefinition.addColumn(
        "RET9TOTAL", "RET9TOTAL", EptsReportUtils.map(patientret9MonthsIndicatorDen, mappings), "");
    dataSetDefinition.addColumn(
        "RET6TOTALN",
        "RET6TOTALN",
        EptsReportUtils.map(patientret9MonthsIndicatorNun, mappings),
        "");

    addRow(
        dataSetDefinition,
        "RT9D",
        "RT9D",
        EptsReportUtils.map(patientret9MonthsIndicatorDen, mappings),
        getColumns());

    addRow(
        dataSetDefinition,
        "RT9N",
        "RT9N",
        EptsReportUtils.map(patientret9MonthsIndicatorNun, mappings),
        getColumns());

    dataSetDefinition.addColumn(
        "RET4TOTALB",
        "RET4TOTALB",
        EptsReportUtils.map(patientret4MonthsIndicatorDen, mappings),
        "breastfeeding=breastfeeding");
    dataSetDefinition.addColumn(
        "RET4TOTALNB",
        "RET4TOTALNB",
        EptsReportUtils.map(patientret4MonthsIndicatorDen, mappings),
        "breastfeeding=breastfeeding");

    dataSetDefinition.addColumn(
        "RET6TOTALB",
        "RET6TOTALB",
        EptsReportUtils.map(patientret6MonthsIndicatorDen, mappings),
        "breastfeeding=breastfeeding");
    dataSetDefinition.addColumn(
        "RET6TOTALNB",
        "RET6TOTALNB",
        EptsReportUtils.map(patientret6MonthsIndicatorNun, mappings),
        "breastfeeding=breastfeeding");

    dataSetDefinition.addColumn(
        "RET9TOTALB",
        "RET9TOTALB",
        EptsReportUtils.map(patientret9MonthsIndicatorDen, mappings),
        "breastfeeding=breastfeeding");
    dataSetDefinition.addColumn(
        "RET9TOTALNB",
        "RET9TOTALNB",
        EptsReportUtils.map(patientret9MonthsIndicatorNun, mappings),
        "breastfeeding=breastfeeding");

    dataSetDefinition.addColumn(
        "RET12TOTALB",
        "RET12TOTALB",
        EptsReportUtils.map(patientret12MontIndicatorDen, mappings),
        "breastfeeding=breastfeeding");
    dataSetDefinition.addColumn(
        "RET12TOTALNB",
        "RET12TOTALB",
        EptsReportUtils.map(patientret12MontIndicatorNun, mappings),
        "breastfeeding=breastfeeding");

    return dataSetDefinition;
  }

  private List<ColumnParameters> getColumns() {

    ColumnParameters a1 = new ColumnParameters("<1", "<1", "gender=F|age=<1", "01");
    ColumnParameters a2 = new ColumnParameters("1-4", "1-4 years male", "gender=M|age=1-4", "02");
    ColumnParameters a3 = new ColumnParameters("5-9", "5-9 years male", "gender=M|age=5-9", "03");
    ColumnParameters a4 = new ColumnParameters("10-14", "10-14 male", "gender=M|age=10-14", "04");
    ColumnParameters a5 = new ColumnParameters("15-19", "15-19 male", "gender=M|age=15-19", "05");
    ColumnParameters a6 = new ColumnParameters("20-24", "20-24 male", "gender=M|age=20-24", "06");
    ColumnParameters a7 = new ColumnParameters("25-29", "25-29 male", "gender=M|age=25-29", "07");
    ColumnParameters a8 = new ColumnParameters("30-34", "30-34 male", "gender=M|age=30-34", "08");
    ColumnParameters a9 = new ColumnParameters("35-39", "35-39 male", "gender=M|age=35-39", "09");
    ColumnParameters a10 = new ColumnParameters("40-44", "40-44 male", "gender=M|age=40-44", "10");
    ColumnParameters a11 = new ColumnParameters("45-49", "45-49 male", "gender=M|age=45-49", "11");

    ColumnParameters a12 = new ColumnParameters("50-54", "50-54 male", "gender=M|age=50-54", "12");
    ColumnParameters a13 = new ColumnParameters("55-59", "55-59 male", "gender=M|age=55-59", "13");
    ColumnParameters a14 = new ColumnParameters("60-64", "60-64 male", "gender=M|age=60-64", "14");
    ColumnParameters a15 = new ColumnParameters("65+", "65+ male", "gender=M|age=65+", "15");
    ColumnParameters unknownF =
        new ColumnParameters("unknownF", "Unknown age", "gender=F|age=UK", "16");

    ColumnParameters a16 = new ColumnParameters("<1", "<1", "gender=F|age=<1", "17");
    ColumnParameters a17 =
        new ColumnParameters("1-4", "1-4 years female", "gender=F|age=1-4", "18");
    ColumnParameters a18 =
        new ColumnParameters("5-9", "5-9 years female", "gender=F|age=5-9", "19");
    ColumnParameters a19 =
        new ColumnParameters("10-14", "10-14 female", "gender=F|age=10-14", "20");
    ColumnParameters a20 =
        new ColumnParameters("15-19", "15-19 female", "gender=F|age=15-19", "21");
    ColumnParameters a21 =
        new ColumnParameters("20-24", "20-24 female", "gender=F|age=20-24", "22");
    ColumnParameters a22 =
        new ColumnParameters("25-29", "25-29 female", "gender=F|age=25-29", "23");
    ColumnParameters a23 =
        new ColumnParameters("30-34", "30-34 female", "gender=F|age=30-34", "24");
    ColumnParameters a24 =
        new ColumnParameters("35-39", "35-39 female", "gender=F|age=35-39", "25");
    ColumnParameters a25 =
        new ColumnParameters("40-44", "40-44 female", "gender=F|age=40-44", "26");
    ColumnParameters a26 =
        new ColumnParameters("45-49", "45-49 female", "gender=F|age=45-49", "27");

    ColumnParameters a27 =
        new ColumnParameters("50-54", "50-54 female", "gender=F|age=50-54", "28");
    ColumnParameters a28 =
        new ColumnParameters("55-59", "55-59 female", "gender=F|age=55-59", "29");
    ColumnParameters a29 =
        new ColumnParameters("60-64", "60-64 female", "gender=F|age=60-64", "30");
    ColumnParameters a30 = new ColumnParameters("65+", "65+ female", "gender=F|age=65+", "31");
    ColumnParameters unknownM =
        new ColumnParameters("unknownF", "Unknown age", "gender=F|age=UK", "32");

    return Arrays.asList(
        a1, a2, a3, a4, a5, a6, a7, a8, unknownF, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18,
        a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, unknownM);
  }
}
