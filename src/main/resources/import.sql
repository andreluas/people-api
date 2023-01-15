INSERT INTO tb_people (first_name, last_name, cpf, birth_date) VALUES ('Andre', 'Almeida', '41298519004', '1996-10-22');
INSERT INTO tb_people (first_name, last_name, cpf, birth_date) VALUES ('Lucas', 'Santos', '95089810087', '1998-11-02');
INSERT INTO tb_people (first_name, last_name, cpf, birth_date) VALUES ('Sabrina', 'Rosa', '50839993072', '2002-02-15');
INSERT INTO tb_people (first_name, last_name, cpf, birth_date) VALUES ('Maria', 'Lopes', '50516309013', '1990-08-08');
INSERT INTO tb_people (first_name, last_name, cpf, birth_date) VALUES ('Rafael', 'Montes', '30409854000', '1995-10-28');

INSERT INTO tb_address (address, number, district, city, state, zip_code, main, people_id) VALUES ('Rua das Flores', 10, 'Barra da Tijuca', 'Rio de Janeiro', 'RJ', '25775-180', true, 1);
INSERT INTO tb_address (address, number, district, city, state, zip_code, main, people_id) VALUES ('Rua Porto Lima', 15, 'Barra da Tijuca', 'Rio de Janeiro', 'RJ', '25775-160', true, 2);
INSERT INTO tb_address (address, number, district, city, state, zip_code, main, people_id) VALUES ('Rua Faria Lima', 25, 'São Paulo', 'São Paulo', 'SP', '28597-710', true, 3);
INSERT INTO tb_address (address, number, district, city, state, zip_code, main, people_id) VALUES ('Rua Rodrigo Brum', 115, 'São Paulo', 'São Paulo', 'SP', '28597-744', false, 1);
