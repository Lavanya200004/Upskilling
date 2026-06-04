USE event_portal;

WITH session_counts AS (
    SELECT
        e.event_id,
        e.title,
        COUNT(s.session_id) AS session_count
    FROM Events e
    LEFT JOIN Sessions s ON s.event_id = e.event_id
    GROUP BY e.event_id, e.title
)
SELECT
    event_id,
    title,
    session_count
FROM session_counts
WHERE session_count = (
    SELECT MAX(session_count) FROM session_counts
);
