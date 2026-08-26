https://leetcode.com/problems/immediate-food-delivery-ii/?envType=study-plan-v2&envId=top-sql-50

# Write your MySQL query statement below
SELECT ROUND(
    SUM(order_date = customer_pref_delivery_date)*100.00/COUNT(*)
    ,2) AS immediate_percentage FROM Delivery
WHERE (customer_id, order_date) IN 
(SELECT customer_id, MIN(order_date) AS delivery_id
FROM Delivery
GROUP BY customer_id);