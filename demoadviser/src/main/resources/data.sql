CREATE TABLE IF NOT EXISTS tbl_categorias(ID LONG PRIMARY KEY, NAME VARCHAR(100));
CREATE TABLE IF NOT EXISTS tbl_productos(ID VARCHAR(255) PRIMARY KEY, NAME VARCHAR(100), description VARCHAR(255), stock NUMERIC,price NUMERIC,status VARCHAR(20), create_at TIMESTAMP, category_id NUMERIC);

INSERT INTO tbl_categorias (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categorias (id, name) VALUES (2, 'books');
INSERT INTO tbl_categorias (id, name) VALUES (3, 'electronics');

INSERT INTO tbl_productos (id, name, description, stock,price,status, create_at,category_id)
VALUES (1, 'adidas Cloudfoam Ultimate','Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',1);

INSERT INTO tbl_productos (id, name, description, stock,price,status, create_at,category_id)
VALUES (2, 'under armour Men ''s Micro G Assert – 7','under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',1);


INSERT INTO tbl_productos (id, name, description, stock,price,status, create_at,category_id)
VALUES (3, 'Spring Boot in Action','under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);
