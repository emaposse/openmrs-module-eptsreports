/** */
package org.openmrs.module.eptsreports.reporting.intergrated.library.cohorts;

import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Ignore;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.eptsreports.reporting.intergrated.utils.DefinitionsFGHLiveTest;
import org.openmrs.module.eptsreports.reporting.library.cohorts.TxNewCohortQueries;
import org.openmrs.module.eptsreports.reporting.utils.AgeRange;
import org.openmrs.module.reporting.cohort.EvaluatedCohort;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.common.DateUtil;
import org.openmrs.module.reporting.evaluation.EvaluationException;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

/** @author Stélio Moiane */
public class TxNewCohortDefinitionTest extends DefinitionsFGHLiveTest {

  @Autowired private TxNewCohortQueries txNewCohortQueries;

  @Ignore
  public void shouldFindPatientsNewlyEnrolledInART() throws EvaluationException {

    final Location location = Context.getLocationService().getLocation(6);
    final Date startDate = DateUtil.getDateTime(2018, 4, 21);
    final Date endDate = DateUtil.getDateTime(2018, 5, 20);
    final Date reportingEndDate = DateUtil.getDateTime(2018, 9, 20);

    final CohortDefinition txNewCompositionCohort =
        this.txNewCohortQueries
            .findPatientsNewlyEnrolledByAgeInAPeriodExcludingBreastFeedingAndPregnant(
                AgeRange.ADULT);

    final Map<Parameter, Object> parameters = new HashMap<>();
    parameters.put(new Parameter("cohortStartDate", "Start Date", Date.class), startDate);
    parameters.put(new Parameter("cohortEndDate", "End Date", Date.class), endDate);
    parameters.put(new Parameter("reportingEndDate", "End Date", Date.class), reportingEndDate);
    parameters.put(new Parameter("location", "Location", Location.class), location);

    final EvaluatedCohort evaluatedCohort =
        this.evaluateCohortDefinition(txNewCompositionCohort, parameters);

    assertFalse(evaluatedCohort.getMemberIds().isEmpty());
  }

  @Override
  protected String username() {
    return "admin";
  }

  @Override
  protected String password() {
    return "eSaude123";
  }
}