-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Fases de Ensino
-- - - - - - - - - - - - - - - - - - - - - - - - - -
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

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Matérias
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into materia
 (nome, id_disciplina)
 values
  ('Funções de Primeiro Grau', 1),
  ('Funções de Segundo Grau', 1),
  ('Verbos', 2),
  ('Predicados', 2);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Matérias
-- - - - - - - - - - - - - - - - - - - - - - - - - -
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

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Professores
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into professor
  (cpf, moderador, nome, senha)
values
  ('00000000000', 0, 'Teste 00', 'asdf1234'),
  ('07702439670', 1, 'Luan R. S. Santana', 'mrxavier123');

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into questao
  (enunciado, espacos, invalidada, nivel, publica, tipo_de_questao, id_autor, id_disciplina, id_fase_de_ensino, criado_em, atualizado_em)
values
  ('Esta é a terceira questão?', 3, 0, 1, 1, 1, 1, 1, 8, NOW(), NOW()),
  ('Esta é a segunda questão?', 3, 0, 2, 0, 1, 2, 2, 8, NOW(), NOW())
  ('Esta é a terceira questão?', 3, 0, 2, 0, 1, 2, 2, 8, NOW(), NOW());
-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Matérias das Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into materia_de_questao
  (questao_id, materia_id)
values
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4);
-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Opções das Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
INSERT INTO opcao_de_questao
  (texto, value, id_questao)
VALUES
  ('Primeira opção', true, 3),
  ('Segunda opção', false, 3),
  ('Terceira opção', false, 3),
  ('Quarta opção', false, 3);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Teste
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into teste
  (atualizado_em, criado_em, descricao, id_professor, id_disciplina, id_fase_de_ensino)
VALUES
  (NOW(), NOW(), 'Primeiro teste do sistema', 1, 2, 8);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Questões de Teste
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into questoes_de_teste
  (questao_id, teste_id)
values
  (2, 1),
  (3, 1);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Proposta de Invalidação
-- - - - - - - - - - - - - - - - - - - - - - - - - -

