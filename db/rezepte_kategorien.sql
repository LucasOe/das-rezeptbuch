create table kategorien
(
    IdKategorie int auto_increment,
    Kategorie   char(30) not null,
    fkRezept    int      not null,
    constraint kategorien_IdKategorie_uindex
        unique (IdKategorie),
    constraint kategorien_rezeptliste_IdRezept_fk
        foreign key (fkRezept) references rezeptliste (IdRezept)
);

alter table kategorien
    add primary key (IdKategorie);

INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (1, 'Fleischgericht', 1);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (2, 'Vegetarisch', 2);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (3, 'Vegetarisch', 3);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (4, 'Vegetarisch', 4);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (5, 'Vegetarisch', 5);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (6, 'Fleischgericht', 6);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (7, 'Fleischgericht', 7);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (8, 'Vegan', 3);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (9, 'Fleischgericht', 8);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (10, 'Fischgericht', 9);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (11, 'Fischgericht', 10);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (12, 'Dessert', 11);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (13, 'Vegetarisch', 11);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (14, 'Dessert', 12);
INSERT INTO rezepte.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (15, 'Vegetarisch', 12);