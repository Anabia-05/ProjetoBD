
    DELIMITER //

    CREATE PROCEDURE AtualizarUsuario(
        IN p_id_usuario INT,
        IN p_login VARCHAR(40),
        IN p_senha VARCHAR(10),
        IN p_data_ingresso DATE,
        IN p_email VARCHAR(40),
        IN p_id_instituicao INT
    )
    BEGIN
        UPDATE usuario
        SET login = p_login, senha = p_senha, data_ingresso = p_data_ingresso, email = p_email, id_instituicao = p_id_instituicao
        WHERE id_usuario = p_id_usuario;
    END //

    DELIMITER ;
    