   
    DELIMITER //

    CREATE PROCEDURE conta_usuarios (IN idArquivoEscolhido int)
    BEGIN
    DECLARE contUsuario INT DEFAULT 0;
    SELECT COUNT(DISTINCT idUsuario) AS contUsuario
    FROM arquivo
    WHERE idArquivo = idArquivoEscolhido;
    SELECT contUsuario 
    END //

    DELIMITER;