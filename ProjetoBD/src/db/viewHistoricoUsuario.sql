CREATE VIEW historico_usuario AS
SELECT 
    h.conteudo_mudado,
    h.data,
    h.hora,
    u.login AS usuario_que_alterou
FROM historico h
JOIN usuario u ON u.id_usuario = h.id_usuario_alterou
WHERE h.id_arquivo IN (
    SELECT id_arquivo
    FROM arquivo
    WHERE id_usuario = CURRENT_USER()
);