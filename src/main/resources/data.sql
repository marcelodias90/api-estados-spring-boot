CREATE TABLE IF NOT EXISTS  tb_uf( id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL, sigla VARCHAR(255) NOT NULL, status BOOLEAN)

INSERT INTO tb_uf (nome, sigla, status) VALUES ('MINAS GERAIS', 'MG', true), ('SÃO PAULO', 'SP', false)