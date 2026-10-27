package fixture.datahub;

/**
 * One market fact moving through DataHub: who exchanges it, on which channel, and the Data Model
 * edge attributes data and frequency.
 */
public record MarketFlow(String peerApplication, String channel, String data, String frequency) {}
