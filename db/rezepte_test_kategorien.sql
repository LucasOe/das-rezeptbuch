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

INSERT INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (4, '"Fleisch"', 27);
INSERT INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (5, '"Vegan"', 36);