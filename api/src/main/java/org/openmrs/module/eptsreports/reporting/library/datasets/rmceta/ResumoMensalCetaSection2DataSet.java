package org.openmrs.module.eptsreports.reporting.library.datasets.rmceta;

import java.util.Arrays;
import java.util.List;
import org.openmrs.module.eptsreports.reporting.library.datasets.BaseDataSet;
import org.openmrs.module.eptsreports.reporting.library.dimensions.AgeDimensionCohortInterface;
import org.openmrs.module.eptsreports.reporting.library.dimensions.EptsCommonDimension;
import org.openmrs.module.eptsreports.reporting.library.dimensions.ResumoMensalCetaDimension;
import org.openmrs.module.eptsreports.reporting.utils.EptsReportUtils;
import org.openmrs.module.eptsreports.reporting.utils.ResumoMensalCetaInjectIndicator;
import org.openmrs.module.reporting.dataset.definition.CohortIndicatorDataSetDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResumoMensalCetaSection2DataSet extends BaseDataSet {

  @Autowired private EptsCommonDimension eptsCommonDimension;
  @Autowired private ResumoMensalCetaInjectIndicator resumoMensalCetaInjectIndicator;
  @Autowired private ResumoMensalCetaDimension resumoMensalCetaDimension;

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public CohortIndicatorDataSetDefinition constructDataSet() {

    final CohortIndicatorDataSetDefinition dataSetDefinition =
        new CohortIndicatorDataSetDefinition();
    dataSetDefinition.setName("Resumo Mensal CETA Secção 2");

    dataSetDefinition.addParameters(this.getParameters());

    final String mappings = "startDate=${startDate},endDate=${endDate},location=${location}";
    dataSetDefinition.addDimension("gender", EptsReportUtils.map(eptsCommonDimension.gender(), ""));
    dataSetDefinition.addDimension(
        "age",
        EptsReportUtils.map(
            eptsCommonDimension.age(ageDimensionCohort), "effectiveDate=${endDate}"));
    dataSetDefinition.addDimension(
        "state",
        EptsReportUtils.map(this.resumoMensalCetaDimension.getResumoMensalDimension(), mappings));

    addRow(
        dataSetDefinition,
        "RMCCV0",
        "CV>1000 cp/ml: Nr de Pacientes que reunem critérios para o rastreio FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(0), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV1",
        "CV>1000 cp/ml: Nr de Pacientes rastreados usando o FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(1), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV2",
        "CV>1000 cp/ml: Nr de Pacientes com resultado Positivo no FICA BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(2), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV3",
        "CV>1000 cp/ml: Nr de Pacientes referidos para o seguimento de Doenca Mental Grave (psiquiatria/fluxo normal)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(3), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV4",
        "CV>1000 cp/ml: Nr de Pacientes com resultado positivo para Epilepsia",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(4), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV5",
        "CV>1000 cp/ml: Nr de  Pacientes referidos para o seguimento  de Doença Mental Comum (Psicólogo)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(5), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV6",
        "CV>1000 cp/ml: Nr de Pacientes que iniciaram o tratamento de SM - CETA",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(6), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV7",
        "CV>1000 cp/ml: Nr de Pacientes em seguimento no CETA ate o final do mês",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(7), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV8",
        "CV>1000 cp/ml: Nr de Pacientes com Ideação de Suicídio na entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(8), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV9",
        "CV>1000 cp/ml: Nr de Pacientes com Tentaiva de Suicídio na entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(9), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV10",
        "CV>1000 cp/ml: Nr de Pacientes com Ideação de Homicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(10), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV11",
        "CV>1000 cp/ml: Nr de Pacientes com Tentativa de Homicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(11), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV12",
        "CV>1000 cp/ml: Nr de pacientes com sintomas de depressão",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(12), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV13",
        "CV>1000 cp/ml: Nr de pacientes com sintomas de ansiedade",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(13), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV14",
        "CV>1000 cp/ml: Nr de pacientes com trauma",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(14), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV15",
        "CV>1000 cp/ml: Nr de pacientes que consomem abusivamente bebidas alcoolicas",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(15), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV16",
        "CV>1000 cp/ml: Nr de pacientes que consomem outras substâncias psicoactivas (ex. Canabis, marijuana, etc)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(16), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV17",
        "CV>1000 cp/ml: Nr de pacientes que interromperam o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(17), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV18",
        "CV>1000 cp/ml: Nr de pacientes referidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(18), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV19",
        "CV>1000 cp/ml: Nr de pacientes transferidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(19), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV20",
        "CV>1000 cp/ml: Nr de pacientes reintegrados",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(20), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV21",
        "CV>1000 cp/ml: Nr de Óbitos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(21), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV22",
        "CV>1000 cp/ml: Nr de Abandonos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(22), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCCV22",
        "CV>1000 cp/ml: Nr de Pacientes que terminaram o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(23), mappings),
        getColumnsSection6());

    return dataSetDefinition;
  }

  private List<ColumnParameters> getColumnsSection6() {
    ColumnParameters fifteenTo19M =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 male", "gender=M|age=15-19|state=high-vl", "01");
    ColumnParameters fifteenTo19F =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 female", "gender=F|age=15-19|state=high-vl", "02");

    ColumnParameters twentyTo24M =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 male", "gender=M|age=20-24|state=high-vl", "03");
    ColumnParameters twentyTo24F =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 female", "gender=F|age=20-24|state=high-vl", "04");

    ColumnParameters twentyFivePlusM =
        new ColumnParameters("fouty5To49M", "25+ male", "gender=M|age=25+|state=high-vl", "05");

    ColumnParameters twentyFivePlusF =
        new ColumnParameters("fouty5To49M", "25+ female", "gender=F|age=25+|state=high-vl", "06");

    ColumnParameters totalM =
        new ColumnParameters("totalM", "total male", "gender=M|state=high-vl", "07");

    ColumnParameters totalF =
        new ColumnParameters("totalF", "total female", "gender=F|state=high-vl", "08");

    return Arrays.asList(
        fifteenTo19M,
        twentyTo24M,
        twentyFivePlusM,
        fifteenTo19F,
        twentyTo24F,
        twentyFivePlusF,
        totalM,
        totalF);
  }
}
