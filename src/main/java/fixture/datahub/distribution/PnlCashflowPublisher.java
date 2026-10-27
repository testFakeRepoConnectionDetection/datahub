package fixture.datahub.distribution;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;

/** PNL cashflow distribution. DataHub pushes the daily cashflow to PNL. */
public class PnlCashflowPublisher {

  public static final String PEER = "PNL";
  public static final String CHANNEL = "https://pnl.internal/api/v1/cashflows";

  public MarketFlow publishToPnl() {
    return new MarketFlow(
        PEER, CHANNEL, TransitDataTypes.DATA_CASHFLOW, TransitDataTypes.FREQUENCY_DAILY);
  }
}
