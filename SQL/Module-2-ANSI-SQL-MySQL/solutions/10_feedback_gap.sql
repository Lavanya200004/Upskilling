USE event_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) AS registration_count
FROM Events e
JOIN Registrations r ON r.event_id = e.event_id
LEFT JOIN Feedback f ON f.event_id = e.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title;
