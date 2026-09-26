DELIMITER $$

CREATE PROCEDURE pr_realizar_pix(
    IN p_conta_origem INT,
    IN p_conta_destino INT,
    IN p_valor DECIMAL(10,2)
)
BEGIN
   
    DECLARE v_saldo_origem DECIMAL(10,2);

   
    START TRANSACTION;

   
    SELECT saldo INTO v_saldo_origem 
    FROM contas 
    WHERE id_conta = p_conta_origem;

    IF v_saldo_origem < p_valor THEN
      
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Erro: Saldo insuficiente para realizar o Pix.';
    ELSE
        
        UPDATE contas 
        SET saldo = saldo - p_valor 
        WHERE id_conta = p_conta_origem;

        UPDATE contas 
        SET saldo = saldo + p_valor 
        WHERE id_conta = p_conta_destino;

       
        INSERT INTO transacoes (id_conta_origem, id_conta_destino, valor) 
        VALUES (p_conta_origem, p_conta_destino, p_valor);

        
        COMMIT;
    END IF;

END $$

DELIMITER ;
