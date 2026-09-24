BEGIN
       
    DECLARE v_saldo_origem DECIMAL(10,2);

    
    SELECT saldo INTO v_saldo_origem 
    FROM contas 
    WHERE id_conta = p_conta_origem;

    
    IF v_saldo_origem < p_valor THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Erro: Saldo insuficiente para realizar o Pix.';
    END IF;
    UPDATE contas 
    SET saldo = saldo - p_valor 
    WHERE id_conta = p_conta_origem;
       
    UPDATE contas 
    SET saldo = saldo + p_valor 
    WHERE id_conta = p_conta_destino;

     INSERT INTO transacoes (id_conta_origem, id_conta_destino, valor, data_transacao)
    VALUES (p_conta_origem, p_conta_destino, p_valor, NOW());

END $$
