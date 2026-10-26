package fixture.flow;

/**
 * Edge attributes on DataHub flows.
 * grep: data frequency PV trade cashflow real-time daily
 */
public final class TransitDataTypes {

  /** Node attribute business_function for DataHub. */
  public static final String BUSINESS_FUNCTION = "MARKET_DATA";

  /** Node attribute pillar for DataHub. */
  public static final String PILLAR = "Position & Risk";

  public static final String DATA_PV = "PV";
  public static final String DATA_TRADE = "trade";
  public static final String DATA_CASHFLOW = "cashflow";
  public static final String FREQUENCY_REAL_TIME = "real-time";
  public static final String FREQUENCY_DAILY = "daily";

  private TransitDataTypes() {}
}
