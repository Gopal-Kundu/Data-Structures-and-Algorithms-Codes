//https://leetcode.com/problems/confirmation-rate/description/?envType=study-plan-v2&envId=top-sql-50

# Write your MySQL query statement below
SELECT s.user_id, COALESCE(ROUND(AVG(c.action = 'confirmed'), 2), 0) AS confirmation_rate FROM
Signups s LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;