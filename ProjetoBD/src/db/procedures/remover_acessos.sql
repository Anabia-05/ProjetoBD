
    DELIMITER //

    CREATE PROCEDURE RemoverAcessoUsuarios(IN idArquivo INT)
    BEGIN

        DELETE FROM compartilhamento
        WHERE id_arquivo = idArquivo
        AND id_usuario != (SELECT id_dono FROM compartilhamento WHERE id_arquivo = idArquivo LIMIT 1);
    END //

    DELIMITER ;
