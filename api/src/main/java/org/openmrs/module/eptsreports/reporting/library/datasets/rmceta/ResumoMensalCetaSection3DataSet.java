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
public class ResumoMensalCetaSection3DataSet extends BaseDataSet {

  @Autowired private EptsCommonDimension eptsCommonDimension;
  @Autowired private ResumoMensalCetaInjectIndicator resumoMensalCetaInjectIndicator;
  @Autowired private ResumoMensalCetaDimension resumoMensalCetaDimension;

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public CohortIndicatorDataSetDefinition constructDataSet() {

    final CohortIndicatorDataSetDefinition dataSetDefinition =
        new CohortIndicatorDataSetDefinition();
    dataSetDefinition.setName("Resumo Mensal CETA Secção 3");

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
        "RMCRM0",
        "Reintegrado/Ma Adesao: Nr de Pacientes que reunem critérios para o rastreio FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(0), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM1",
        "Reintegrado/Ma Adesao: Nr de Pacientes rastreados usando o FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(1), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM2",
        "Reintegrado/Ma Adesao: Nr de Pacientes com resultado Positivo no FICA BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(2), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM3",
        "Reintegrado/Ma Adesao: Nr de Pacientes referidos para o seguimento de Doenca Mental Grave (psiquiatria/fluxo normal)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(3), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM4",
        "Reintegrado/Ma Adesao: Nr de Pacientes com resultado positivo para Epilepsia",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(4), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM5",
        "Reintegrado/Ma Adesao: Nr de  Pacientes referidos para o seguimento  de Doença Mental Comum (Psicólogo)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(5), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM6",
        "Reintegrado/Ma Adesao: Nr de Pacientes que iniciaram o tratamento de SM - CETA",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(6), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM7",
        "Reintegrado/Ma Adesao:Nr de Pacientes em seguimento no CETA ate o final do mês",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(7), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM8",
        "Reintegrado/Ma Adesao: Nr de Pacientes com Ideação de Suicídio na entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(8), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM9",
        "Reintegrado/Ma Adesao: Nr de Pacientes com Tentaiva de Suicídio na entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(9), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM10",
        "Reintegrado/Ma Adesao: Nr de Pacientes com Ideação de Homicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(10), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM11",
        "Reintegrado/Ma Adesao: Nr de Pacientes com Tentativa de Homicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(11), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM12",
        "Reintegrado/Ma Adesao: Nr de pacientes com sintomas de depressão",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(12), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM13",
        "Reintegrado/Ma Adesao: Nr de pacientes com sintomas de ansiedade",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(13), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM14",
        "Reintegrado/Ma Adesao: Nr de pacientes com trauma",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(14), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM15",
        "Reintegrado/Ma Adesao: Nr de pacientes que consomem abusivamente bebidas alcoolicas",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(15), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM16",
        "Reintegrado/Ma Adesao: Nr de pacientes que consomem outras substâncias psicoactivas (ex. Canabis, marijuana, etc)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(16), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM17",
        "Reintegrado/Ma Adesao: Nr de pacientes que interromperam o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(17), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM18",
        "Reintegrado/Ma Adesao: Nr de pacientes referidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(18), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM19",
        "Reintegrado/Ma Adesao: Nr de pacientes transferidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(19), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM20",
        "Reintegrado/Ma Adesao: Nr de pacientes reintegrados",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(20), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM21",
        "Reintegrado/Ma Adesao: Nr de Óbitos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(21), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM22",
        "Reintegrado/Ma Adesao:Nr de Abandonos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(22), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCRM22",
        "Reintegrado/Ma Adesao:Nr de Pacientes que terminaram o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(23), mappings),
        getColumnsSection6());

    return dataSetDefinition;
  }

  private List<ColumnParameters> getColumnsSection6() {
    ColumnParameters fifteenTo19M =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 male", "gender=M|age=15-19|state=reintegreted", "01");
    ColumnParameters fifteenTo19F =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 female", "gender=F|age=15-19|state=reintegreted", "02");

    ColumnParameters twentyTo24M =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 male", "gender=M|age=20-24|state=reintegreted", "03");
    ColumnParameters twentyTo24F =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 female", "gender=F|age=20-24|state=reintegreted", "04");

    ColumnParameters twentyFivePlusM =
        new ColumnParameters(
            "fouty5To49M", "25+ male", "gender=M|age=25+|state=reintegreted", "05");

    ColumnParameters twentyFivePlusF =
        new ColumnParameters(
            "fouty5To49M", "25+ female", "gender=F|age=25+|state=reintegreted", "06");

    ColumnParameters totalM =
        new ColumnParameters("totalM", "total male", "gender=M|state=reintegreted", "07");

    ColumnParameters totalF =
        new ColumnParameters("totalF", "total female", "gender=F|state=reintegreted", "08");

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
