
    DELIMITER //

    CREATE PROCEDURE RemoverAcessoUsuarios(IN idArquivoEscolhido INT)
    BEGIN
        DELETE FROM compartilhamento
        WHERE id_arquivo = idArquivoEscolhido
        AND id_dono != (SELECT id_dono 
                        FROM compartilhamento 
                        WHERE id_arquivo = idArquivoEscolhido 
                        LIMIT 1);
    END //

    DELIMITER ;
