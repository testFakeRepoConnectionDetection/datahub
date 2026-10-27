package fixture.datahub.ingestion;

import fixture.datahub.MarketFlow;
import fixture.flow.TransitDataTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** End-of-day cashflow intake. Booking pushes the cashflow once a day. */
@RestController
@RequestMapping("/api/v1/eod-cashflows")
public class EndOfDayCashflowIntake {

  public static final String PEER = "Booking";
  public static final String CHANNEL = "/api/v1/eod-cashflows";

  @PostMapping
  public MarketFlow acceptFromBooking() {
    return new MarketFlow(
        PEER, CHANNEL, TransitDataTypes.DATA_CASHFLOW, TransitDataTypes.FREQUENCY_DAILY);
  }
}
