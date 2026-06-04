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
USE event_portal;

SELECT
    e.event_id,
    e.title,
    AVG(f.rating) AS average_rating,
    COUNT(f.feedback_id) AS feedback_count
FROM Events e
JOIN Feedback f ON f.event_id = e.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY average_rating DESC;
USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.city
FROM Users u
LEFT JOIN Registrations r
    ON r.user_id = u.user_id
   AND r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
WHERE r.registration_id IS NULL;
USE event_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS sessions_between_10_and_12
FROM Events e
LEFT JOIN Sessions s
    ON s.event_id = e.event_id
   AND TIME(s.start_time) >= '10:00:00'
   AND TIME(s.start_time) < '12:00:00'
GROUP BY e.event_id, e.title;
USE event_portal;

SELECT
    e.city,
    COUNT(DISTINCT r.user_id) AS distinct_user_registrations
FROM Events e
JOIN Registrations r ON r.event_id = e.event_id
GROUP BY e.city
ORDER BY distinct_user_registrations DESC
LIMIT 5;
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
USE event_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON s.event_id = e.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;
USE event_portal;

SELECT
    u.user_id AS organizer_id,
    u.full_name AS organizer_name,
    e.status,
    COUNT(e.event_id) AS event_count
FROM Users u
JOIN Events e ON e.organizer_id = u.user_id
GROUP BY u.user_id, u.full_name, e.status
ORDER BY u.full_name, e.status;
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
USE event_portal;

SELECT
    registration_date,
    COUNT(user_id) AS new_user_count
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY registration_date
ORDER BY registration_date;
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
USE event_portal;

SELECT
    e.city,
    AVG(f.rating) AS average_rating
FROM Events e
JOIN Feedback f ON f.event_id = e.event_id
GROUP BY e.city;
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
USE event_portal;

SELECT
    e.event_id,
    e.title AS event_title,
    s1.session_id AS first_session_id,
    s1.title AS first_session_title,
    s2.session_id AS second_session_id,
    s2.title AS second_session_title
FROM Sessions s1
JOIN Sessions s2
    ON s1.event_id = s2.event_id
   AND s1.session_id < s2.session_id
   AND s1.start_time < s2.end_time
   AND s2.start_time < s1.end_time
JOIN Events e ON e.event_id = s1.event_id;
USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.registration_date
FROM Users u
LEFT JOIN Registrations r ON r.user_id = u.user_id
WHERE u.registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
  AND r.registration_id IS NULL;
USE event_portal;

SELECT
    speaker_name,
    COUNT(session_id) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1;
USE event_portal;

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Resources r ON r.event_id = e.event_id
WHERE r.resource_id IS NULL;
USE event_portal;

SELECT
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    AVG(f.rating) AS average_feedback_rating
FROM Events e
LEFT JOIN Registrations r ON r.event_id = e.event_id
LEFT JOIN Feedback f ON f.event_id = e.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;
USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM Users u
LEFT JOIN Registrations r ON r.user_id = u.user_id
LEFT JOIN Feedback f ON f.user_id = u.user_id
GROUP BY u.user_id, u.full_name;
USE event_portal;

SELECT
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) AS feedback_count
FROM Users u
JOIN Feedback f ON f.user_id = u.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;
USE event_portal;

SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;
USE event_portal;

SELECT
    DATE_FORMAT(registration_date, '%Y-%m') AS registration_month,
    COUNT(registration_id) AS registration_count
FROM Registrations
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY registration_month;
USE event_portal;

SELECT
    e.event_id,
    e.title,
    AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS average_duration_minutes
FROM Events e
JOIN Sessions s ON s.event_id = e.event_id
GROUP BY e.event_id, e.title;
USE event_portal;

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Sessions s ON s.event_id = e.event_id
WHERE s.session_id IS NULL;
