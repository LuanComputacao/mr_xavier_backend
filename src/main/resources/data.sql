insert into disciplina
  (nome)
values
  ('Matemática'),
  ('Português'),
  ('Física'),
  ('Biologia'),
  ('Quimica'),
  ('História'),
  ('Sociologia'),
  ('Filosofia'),
  ('Inglês');

insert into fase_de_ensino
  (nome)
values
  ('1° Ano - Ensino Fundamental'),
  ('2° Ano - Ensino Fundamental'),
  ('3° Ano - Ensino Fundamental'),
  ('4° Ano - Ensino Fundamental'),
  ('5° Ano - Ensino Fundamental'),
  ('6° Ano - Ensino Fundamental'),
  ('7° Ano - Ensino Fundamental'),
  ('8° Ano - Ensino Fundamental'),
  ('9° Ano - Ensino Fundamental'),
  ('1° Ano - Ensino Médio'),
  ('2° Ano - Ensino Médio'),
  ('3° Ano - Ensino Médio');

insert into professor
  (cpf, moderador, nome, senha)
values
  ('00000000000', 0, 'Teste 00', 'asdf1234'),
  ('07702439670', 1, 'Luan R. S. Santana', 'mrxavier123');



insert into questao
  (enunciado, espacos, invalidada, nivel, publica, tipo_de_questao, id_autor, id_disciplina, id_fase_de_ensino, criado_em, atualizado_em)
values
  ('Esta é a terceira questão?', 3, 0, 1, 1, 1, 1, 1, 8, NOW(), NOW()),
  ('Esta é a segunda questão?', 3, 0, 2, 0, 1, 2, 2, 8, NOW(), NOW());
