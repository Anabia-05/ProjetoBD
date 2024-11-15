CREATE ROLE PapelUsuario;

CREATE VIEW arquivos_usuario AS
SELECT * FROM arquivo WHERE id_usuario = :id_usuario;


GRANT SELECT, INSERT, UPDATE ON arquivos_usuario TO PapelUsuario;


GRANT PapelUsuario TO 'webdriver_user'@'localhost';