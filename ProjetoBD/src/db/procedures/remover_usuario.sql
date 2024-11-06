
    DELIMITER //

    CREATE PROCEDURE RemoverUsuario(
        IN p_id_usuario INT
    )
    BEGIN
        DELETE FROM usuario WHERE id_usuario = p_id_usuario;
    END //

    DELIMITER ;
    