package fixture.datahub.distribution;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;

/** PNL valuation distribution. DataHub pushes the daily PV to PNL. */
public class PnlValuationPublisher {

  public static final String PEER = "PNL";
  public static final String CHANNEL = "https://pnl.internal/api/v1/pv";

  public MarketFlow publishToPnl() {
    return new MarketFlow(PEER, CHANNEL, TransitDataTypes.DATA_PV, TransitDataTypes.FREQUENCY_DAILY);
  }
}
