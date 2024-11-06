
    DELIMITER //

    CREATE PROCEDURE AtualizarArquivo(
        IN p_id_arquivo INT,
        IN p_nome VARCHAR(30),
        IN p_tipo VARCHAR(10),
        IN p_permissoes_acesso VARCHAR(50),
        IN p_tamanho INT,
        IN p_data_ultima_mod DATE,
        IN p_localizacao VARCHAR(10),
        IN p_url VARCHAR(50),
        IN p_id_usuario INT
    )
    BEGIN
        UPDATE arquivo
        SET nome = p_nome, tipo = p_tipo, permissoes_acesso = p_permissoes_acesso, tamanho = p_tamanho,
            data_ultima_mod = p_data_ultima_mod, localizacao = p_localizacao, URL = p_url, id_usuario = p_id_usuario
        WHERE id_arquivo = p_id_arquivo;
    END //

    DELIMITER ;
    