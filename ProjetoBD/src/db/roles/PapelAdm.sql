-- 1. Criar a role PapelAdm
CREATE ROLE PapelAdm;

-- 2. Conceder permissões de leitura, inserção, atualização e exclusão em todas as tabelas do banco de dados
GRANT SELECT, INSERT, UPDATE, DELETE ON DATABASE seu_banco.* TO PapelAdm;


