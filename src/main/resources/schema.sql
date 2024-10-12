-- Tabela de Endereço
CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number INTEGER NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL
);

-- Tabela de Cliente
CREATE TABLE client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    document VARCHAR(14) NOT NULL UNIQUE,
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);