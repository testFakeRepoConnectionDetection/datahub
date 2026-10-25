package fixture.dto;

/**
 * Mark pushed to PNL.
 * flow data_category: MARK_TO_MARKET
 */
public record MarkToMarketDto(String book, String instrumentId, String mark, String asOfDate) {}
