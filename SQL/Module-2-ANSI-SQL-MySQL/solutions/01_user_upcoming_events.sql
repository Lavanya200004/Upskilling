USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    u.city,
    e.event_id,
    e.title,
    e.start_date,
    e.end_date
FROM Users u
JOIN Registrations r ON r.user_id = u.user_id
JOIN Events e ON e.event_id = r.event_id
WHERE e.status = 'upcoming'
  AND e.city = u.city
ORDER BY e.start_date;
