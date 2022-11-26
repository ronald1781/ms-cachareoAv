INSERT INTO tbl_regions (id,name) VALUES (1,'amazonas');
INSERT INTO tbl_regions (id,name) VALUES (2,'apurimac');
INSERT INTO tbl_regions (id,name) VALUES (3,'lima');

INSERT INTO tbl_customers (id,number_id,first_name,last_name,email,photo_url,state,region_id)
VALUES (2,'12345678','Guido','Ramos','guidoramos@gmail.com','','CREATED',1L);