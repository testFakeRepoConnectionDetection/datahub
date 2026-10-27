package fixture.datahub.calculation;

import fixture.datahub.MarketFlow;

/**
 * Market calculation. Combines the ingested PV, trade and cashflow into one marked book.
 */
public class MarketValueCalculation {

  public static final String MODULE_NAME = "Market calculation";

  public MarkedBook mark(MarketFlow valuation, MarketFlow trade, MarketFlow cashflow) {
    return new MarkedBook(valuation.data(), trade.data(), cashflow.data(), valuation.frequency());
  }

  /** Result of the mark: the data kinds used and the valuation frequency. */
  public record MarkedBook(
      String valuationData, String tradeData, String cashflowData, String frequency) {}
}
