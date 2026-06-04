USE event_portal;

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Resources r ON r.event_id = e.event_id
WHERE r.resource_id IS NULL;
