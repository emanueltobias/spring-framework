INSERT INTO permissao VALUES (1, 'CADASTRAR_CIDADE');
INSERT INTO permissao VALUES (2, 'CADASTRAR_USUARIO');

INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1, 2);

insert into usuario_grupo (codigo_usuario, codigo_grupo) VALUES (
	(SELECT codigo FROM usuario WHERE email = 'admin@drinks.com'), 1);
