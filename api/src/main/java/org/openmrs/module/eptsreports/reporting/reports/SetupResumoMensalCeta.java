/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.eptsreports.reporting.reports;

import static org.openmrs.module.reporting.evaluation.parameter.Mapped.mapStraightThrough;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openmrs.module.eptsreports.reporting.library.cohorts.GenericCohortQueries;
import org.openmrs.module.eptsreports.reporting.library.datasets.LocationDataSetDefinition;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection1DataSet;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection2DataSet;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection3DataSet;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection4DataSet;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection5DataSet;
import org.openmrs.module.eptsreports.reporting.library.datasets.rmceta.ResumoMensalCetaSection6DataSet;
import org.openmrs.module.eptsreports.reporting.reports.manager.EptsDataExportManager;
import org.openmrs.module.reporting.ReportingConstants;
import org.openmrs.module.reporting.ReportingException;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.PeriodIndicatorReportDefinition;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupResumoMensalCeta extends EptsDataExportManager {

  @Autowired private ResumoMensalCetaSection1DataSet resumoMensalCetaSection1DataSet;
  @Autowired private ResumoMensalCetaSection2DataSet resumoMensalCetaSection2DataSet;
  @Autowired private ResumoMensalCetaSection3DataSet resumoMensalCetaSection3DataSet;
  @Autowired private ResumoMensalCetaSection4DataSet resumoMensalCetaSection4DataSet;
  @Autowired private ResumoMensalCetaSection5DataSet resumoMensalCetaSection5DataSet;
  @Autowired private ResumoMensalCetaSection6DataSet resumoMensalCetaSection6DataSet;
  @Autowired protected GenericCohortQueries genericCohortQueries;

  @Override
  public String getVersion() {
    return "1.0-SNAPSHOT";
  }

  @Override
  public String getUuid() {
    return "fe7a0a50-6def-11f0-99a0-f3b27c980d18";
  }

  @Override
  public String getExcelDesignUuid() {
    return "05a19e2e-6df0-11f0-9278-67d4b763db14";
  }

  @Override
  public String getName() {
    return "Resumo Mensal CETA";
  }

  @Override
  public String getDescription() {
    return "Resumo Mensal CETA";
  }

  @Override
  public PeriodIndicatorReportDefinition constructReportDefinition() {

    PeriodIndicatorReportDefinition rd =
        SetupResumoMensalCeta.getDefaultPeriodIndicatorReportDefinition();

    rd.setUuid(getUuid());
    rd.setName(getName());
    rd.setDescription(getDescription());
    rd.addParameters(resumoMensalCetaSection6DataSet.getParameters());

    rd.addDataSetDefinition("HF", mapStraightThrough(new LocationDataSetDefinition()));

    rd.addDataSetDefinition(
        "R0", mapStraightThrough(resumoMensalCetaSection1DataSet.constructDataSet()));
    rd.addDataSetDefinition(
        "R1", mapStraightThrough(resumoMensalCetaSection2DataSet.constructDataSet()));
    rd.addDataSetDefinition(
        "R2", mapStraightThrough(resumoMensalCetaSection3DataSet.constructDataSet()));
    rd.addDataSetDefinition(
        "R3", mapStraightThrough(resumoMensalCetaSection4DataSet.constructDataSet()));
    rd.addDataSetDefinition(
        "R4", mapStraightThrough(resumoMensalCetaSection5DataSet.constructDataSet()));
    rd.addDataSetDefinition(
        "R", mapStraightThrough(resumoMensalCetaSection6DataSet.constructDataSet()));
    return rd;
  }

  @Override
  public List<ReportDesign> constructReportDesigns(ReportDefinition reportDefinition) {
    ReportDesign reportDesign = null;
    try {
      reportDesign =
          createXlsReportDesign(
              reportDefinition, "RM_CETA.xls", "Resumo Mensal Ceta", getExcelDesignUuid(), null);
      Properties props = new Properties();
      props.put("sortWeight", "5000");
      reportDesign.setProperties(props);
    } catch (IOException e) {
      throw new ReportingException(e.toString());
    }

    return Arrays.asList(reportDesign);
  }

  public static PeriodIndicatorReportDefinition getDefaultPeriodIndicatorReportDefinition() {
    PeriodIndicatorReportDefinition rd = new PeriodIndicatorReportDefinition();
    rd.removeParameter(ReportingConstants.START_DATE_PARAMETER);
    rd.removeParameter(ReportingConstants.END_DATE_PARAMETER);
    rd.removeParameter(ReportingConstants.LOCATION_PARAMETER);

    return rd;
  }
}
