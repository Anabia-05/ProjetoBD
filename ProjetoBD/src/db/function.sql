CREATE FUNCTION confere_data (idArquivoEscolhido INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE confere BOOLEAN;
    SET confere = (
        SELECT DATEDIFF(CURRENT_DATE, data_ultima_mod) > 100
        FROM arquivo
        WHERE idArquivo = idArquivoEscolhido
    );
    RETURN confere;
END;