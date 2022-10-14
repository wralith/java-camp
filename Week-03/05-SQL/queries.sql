-- Get customer if city matches
SELECT *
FROM Customers
WHERE City = "Istanbul";

-- Get product belong to category
SELECT *
FROM Products
WHERE CategoryID = 1
  or CategoryID = 2;

-- Order by Categories, default ascending order
SELECT *
FROM Products
ORDER BY CategoryID;

-- Get products belongs to category with ID 1 and order by higher price to lower
SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price DESC;

-- Rows of the Products table
SELECT COUNT(*) ProductCount
FROM Products;

-- Create two columns (CategoryID, ProductCount)
SELECT CategoryID,
  COUNT(*) ProductCount
FROM Products
WHERE Price > 10 -- Filter #1
GROUP BY CategoryID
HAVING count(*) < 10 -- Filter #2
;

-- Joins table to access columns in Categories table `Name` in this example
SELECT Products.ID,
  Products.Name,
  Products.Price,
  Categories.Name
FROM Products
  INNER JOIN Categories ON Products.CategoryID = Categories.ID;

-- Selects Customers which doesn't have relation with Orders
SELECT *
FROM Customers c
  LEFT JOIN Orders o ON c.ID = o.CustomerID
WHERE o.CustomerID IS NULL;