
    DELIMITER //

    CREATE PROCEDURE AtualizarPlano(
        IN p_id_plano INT,
        IN p_nome VARCHAR(40),
        IN p_duracao DOUBLE,
        IN p_data_aquisicao DATE,
        IN p_espaco_usuario DOUBLE
    )
    BEGIN
        UPDATE plano
        SET nome = p_nome, duracao = p_duracao, data_aquisicao = p_data_aquisicao, espaco_usuario = p_espaco_usuario
        WHERE id_plano = p_id_plano;
    END //

    DELIMITER ;
    