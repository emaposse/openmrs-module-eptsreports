package org.openmrs.module.eptsreports.reporting.library.queries;

import org.openmrs.module.eptsreports.reporting.utils.CetaType;
import org.openmrs.module.eptsreports.reporting.utils.EptsQuerysUtils;

public class Ceta {
  private static final String CETA = "RM_CETA/RM_CETA_DESAGRAGATIONS.sql";

  public static final String findCetaDesagragation(final CetaType cetaType) {

    String query = EptsQuerysUtils.loadQuery(CETA);

    switch (cetaType) {
      case One:
        query = String.format(query, 1);
        break;

      case Two:
        query = String.format(query, 2);
        break;

      case Tree:
        query = String.format(query, 3);
        break;

      case Four:
        query = String.format(query, 4);
        break;
      case Five:
        query = String.format(query, 5);
        break;

      default:
        break;
    }

    return query;
  }
}
