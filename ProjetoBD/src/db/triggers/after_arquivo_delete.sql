
    DELIMITER //

    CREATE TRIGGER after_arquivo_delete
    AFTER DELETE ON arquivo
    FOR EACH ROW
    BEGIN
        INSERT INTO historico (conteudo_mudado, data, hora, id_usuario_alterou, id_arquivo)
        VALUES ('Arquivo removido', CURDATE(), CURTIME(), OLD.id_usuario, OLD.id_arquivo);
    END //

    DELIMITER ;
    