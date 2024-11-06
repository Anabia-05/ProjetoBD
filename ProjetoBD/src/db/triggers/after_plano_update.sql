
    DELIMITER //

    CREATE TRIGGER after_plano_update
    AFTER UPDATE ON plano
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Plano atualizado', CURDATE(), CURTIME(), 1, NEW.id_plano);
    END //

    DELIMITER ;
    