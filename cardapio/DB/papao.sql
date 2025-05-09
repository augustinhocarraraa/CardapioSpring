-- Criar o banco
CREATE DATABASE IF NOT EXISTS papao CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE papao;

-- Criar a tabela item_cardapio
CREATE TABLE IF NOT EXISTS item_cardapio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);
