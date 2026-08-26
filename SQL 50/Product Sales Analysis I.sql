//https://leetcode.com/problems/product-sales-analysis-i/?envType=study-plan-v2&envId=top-sql-50

-- Write your PostgreSQL query statement below
SELECT p.product_name, s.year, s.price 
FROM Sales s 
JOIN Product p
ON s.product_id = p.product_id; 