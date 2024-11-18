-- 1. Criar a role PapelAdm
CREATE ROLE PapelAdm;

-- 2. Conceder permissões de leitura, inserção, atualização e exclusão em todas as tabelas do banco de dados
GRANT SELECT, INSERT, UPDATE, DELETE ON DATABASE seu_banco.* TO PapelAdm;

-- 3. Conceder permissão de USAGE no banco de dados (necessário para acessar objetos dentro do banco)
GRANT USAGE ON SCHEMA public TO PapelAdm;

-- 4. Conceder permissões de leitura, inserção, atualização e exclusão em todas as tabelas e visões
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO PapelAdm;

-- 5. Conceder permissões para futuros objetos criados (novas tabelas)
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO PapelAdm;

GRANT PapelAdm TO 'webdriver_user'@'localhost';
