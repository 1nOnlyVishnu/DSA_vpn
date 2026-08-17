# Write your MySQL query statement below
-- To use self


SELECT
    e.name as Employee
FROM Employee e 
JOIN Employee m
    ON e.managerId = m.id
WHERE e.salary > m.salary;