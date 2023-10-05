-- 建立DATABASE
CREATE DATABASE mydb;

-- 使用DATABASE
USE mydb;

-- 建立TABLE
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    phone_number VARCHAR(20)
);

-- 查詢TABLE結構
DESCRIBE student;

-- 增
INSERT INTO student (name, phone_number)
VALUES
    ('John', '555-1234'),
    ('Jane', '555-5678'),
    ('Bob', '555-9876');

-- 刪
DELETE FROM student
WHERE id = 1; -- 根據id刪除一個學生

-- 查
SELECT * FROM student;
SELECT * FROM student WHERE id = 2; -- 根據id查詢學生

-- 改
UPDATE student
SET phone_number = '999'
WHERE id = 3; -- 根據id更新學生的電子郵件

-- 刪除table
DROP TABLE student;
