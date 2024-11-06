
    DELIMITER //

    CREATE TRIGGER after_arquivo_update
    AFTER UPDATE ON arquivo
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Arquivo atualizado', CURDATE(), CURTIME(), OLD.id_usuario, NEW.id_arquivo);
    END //

    DELIMITER ;
    