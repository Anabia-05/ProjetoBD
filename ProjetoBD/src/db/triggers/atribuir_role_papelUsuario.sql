DELIMITER //

CREATE TRIGGER atribuir_role_papelusuario
AFTER INSERT ON usuario
FOR EACH ROW
BEGIN
    GRANT PapelUsuario to NEW.login

END//

DELIMITER ;
