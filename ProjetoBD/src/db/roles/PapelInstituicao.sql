-- Criar a role PapelInstituicao
CREATE ROLE PapelInstituicao;

-- Conceder permissões de SELECT
GRANT SELECT ON instituicao TO PapelInstituicao;
GRANT SELECT ON usuario TO PapelInstituicao;
GRANT SELECT ON arquivo TO PapelInstituicao;


