USE event_portal;

SELECT
    e.event_id,
    e.title,
    AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS average_duration_minutes
FROM Events e
JOIN Sessions s ON s.event_id = e.event_id
GROUP BY e.event_id, e.title;
