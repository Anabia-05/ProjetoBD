
    DELIMITER //

    CREATE TRIGGER after_usuario_update
    AFTER UPDATE ON usuario
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Usuário atualizado', CURDATE(), CURTIME(), OLD.id_usuario, NULL);
    END //

    DELIMITER ;
    