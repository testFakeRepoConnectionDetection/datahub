package fixture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Market and reference data API. Inbound HTTP from Trading/Pricing, Analytics, and PNL.
 *
 * <p>data_category values: MARKET_DATA, RISK_MARKET_DATA, MARK_TO_MARKET
 * (see fixture.flow.TransitDataTypes).
 */
@RestController
@RequestMapping("/api/v1/market-data")
public class IntegrationHints {

  // POST /api/v1/market-data from Trading/Pricing — data_category MARKET_DATA
  // POST /api/v1/risk-market-data from Analytics — data_category RISK_MARKET_DATA
  // POST /api/v1/marks from PNL — data_category MARK_TO_MARKET
}
