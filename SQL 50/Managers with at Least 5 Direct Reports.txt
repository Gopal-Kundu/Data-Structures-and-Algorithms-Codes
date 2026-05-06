//https://leetcode.com/problems/managers-with-at-least-5-direct-reports/?envType=study-plan-v2&envId=top-sql-50

# Write your MySQL query statement below
SELECT e1.name FROM Employee e1
JOIN Employee e2
ON e1.id = e2.managerId
GROUP BY e2.managerId
HAVING COUNT(*) >= 5;