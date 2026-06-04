USE event_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(r.registration_id) AS registration_count
FROM Events e
JOIN Registrations r ON r.event_id = e.event_id
GROUP BY e.event_id, e.title
ORDER BY registration_count DESC
LIMIT 3;
