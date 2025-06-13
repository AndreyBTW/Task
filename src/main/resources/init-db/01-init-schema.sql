CREATE DATABASE IF NOT EXISTS hoteldb;
CREATE DATABASE IF NOT EXISTS keycloak;

USE hoteldb;

CREATE TABLE IF NOT EXISTS addresses (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         zip_code VARCHAR(20),
    city VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    house VARCHAR(20) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS hotels (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(200) NOT NULL,
    address_id BIGINT NOT NULL,
    category VARCHAR(20),
    notes TEXT,
    FOREIGN KEY (address_id) REFERENCES addresses(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;