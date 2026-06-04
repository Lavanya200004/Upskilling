USE event_portal;

SELECT
    e.city,
    AVG(f.rating) AS average_rating
FROM Events e
JOIN Feedback f ON f.event_id = e.event_id
GROUP BY e.city;
