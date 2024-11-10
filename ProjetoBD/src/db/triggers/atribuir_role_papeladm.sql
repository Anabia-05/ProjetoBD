DELIMITER //

CREATE TRIGGER atribuir_role_papeladm
AFTER INSERT ON administrador
FOR EACH ROW
BEGIN
    -- Atribui a role PapelAdm ao usuário associado ao id_usuario_adm
    -- (id_usuario_adm está na tabela administrador, mas queremos usar o id_adm que acabou de ser inserido)
    
    -- Buscar o id_usuario_adm associado ao id_adm recém inserido e atribuir a role PapelAdm
    GRANT PapelAdm TO (
        SELECT u.login
        FROM usuario u
        WHERE u.id_usuario = (
            SELECT a.id_usuario_adm
            FROM administrador a
            WHERE a.id_adm = NEW.id_adm
        )
    );
END //

DELIMITER ;
