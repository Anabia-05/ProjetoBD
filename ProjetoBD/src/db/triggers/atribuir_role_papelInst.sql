DELIMITER //

CREATE TRIGGER atribuir_role_papelInst
AFTER INSERT ON instituicao
FOR EACH ROW
BEGIN
    GRANT PapelUsuario to NEW.id_instituicao

END//

DELIMITER ;
