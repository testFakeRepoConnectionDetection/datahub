package fixture.datahub;

import fixture.datahub.calculation.MarketValueCalculation;
import fixture.datahub.calculation.MarketValueCalculation.MarkedBook;
import fixture.datahub.distribution.PnlCashflowPublisher;
import fixture.datahub.distribution.PnlValuationPublisher;
import fixture.datahub.distribution.RegulatoryTradePublisher;
import fixture.datahub.ingestion.EndOfDayCashflowIntake;
import fixture.datahub.ingestion.EndOfDayTradeIntake;
import fixture.datahub.ingestion.RealtimeValuationIntake;
import fixture.datahub.reporting.PositionRiskReport;

/**
 * Market data hub for the Position and Risk pillar.
 *
 * <p>Market intake stores what Analytics and Booking push in. Market calculation marks that book.
 * Report generation writes the position and risk report. Market distribution republishes the facts
 * to PNL and Regulatory.
 */
public class DataHub {

  private final RealtimeValuationIntake realtimeValuationIntake = new RealtimeValuationIntake();
  private final EndOfDayTradeIntake endOfDayTradeIntake = new EndOfDayTradeIntake();
  private final EndOfDayCashflowIntake endOfDayCashflowIntake = new EndOfDayCashflowIntake();
  private final MarketValueCalculation marketValueCalculation = new MarketValueCalculation();
  private final PositionRiskReport positionRiskReport = new PositionRiskReport();
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

  public String generatePositionRiskReport() {
    MarkedBook markedBook =
        marketValueCalculation.mark(
            acceptRealtimeValuation(), acceptEndOfDayTrade(), acceptEndOfDayCashflow());
    return positionRiskReport.generate(markedBook);
  }
}
