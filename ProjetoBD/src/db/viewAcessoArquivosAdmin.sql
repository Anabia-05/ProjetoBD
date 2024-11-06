CREATE VIEW acesso_arquivos_admin AS
SELECT 
    a.id_arquivo,
    a.nome,
    a.tipo,
    a.permissoes_acesso,
    a.tamanho,
    a.data_ultima_mod,
    a.localizacao,
    a.URL
FROM arquivo a;