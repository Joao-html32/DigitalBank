
CREATE DATABASE IF NOT EXISTS digitalbank_db;
USE digitalbank_db;


CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS contas (
    id_conta INT AUTO_INCREMENT PRIMARY KEY,
    numero_conta VARCHAR(20) NOT NULL UNIQUE,
    id_cliente INT,
    tipo_conta VARCHAR(20) NOT NULL, 
    saldo DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS transacoes (
    id_transacao INT AUTO_INCREMENT PRIMARY KEY,
    id_conta_origem INT,
    id_conta_destino INT,
    tipo_transacao VARCHAR(30) NOT NULL, 
    valor DECIMAL(10, 2) NOT NULL,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_conta_origem) REFERENCES contas(id_conta),
    FOREIGN KEY (id_conta_destino) REFERENCES contas(id_conta)
);


INSERT INTO clientes (nome, cpf, email) VALUES 
('João Vitor', '12345678901', 'jaosantosvitor2006@gmail.com'),
('Cliente Teste', '98765432100', 'teste@email.com');

INSERT INTO contas (numero_conta, id_cliente, tipo_conta, saldo) VALUES 
('1001-5', 1, 'Corrente', 1500.00),
('2002-8', 2, 'Poupança', 500.50);
