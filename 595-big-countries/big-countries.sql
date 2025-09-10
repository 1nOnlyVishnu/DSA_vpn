# Write your MySQL query statement below

Select  w.name ,w.population, w.area
From World as w
where area >= 3000000 
OR population >= 25000000