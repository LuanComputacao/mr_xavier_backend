-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Fases de Ensino
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into grade
  (name)
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
insert into knowledge
 (name, id_subject)
 values
  ('Funções de Primeiro Grau', 1),
  ('Funções de Segundo Grau', 1),
  ('Verbos', 2),
  ('Predicados', 2);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Matérias
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into subject
  (code, name)
values
  ('matem', 'Matemática'),
  ('Portu', 'Português'),
  ('fisic', 'Física'),
  ('biolo', 'Biologia'),
  ('quimi', 'Quimica'),
  ('histo', 'História'),
  ('socio', 'Sociologia'),
  ('filos', 'Filosofia'),
  ('ingle', 'Inglês');

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Professores
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into professor
  (cpf, moderador, name, senha)
values
  ('00000000000', 0, 'Test 00', 'asdf1234'),
  ('07702439670', 1, 'Luan R. S. Santana', 'mrxavier123');

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into question
  (enunciado, espacos, invalidada, nivel, publica, question_type, id_autor, id_subject, id_grade, criado_em, atualizado_em)
values
  ('Esta é a terceira questão?', 3, 0, 1, 1, 1, 1, 1, 8, NOW(), NOW()),
  ('Esta é a segunda questão?', 3, 0, 2, 0, 1, 2, 2, 8, NOW(), NOW()),
  ('Esta é a terceira questão?', 3, 0, 2, 0, 1, 2, 2, 8, NOW(), NOW());
-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Matérias das Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into question_knowledge
  (question_id, knowledge_id)
values
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4);
-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Opções das Questões
-- - - - - - - - - - - - - - - - - - - - - - - - - -
INSERT INTO opcao_de_question
  (texto, value, id_question)
VALUES
  ('Primeira opção', true, 3),
  ('Segunda opção', false, 3),
  ('Terceira opção', false, 3),
  ('Quarta opção', false, 3);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Test
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into test
  (atualizado_em, criado_em, descricao, id_professor, id_subject, id_grade)
VALUES
  (NOW(), NOW(), 'Primeiro test do sistema', 1, 2, 8),
  (NOW(), NOW(), 'Segundo test do sistema', 1, 2, 8);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Professor Utiliza Test
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into professor_utiliza_test
  (data_utilizacao, id_professor, id_test)
values
  (NOW(), 1, 1);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Questões de Test
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into questoes_de_test
  (question_id, test_id)
values
  (2, 1),
  (3, 1),
  (1, 2),
  (3, 2);

-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Proposta de Invalidação
-- - - - - - - - - - - - - - - - - - - - - - - - - -
insert into proposta_de_invalidacao
  (analisado_em, criado_em, justificativa, proposta, status, id_moderador, id_professor, id_question)
values
  (null, NOW(), 'Primeiro test de invalidação', 'Qualquer modificação', false, 2, 1, 1);
