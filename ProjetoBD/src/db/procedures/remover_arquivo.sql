
    DELIMITER //

    CREATE PROCEDURE RemoverArquivo(
        IN p_id_arquivo INT
    )
    BEGIN
        DELETE FROM arquivo WHERE id_arquivo = p_id_arquivo;
    END //

    DELIMITER ;
    