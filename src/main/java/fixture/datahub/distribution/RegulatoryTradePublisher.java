package fixture.datahub.distribution;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;

/** Regulatory trade distribution. DataHub pushes the daily trade to Regulatory. */
public class RegulatoryTradePublisher {

  public static final String PEER = "Regulatory";
  public static final String CHANNEL = "https://regulatory.internal/api/v1/trades";

  public MarketFlow publishToRegulatory() {
    return new MarketFlow(
        PEER, CHANNEL, TransitDataTypes.DATA_TRADE, TransitDataTypes.FREQUENCY_DAILY);
  }
}
