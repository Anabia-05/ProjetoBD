
    DELIMITER //

    CREATE TRIGGER after_usuario_delete
    AFTER DELETE ON usuario
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Usuário removido', CURDATE(), CURTIME(), OLD.id_usuario, NULL);
    END //

    DELIMITER ;
    