package fixture.flow;

/** Data categories served by DataHub. */
public final class TransitDataTypes {

  /** Node attribute business_function for DataHub. */
  public static final String BUSINESS_FUNCTION = "MARKET_DATA";

  public static final String RISK_MARKET_DATA = "RISK_MARKET_DATA";
  public static final String MARK_TO_MARKET = "MARK_TO_MARKET";
  public static final String INSTRUMENT_REFERENCE = "INSTRUMENT_REFERENCE";
  public static final String VALUATION_RATES = "VALUATION_RATES";

  public static final String PAYLOAD_FORMAT = "JSON";

  private TransitDataTypes() {}
}
