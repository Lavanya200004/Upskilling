USE event_portal;

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Sessions s ON s.event_id = e.event_id
WHERE s.session_id IS NULL;
