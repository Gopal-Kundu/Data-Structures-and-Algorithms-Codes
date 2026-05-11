//https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/?envType=study-plan-v2&envId=top-sql-50

-- Write your PostgreSQL query statement below
SELECT v.customer_id, COUNT(*) AS count_no_trans FROM Visits v
LEFT JOIN Transactions t on v.visit_id = t.visit_id 
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;