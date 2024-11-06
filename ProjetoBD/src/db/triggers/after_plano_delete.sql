
    DELIMITER //

    CREATE TRIGGER after_plano_delete
    AFTER DELETE ON plano
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Plano removido', CURDATE(), CURTIME(), 1, OLD.id_plano);
    END //

    DELIMITER ;
    