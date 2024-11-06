
    DELIMITER //

    CREATE PROCEDURE RemoverPlano(
        IN p_id_plano INT
    )
    BEGIN
        DELETE FROM plano WHERE id_plano = p_id_plano;
    END //

    DELIMITER ;
    