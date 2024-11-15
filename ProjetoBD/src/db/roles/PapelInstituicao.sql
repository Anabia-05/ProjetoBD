CREATE ROLE PapelInstituicao;

GRANT SELECT ON instituicao TO PapelInstituicao;
GRANT SELECT ON usuario TO PapelInstituicao;
GRANT SELECT ON arquivo TO PapelInstituicao;

GRANT PapelInstituicao TO 'webdriver_user'@'localhost';
