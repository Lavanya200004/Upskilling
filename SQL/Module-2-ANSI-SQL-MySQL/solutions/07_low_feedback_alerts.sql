USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    e.event_id,
    e.title AS event_name,
    f.rating,
    f.comments
FROM Feedback f
JOIN Users u ON u.user_id = f.user_id
JOIN Events e ON e.event_id = f.event_id
WHERE f.rating < 3;
