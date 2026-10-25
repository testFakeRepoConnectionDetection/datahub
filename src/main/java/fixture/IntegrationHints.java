package fixture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Market and reference data. Inbound HTTP from Analytics.
 * Outbound HTTP to PNL, Regulatory, and Accounting.
 *
 * <p>data_category values: RISK_MARKET_DATA, MARK_TO_MARKET, INSTRUMENT_REFERENCE, VALUATION_RATES
 * (see fixture.flow.TransitDataTypes).
 */
@RestController
@RequestMapping("/api/v1/risk-market-data")
public class IntegrationHints {

  // POST /api/v1/risk-market-data from Analytics — data_category RISK_MARKET_DATA
  // HTTP POST pnl /api/v1/marks — data_category MARK_TO_MARKET (fixture.dto.MarkToMarketDto)
  // HTTP POST regulatory /api/v1/instruments — data_category INSTRUMENT_REFERENCE
  //   (fixture.dto.InstrumentReferenceDto)
  // HTTP POST accounting /api/v1/valuation-rates — data_category VALUATION_RATES
  //   (fixture.dto.ValuationRatesDto)
}
