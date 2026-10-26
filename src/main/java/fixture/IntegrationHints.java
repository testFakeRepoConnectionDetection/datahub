package fixture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Inbound PV from Analytics and trade plus cashflow from Booking.
 * Outbound cashflow and PV to PNL, trade to Regulatory.
 *
 * <p>Edge fields data and frequency. Two distinct flows to PNL: cashflow/daily and PV/daily.
 * Two distinct inbound flows from Booking: trade/daily and cashflow/daily.
 */
@RestController
@RequestMapping("/api/v1/realtime-pv")
public class IntegrationHints {

  // POST /api/v1/realtime-pv from Analytics — data PV, frequency real-time
  // POST /api/v1/eod-trades from Booking — data trade, frequency daily
  // POST /api/v1/eod-cashflows from Booking — data cashflow, frequency daily
  // HTTP POST pnl /api/v1/cashflows — data cashflow, frequency daily
  // HTTP POST pnl /api/v1/pv — data PV, frequency daily
  // HTTP POST regulatory /api/v1/trades — data trade, frequency daily
}
