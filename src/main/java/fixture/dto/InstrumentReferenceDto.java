package fixture.dto;

/**
 * Instrument master pushed to Regulatory.
 * flow data_category: INSTRUMENT_REFERENCE
 */
public record InstrumentReferenceDto(String instrumentId, String isin, String assetClass) {}
