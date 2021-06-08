create table zutaten
(
    IdZutat  int auto_increment,
    Zutat    char(30) not null,
    Menge    char(30) not null,
    fkRezept int      not null,
    constraint zutaten_IdZutat_uindex
        unique (IdZutat),
    constraint zutaten_rezeptliste_IdRezept_fk
        foreign key (fkRezept) references rezeptliste (IdRezept)
);

alter table zutaten
    add primary key (IdZutat);

INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (58, 'Zutat 1', 'Menge 1', 27);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (59, 'Zutat 2', 'Menge 2', 27);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (60, 'Zutat 3', 'Menge 3', 27);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (85, 'Zutat 1', 'Menge 1', 36);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (86, 'Zutat 2', 'Menge 2', 36);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (87, 'Zutat 3', 'Menge 3', 36);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (88, 'Zutat 1', 'Menge 1', 37);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (89, 'Zutat 2', 'Menge 2', 37);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (90, 'Zutat 3', 'Menge 3', 37);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (94, 'Mehl', '50g', 27);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (101, 'Zutat 1', 'Menge 1', 41);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (102, 'Zutat 2', 'Menge 2', 41);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (103, 'Zutat 3', 'Menge 3', 41);