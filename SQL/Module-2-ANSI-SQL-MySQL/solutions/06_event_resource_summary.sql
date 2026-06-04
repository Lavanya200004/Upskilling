USE event_portal;

SELECT
    e.event_id,
    e.title,
    SUM(CASE WHEN res.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN res.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN res.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count,
    COUNT(res.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources res ON res.event_id = e.event_id
GROUP BY e.event_id, e.title;
