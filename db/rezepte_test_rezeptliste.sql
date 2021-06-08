create table rezeptliste
(
    Name         char(120)  not null,
    IdRezept     int auto_increment,
    Favorit      tinyint(1) not null,
    Beschreibung text       not null,
    Zeit         int        not null,
    constraint rezeptliste_IdRezept_uindex
        unique (IdRezept)
)
    collate = utf8_unicode_ci;

alter table rezeptliste
    add primary key (IdRezept);

INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AA', 27, 0, 'Beschreibung', 15);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AN', 36, 0, 'Beschreibung', 30);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AO', 37, 0, 'Beschreibung', 25);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AP', 41, 0, 'Beschreibung', 40);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AK', 43, 0, 'Beschreibung', 120);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AG', 44, 0, 'Beschreibung', 60);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AE', 45, 0, 'Beschreibung', 30);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AM', 46, 0, 'Beschreibung', 45);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AH', 47, 0, 'Beschreibung', 150);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AL', 48, 0, 'Beschreibung', 35);
INSERT INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit) VALUES ('AI', 49, 0, 'Beschreibung', 135);