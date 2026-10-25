# DataHub (fixture)

Market and reference data hub. Serves prices, curves, and marks to the booking chain.

## Integrations (topology)

- Exposes `/api/v1/market-data` consumed by **Trading/Pricing**.
- Exposes `/api/v1/risk-market-data` consumed by **Analytics**.
- Exposes `/api/v1/marks` consumed by **PNL**.

## Data transiting on flows (Data Model fixture)

| Peer | Kind | data_category | Notes |
|------|------|---------------|-------|
| Trading/Pricing | API (inbound) | `MARKET_DATA` | quote inputs |
| Analytics | API (inbound) | `RISK_MARKET_DATA` | risk curves |
| PNL | API (inbound) | `MARK_TO_MARKET` | end-of-day marks |

See `TransitDataTypes.java` and `application.yml`.
