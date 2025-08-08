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
public class ResumoMensalCetaSection5DataSet extends BaseDataSet {

  @Autowired private EptsCommonDimension eptsCommonDimension;
  @Autowired private ResumoMensalCetaInjectIndicator resumoMensalCetaInjectIndicator;
  @Autowired private ResumoMensalCetaDimension resumoMensalCetaDimension;

  @Autowired
  @Qualifier("commonAgeDimensionCohort")
  private AgeDimensionCohortInterface ageDimensionCohort;

  public CohortIndicatorDataSetDefinition constructDataSet() {

    final CohortIndicatorDataSetDefinition dataSetDefinition =
        new CohortIndicatorDataSetDefinition();

    dataSetDefinition.setName("Resumo Mensal CETA Secção 5");

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
        "RMCSI0",
        "Sem Informacao: Nr de Pacientes que reunem critérios para o rastreio FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(0), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI1",
        "Sem Informacao: Nr de Pacientes rastreados usando o FICA-BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(1), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI2",
        "Sem Informacao: Nr de Pacientes com resultado Positivo no FICA BEM",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(2), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI3",
        "Sem Informacao: Nr de Pacientes referidos para o seguimento de Doenca Mental Grave (psiquiatria/fluxo normal)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(3), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI4",
        "Sem Informacao: Nr de Pacientes referidos para o seguimento de Doença Mental Comum (Psicólogo))",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(4), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI5",
        "Sem Informacao: Nr de Pacientes que iniciaram o tratamento de SM - CETA",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(5), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI6",
        "Sem Informacao: Nr de Pacientes em seguimento no CETA ate o final do mes)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(6), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI7",
        "Sem Informacao: Nr de Pacientes com, pelo menos, uma Tentativa de Suicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(7), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI8",
        "Sem Informacao: Nr de Pacientes com Tentativa de Homicídio a entrada",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(8), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI9",
        "Sem Informacao: Nr de pacientes com sintomas de ansiedade/depressão",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(9), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI10",
        "Sem Informacao: Nr de pacientes com trauma",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(10), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI11",
        "Sem Informacao: Nr de pacientes que consomem abusivamente bebidas alcoolicas",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(11), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI12",
        "Sem Informacao: Nr de pacientes que consomem outras substâncias psicoactivas (ex. Canabis, marijuana, etc)",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(12), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI13",
        "Sem Informacao: Nr de pacientes que interromperam o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(13), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI14",
        "Sem Informacao: Nr de pacientes referidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(14), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI15",
        "Sem Informacao: Nr de pacientes transferidos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(15), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI16",
        "Sem Informacao: Nr de pacientes reintegrados",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(16), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI17",
        "Sem Informacao: Nr de Óbitos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(17), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI18",
        "Sem Informacao: Nr de Abandonos",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(18), mappings),
        getColumnsSection6());

    addRow(
        dataSetDefinition,
        "RMCSI19",
        "Sem Informacao: Nr de Pacientes que terminaram o tratamento",
        EptsReportUtils.map(resumoMensalCetaInjectIndicator.inject(19), mappings),
        getColumnsSection6());

    return dataSetDefinition;
  }

  private List<ColumnParameters> getColumnsSection6() {
    ColumnParameters fifteenTo19M =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 male", "gender=M|age=15-19|state=exclusion", "01");
    ColumnParameters fifteenTo19F =
        new ColumnParameters(
            "fifteenTo19M", "15 - 19 female", "gender=F|age=15-19|state=exclusion", "02");

    ColumnParameters twentyTo24M =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 male", "gender=M|age=20-24|state=exclusion", "03");
    ColumnParameters twentyTo24F =
        new ColumnParameters(
            "twentyTo24M", "20 - 24 femele", "gender=F|age=20-24|state=exclusion", "04");

    ColumnParameters twentyFivePlusM =
        new ColumnParameters("fouty5To49M", "25+ male", "gender=M|age=25+|state=exclusion", "05");

    ColumnParameters twentyFivePlusF =
        new ColumnParameters("fouty5To49M", "25+ femele", "gender=F|age=25+|state=exclusion", "06");

    ColumnParameters totalF =
        new ColumnParameters("totalM", "total male", "gender=M|state=exclusion", "07");

    ColumnParameters totalM =
        new ColumnParameters("totalM", "total femele", "gender=F|state=exclusion", "08");

    return Arrays.asList(
        fifteenTo19M,
        twentyTo24M,
        twentyFivePlusM,
        fifteenTo19F,
        twentyTo24F,
        twentyFivePlusF,
        totalF,
        totalM);
  }
}
