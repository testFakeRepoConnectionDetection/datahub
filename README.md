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
- Pushes the real-time price to **Trading/Pricing** on `/api/v1/prices`.

## Data transiting on flows (Data Model fixture)

| Peer | direction | Kind | Channel | data | frequency |
|------|-----------|------|---------|------|-----------|
| Analytics | inbound | API | /api/v1/realtime-pv | `PV` | `real-time` |
| Booking | inbound | API | /api/v1/eod-trades | `trade` | `daily` |
| Booking | inbound | API | /api/v1/eod-cashflows | `cashflow` | `daily` |
| PNL | outbound | API | /api/v1/cashflows | `cashflow` | `daily` |
| PNL | outbound | API | /api/v1/pv | `PV` | `daily` |
| Regulatory | outbound | API | /api/v1/trades | `trade` | `daily` |
| Trading/Pricing | outbound | API | /api/v1/prices | `price` | `real-time` |

See `TransitDataTypes.java` and `application.yml` (`data`, `frequency`).

## Modules

The market data hub contains market intake, market calculation, report generation and market distribution.

| Module | Package | What it does |
|--------|---------|----------------|
| Market data hub | `fixture.datahub` | Holds intake, calculation, reporting and distribution for Position and Risk. |
| Market intake | `fixture.datahub.ingestion` | Receives market facts from Analytics and Booking. |
| Real-time valuation intake | `fixture.datahub.ingestion.RealtimeValuationIntake` | Analytics pushes `PV` at `real-time` on `/api/v1/realtime-pv`. |
| End-of-day trade intake | `fixture.datahub.ingestion.EndOfDayTradeIntake` | Booking pushes `trade` at `daily` on `/api/v1/eod-trades`. |
| End-of-day cashflow intake | `fixture.datahub.ingestion.EndOfDayCashflowIntake` | Booking pushes `cashflow` at `daily` on `/api/v1/eod-cashflows`. |
| Market calculation | `fixture.datahub.calculation` | Marks the book from the ingested PV, trade and cashflow. |
| Report generation | `fixture.datahub.reporting` | Builds the daily position and risk report from the market calculation. |
| Market distribution | `fixture.datahub.distribution` | Republishes stored facts to PNL and Regulatory. |
| PNL cashflow distribution | `fixture.datahub.distribution.PnlCashflowPublisher` | Pushes `cashflow` at `daily` to PNL `/api/v1/cashflows`. |
| PNL valuation distribution | `fixture.datahub.distribution.PnlValuationPublisher` | Pushes `PV` at `daily` to PNL `/api/v1/pv`. |
| Regulatory trade distribution | `fixture.datahub.distribution.RegulatoryTradePublisher` | Pushes `trade` at `daily` to Regulatory `/api/v1/trades`. |
