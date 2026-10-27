package fixture.datahub.reporting;

import fixture.datahub.calculation.MarketValueCalculation.MarkedBook;

/**
 * Report generation. Turns a marked book into the daily position and risk report.
 */
public class PositionRiskReport {

  public static final String MODULE_NAME = "Report generation";
  public static final String REPORT_NAME = "position-and-risk";

  public String generate(MarkedBook markedBook) {
    return REPORT_NAME
        + " valuation="
        + markedBook.valuationData()
        + " trade="
        + markedBook.tradeData()
        + " cashflow="
        + markedBook.cashflowData()
        + " frequency="
        + markedBook.frequency();
  }
}
