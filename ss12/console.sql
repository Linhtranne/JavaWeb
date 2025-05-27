DROP DATABASE IF EXISTS ss12;
CREATE DATABASE ss12;
USE ss12;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE ,
    price DECIMAL(10, 2),
    description TEXT,
    image VARCHAR(255),
    status ENUM('AVAILABLE', 'NOT_AVAILABLE') DEFAULT 'AVAILABLE' NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);


DROP PROCEDURE IF EXISTS get_all_products;
CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM products;
END //

DROP PROCEDURE IF EXISTS get_product_by_id;
CREATE PROCEDURE get_product_by_id(IN product_id INT)
BEGIN
    SELECT * FROM products WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS add_product;
CREATE PROCEDURE add_product(
    IN product_name VARCHAR(150),
    IN product_price DECIMAL(10, 2),
    IN product_description TEXT,
    IN product_image VARCHAR(255)
)
BEGIN
    INSERT INTO products (name, price, description, image)
    VALUES (product_name, product_price, product_description, product_image);
END //

DROP PROCEDURE IF EXISTS update_product;
CREATE PROCEDURE update_product(
    IN product_id INT,
    IN product_name VARCHAR(150),
    IN product_price DECIMAL(10, 2),
    IN product_description TEXT,
    IN product_image VARCHAR(255)
)
BEGIN
    UPDATE products
    SET name = product_name,
        price = product_price,
        description = product_description,
        image = product_image
    WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS delete_product;
CREATE PROCEDURE delete_product(IN product_id INT)
BEGIN
    DELETE FROM products WHERE id = product_id;
END //

DROP PROCEDURE IF EXISTS search_products;
CREATE PROCEDURE search_products(IN search_term VARCHAR(150))
BEGIN
    SELECT * FROM products
    WHERE name LIKE CONCAT('%', search_term, '%');
END //

DELIMITER ;