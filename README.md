# DataHub (fixture)

Business function: `MARKET_DATA` (`app.business_function`).
Pillar: `Position & Risk` (`app.pillar`).

Market and reference data hub.

## Integrations (topology)

- Exposes `/api/v1/risk-market-data` consumed by **Analytics**.
- Pushes marks to **PNL** on `/api/v1/marks`.
- Pushes instrument reference data to **Regulatory** on `/api/v1/instruments`.
- Pushes valuation rates to **Accounting** on `/api/v1/valuation-rates`.

## Data transiting on flows (Data Model fixture)

| Peer | Kind | direction | data_category | Notes |
|------|------|-----------|---------------|-------|
| Analytics | API | inbound | `RISK_MARKET_DATA` | risk curves |
| PNL | API | outbound | `MARK_TO_MARKET` | end-of-day marks |
| Regulatory | API | outbound | `INSTRUMENT_REFERENCE` | instrument master |
| Accounting | API | outbound | `VALUATION_RATES` | rates used by the ledger |

See `TransitDataTypes.java` and `application.yml`.
