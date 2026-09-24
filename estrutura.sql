CREATE TABLE transacoes (
    id_transacao INT AUTO_INCREMENT PRIMARY KEY,
    id_conta_origem INT,
    id_conta_destino INT,
    valor DECIMAL(10,2),
    data_transacao DATETIME,
    FOREIGN KEY (id_conta_origem) REFERENCES contas(id_conta),
    FOREIGN KEY (id_conta_destino) REFERENCES contas(id_conta)
);
