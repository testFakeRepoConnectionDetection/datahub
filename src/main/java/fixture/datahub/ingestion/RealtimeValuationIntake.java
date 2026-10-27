package fixture.datahub.ingestion;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Real-time valuation intake. Analytics pushes PV at real-time frequency. */
@RestController
@RequestMapping("/api/v1/realtime-pv")
public class RealtimeValuationIntake {

  public static final String PEER = "Analytics";
  public static final String CHANNEL = "/api/v1/realtime-pv";

  @PostMapping
  public MarketFlow acceptFromAnalytics() {
    return new MarketFlow(
        PEER, CHANNEL, TransitDataTypes.DATA_PV, TransitDataTypes.FREQUENCY_REAL_TIME);
  }
}
