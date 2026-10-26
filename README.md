# DataHub (fixture)

Business function: `MARKET_DATA` (`app.business_function`).
Pillar: `Position & Risk` (`app.pillar`).

Market and reference data hub.

## Integrations (topology)

- Receives real-time PV from **Analytics** on `/api/v1/realtime-pv`.
- Receives the end-of-day trade from **Booking** on `/api/v1/eod-trades`.
- Receives the end-of-day cashflow from **Booking** on `/api/v1/eod-cashflows`.
- Pushes the daily cashflow to **PNL** on `/api/v1/cashflows`.
- Pushes the daily PV to **PNL** on `/api/v1/pv`.
- Pushes the daily trade to **Regulatory** on `/api/v1/trades`.

## Data transiting on flows (Data Model fixture)

| Peer | direction | Kind | Channel | data | frequency |
|------|-----------|------|---------|------|-----------|
| Analytics | inbound | API | /api/v1/realtime-pv | `PV` | `real-time` |
| Booking | inbound | API | /api/v1/eod-trades | `trade` | `daily` |
| Booking | inbound | API | /api/v1/eod-cashflows | `cashflow` | `daily` |
| PNL | outbound | API | /api/v1/cashflows | `cashflow` | `daily` |
| PNL | outbound | API | /api/v1/pv | `PV` | `daily` |
| Regulatory | outbound | API | /api/v1/trades | `trade` | `daily` |

See `TransitDataTypes.java` and `application.yml` (`data`, `frequency`).
