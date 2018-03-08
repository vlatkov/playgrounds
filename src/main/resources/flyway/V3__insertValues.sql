INSERT INTO role(name, description) VALUE ('ROLE_ADMIN', 'Rola administratora profila');
INSERT INTO role(name, description) VALUE ('ROLE_USER', 'Rola korisničkog profila');
INSERT INTO role(name, description) VALUE ('ROLE_SUPERUSER', 'Rola superuser profila');

INSERT into country(name, code, flag_url) VALUES("Crna Gora", "382", null);
INSERT into country(name, code, flag_url) VALUES("Srbija", "381", null);
INSERT into country(name, code, flag_url) VALUES("Republika Srpska", "387", null) ;
INSERT into country(name, code, flag_url) VALUES("Hrvatska", "385", null);

INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Podgorica",81000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (2,"Beograg",11000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (2,"Novi Sad",21000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (3,"Banjaluka",84000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Žabljak",52000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Nikšić",82000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Budva",89000,null);
INSERT INTO city(country_id, name, code, flag_url) VALUES (1,"Kotor",25000,null);

INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Zagorič",81120, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Tološi",81130, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Stari Aerodrom",81150, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Masline",81420, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Zelenika",81620, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Drač",81162, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (1,"Centar",81100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (5,"Ravni Žabljak",52100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Blok 1",11100, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Banovo Brdo",11103, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Žarkovo",11120, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (2,"Blok 45",11150, null);
INSERT INTO region(city_id, name, code, flag_url) VALUES (3,"Liman",21150, null);
