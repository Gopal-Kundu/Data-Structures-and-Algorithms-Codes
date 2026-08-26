//https://leetcode.com/problems/students-and-examinations/?envType=study-plan-v2&envId=top-sql-50

# Write your MySQL query statement below
SELECT a.student_id, a.student_name, s.subject_name, COUNT(b.subject_name) AS attended_exams FROM 
Students a CROSS JOIN Subjects s
LEFT JOIN Examinations b
ON a.student_id = b.student_id
AND s.subject_name = b.subject_name
GROUP BY a.student_id, s.subject_name
ORDER BY a.student_id ASC;
