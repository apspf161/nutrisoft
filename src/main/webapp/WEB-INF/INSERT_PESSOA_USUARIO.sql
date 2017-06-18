select * from `nutrisoft`.`pessoa`
INSERT INTO `nutrisoft`.`pessoa`
(`dataNascimento`,
`sexo`,
`nome`,
`cpf`,
`email`,
`celular`)
VALUES
(
DATE('1988-03-21'),
'F',
'Bruna Vita Ashton',
'12358306754',
'brunavita@gmail.com',
'21994464817');

INSERT INTO `nutrisoft`.`usuario`
(`idUsuario`,
`dataUltimoAcesso`,
`login`,
`perfil`,
`senha`)
VALUES
(1, DATE('2017-06-08'),
'brunavita@gmail.com',
'ATENDENTE',
'81dc9bdb52d04dc20036dbd8313ed055');

SELECT t1.idPessoa,t1.nome,t1.email,t2.login,t2.perfil FROM pessoa t1,usuario t2 WHERE t2.idUsuario = t1.idPessoa and t2.login='brunavita@gmail.com' and t2.senha=md5('1234');