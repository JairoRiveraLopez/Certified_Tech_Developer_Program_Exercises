SET sql_mode = "ONLY_FULL_GROUP_BY";

-- Where
-- 1
SELECT name
FROM product
WHERE name like "mountain bike%";

-- 2
SELECT FirstName
FROM contact
WHERE FirstName LIKE "Y%";

-- Order by
-- Punto 1
SELECT Name, ListPrice
FROM product
ORDER BY ListPrice Desc
limit 5;

-- Operadores & joins
-- Punto 1
SELECT 
    CONCAT(FirstName, ' ', LastName) Nombre
FROM
    contact
WHERE
    LastName LIKE 'johnson%';

-- Punto 2
SELECT 
    ListPrice, Color
FROM
    product
WHERE
    ListPrice < 150 AND Color = 'red'
        OR ListPrice > 500 AND Color = 'black';
        
-- Función de agregación
-- Punto 1
SELECT MAX(OrderDate)
FROM SalesOrderHeader;

-- Punto 2
SELECT MIN(p.ListPrice)
FROM Product p
INNER JOIN productsubcategory psc 
ON p.ProductSubcategoryID = psc.ProductSubcategoryID
INNER JOIN productcategory pc
ON pc.ProductCategoryID = psc.ProductCategoryID
WHERE pc.Name = "Bikes";

-- GROUP BY 
-- Punto 1

SELECT ProductID, SUM(OrderQty) Total
FROM SalesOrderDetail
GROUP BY ProductID;

-- Having
-- Punto 1
SELECT SalesOrderID, SUM(OrderQty) Total
FROM salesorderdetail
GROUP BY SalesOrderID
HAVING Total > 20;

-- JOINS
-- Punto 1
SELECT 
    e.LoginID, sp.TerritoryID, sp.Bonus
FROM
    employee e
        INNER JOIN
    salesperson sp ON sp.SalesPersonID = e.EmployeeID;

-- Punto 2
SELECT p.Name, psc.ProductSubcategoryID
FROM product p
INNER JOIN productsubcategory psc 
on p.productsubcategoryID = psc.productsubcategoryID
where psc.Name = "wheels";

-- Punto 3
SELECT p.Name, psc.ProductSubcategoryID
FROM Product p
INNER JOIN productsubcategory psc 
ON p.ProductSubcategoryID = psc.ProductSubcategoryID
INNER JOIN productcategory pc
ON pc.ProductCategoryID = psc.ProductCategoryID
WHERE pc.Name != "Bikes";




