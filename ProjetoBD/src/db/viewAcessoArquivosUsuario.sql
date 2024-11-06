CREATE VIEW acesso_arquivos_usuario AS
SELECT 
    a.nome,
    a.tipo,
    a.permissoes_acesso,
    a.tamanho,
    a.data_ultima_mod,
    a.localizacao,
    a.URL
FROM arquivo a
JOIN compartilhamento c ON a.id_arquivo = c.id_arquivo
JOIN usuario u ON u.id_usuario = c.id_dono
WHERE u.id_usuario = CURRENT_USER();