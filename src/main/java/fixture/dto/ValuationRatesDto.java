package fixture.dto;

/**
 * Valuation rates pushed to Accounting.
 * flow data_category: VALUATION_RATES
 */
public record ValuationRatesDto(String currency, String rate, String asOfDate) {}
