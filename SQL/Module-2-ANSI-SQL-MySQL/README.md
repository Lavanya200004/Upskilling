# Module 2 - ANSI SQL Using MySQL

This folder contains the solved exercises from `Module 2-ANSI SQL Using MySQL (1).pdf`.

## Files

- `01_schema.sql` creates the `event_portal` database and all required tables.
- `02_sample_data.sql` inserts the sample dataset from the PDF.
- `03_all_solutions.sql` contains all 25 query solutions together.
- `solutions/` contains one separate `.sql` file per exercise.

## How to Run in MySQL

Run these first:

```sql
SOURCE 01_schema.sql;
SOURCE 02_sample_data.sql;
```

Then run any file from the `solutions` folder, or run:

```sql
SOURCE 03_all_solutions.sql;
```

## Exercise Files

1. `solutions/01_user_upcoming_events.sql`
2. `solutions/02_top_rated_events.sql`
3. `solutions/03_inactive_users.sql`
4. `solutions/04_peak_session_hours.sql`
5. `solutions/05_most_active_cities.sql`
6. `solutions/06_event_resource_summary.sql`
7. `solutions/07_low_feedback_alerts.sql`
8. `solutions/08_sessions_per_upcoming_event.sql`
9. `solutions/09_organizer_event_summary.sql`
10. `solutions/10_feedback_gap.sql`
11. `solutions/11_daily_new_user_count.sql`
12. `solutions/12_event_with_maximum_sessions.sql`
13. `solutions/13_average_rating_per_city.sql`
14. `solutions/14_most_registered_events.sql`
15. `solutions/15_event_session_time_conflict.sql`
16. `solutions/16_unregistered_active_users.sql`
17. `solutions/17_multi_session_speakers.sql`
18. `solutions/18_resource_availability_check.sql`
19. `solutions/19_completed_events_feedback_summary.sql`
20. `solutions/20_user_engagement_index.sql`
21. `solutions/21_top_feedback_providers.sql`
22. `solutions/22_duplicate_registrations_check.sql`
23. `solutions/23_registration_trends.sql`
24. `solutions/24_average_session_duration_per_event.sql`
25. `solutions/25_events_without_sessions.sql`

## Note

Some date-based queries use `CURDATE()`, so their output depends on the current date when you run them.
