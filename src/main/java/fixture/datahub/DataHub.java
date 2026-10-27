package fixture.datahub;

import fixture.datahub.distribution.PnlCashflowPublisher;
import fixture.datahub.distribution.PnlValuationPublisher;
import fixture.datahub.distribution.RegulatoryTradePublisher;
import fixture.datahub.ingestion.EndOfDayCashflowIntake;
import fixture.datahub.ingestion.EndOfDayTradeIntake;
import fixture.datahub.ingestion.RealtimeValuationIntake;

/**
 * Market data hub for the Position and Risk pillar.
 *
 * <p>Market intake stores what Analytics and Booking push in. Market distribution republishes those
 * facts to PNL and Regulatory.
 */
public class DataHub {

  private final RealtimeValuationIntake realtimeValuationIntake = new RealtimeValuationIntake();
  private final EndOfDayTradeIntake endOfDayTradeIntake = new EndOfDayTradeIntake();
  private final EndOfDayCashflowIntake endOfDayCashflowIntake = new EndOfDayCashflowIntake();
  private final PnlCashflowPublisher pnlCashflowPublisher = new PnlCashflowPublisher();
  private final PnlValuationPublisher pnlValuationPublisher = new PnlValuationPublisher();
  private final RegulatoryTradePublisher regulatoryTradePublisher = new RegulatoryTradePublisher();

  public MarketFlow acceptRealtimeValuation() {
    return realtimeValuationIntake.acceptFromAnalytics();
  }

  public MarketFlow acceptEndOfDayTrade() {
    return endOfDayTradeIntake.acceptFromBooking();
  }

  public MarketFlow acceptEndOfDayCashflow() {
    return endOfDayCashflowIntake.acceptFromBooking();
  }

  public MarketFlow publishDailyCashflow() {
    return pnlCashflowPublisher.publishToPnl();
  }

  public MarketFlow publishDailyValuation() {
    return pnlValuationPublisher.publishToPnl();
  }

  public MarketFlow publishDailyTrade() {
    return regulatoryTradePublisher.publishToRegulatory();
  }
}
