insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Mato Grosso');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Brasilia');

insert into cidade (id, nome, estado_id) values (1, 'Cuiabá', 1);
insert into cidade (id, nome, estado_id) values (2, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (3, 'Ceilândia', 3);
insert into cidade (id, nome, estado_id) values (4, 'Várzea Grande', 1);
insert into cidade (id, nome, estado_id) values (5, 'Campinas', 2);

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '78118-800', 'Rua João Bueno', '1000', 'Centro');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Japidinho', 12, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('IndianFood', 5, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (id, descricao) values (1, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (3, 'Cartão de debito');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHA', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHA', 'Permite editar cozinhas');

