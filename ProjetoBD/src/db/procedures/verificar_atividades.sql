
    DELIMITER //

    CREATE PROCEDURE verificar_atividades()
    BEGIN
    UPDATE atividades_recentes
    SET ultima_versao = CURRENT_DATE
    END //

    DELIMITER;