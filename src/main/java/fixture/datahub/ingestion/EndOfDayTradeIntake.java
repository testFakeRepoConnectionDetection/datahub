package fixture.datahub.ingestion;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** End-of-day trade intake. Booking pushes the trade once a day. */
@RestController
@RequestMapping("/api/v1/eod-trades")
public class EndOfDayTradeIntake {

  public static final String PEER = "Booking";
  public static final String CHANNEL = "/api/v1/eod-trades";

  @PostMapping
  public MarketFlow acceptFromBooking() {
    return new MarketFlow(
        PEER, CHANNEL, TransitDataTypes.DATA_TRADE, TransitDataTypes.FREQUENCY_DAILY);
  }
}
