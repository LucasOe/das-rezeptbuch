create table zutaten
(
    IdZutat  int auto_increment,
    Zutat    char(50) not null,
    Menge    char(50) not null,
    fkRezept int      not null,
    constraint zutaten_IdZutat_uindex
        unique (IdZutat),
    constraint zutaten_rezeptliste_IdRezept_fk
        foreign key (fkRezept) references rezeptliste (IdRezept)
);

alter table zutaten
    add primary key (IdZutat);

INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (1, 'Hühnerbrühe', '400 ml', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (2, 'Hähnchenfleisch', '250 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (3, 'Möhren', '150 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (4, 'Champignons', '150 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (5, 'Tiefkühlerbsen', '150 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (6, 'Butter', '25 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (7, 'Mehl', '25 g', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (8, 'Sahne', '100 ml', 1);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (9, 'Mozzarella oder Büffelmozzarella', '125 g', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (10, 'Aubergine', '1 Stk.', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (11, 'Zucchini', '2 Stk.', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (12, 'Tomaten', '3-4 Stk.', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (13, 'Schalotten', '3 Stk.', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (14, 'Knoblauchzehen', '2 Stk.', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (15, 'Olivenöl', '8 EL', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (16, 'Chiliflocken', '1 Messerspitze', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (17, 'Tomatenmark', '1 1/2 EL', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (18, 'Salz und Pfeffer', 'Abschmecken', 2);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (19, 'Zwiebel', '1 Stk.', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (20, 'Knoblauchzehen', '2-3 Stk.', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (21, 'Thymian', '1 TL', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (22, 'Karotten', '3 Stk.', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (23, 'Blumenkohl', '400 g', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (24, 'Kartoffeln', '2 Stk.', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (25, 'Weiße Bohnen', '200 g', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (26, 'Grünkohl', '100 g', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (27, 'Gemüsebrühe', '1 Liter', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (28, 'Meersalz', '1 Prise', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (29, 'Schwarzer Pfeffer', '1 Prise', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (30, 'Petersilie', '1/2 Bund', 3);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (31, 'Rote Linsen', '300 g', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (32, 'Ingwer', '10 g', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (33, 'Zwiebeln', '2 Stk.', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (34, 'Öl', '3 EL', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (35, 'Kreuzkümmel', '1/2 TL', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (36, 'Garam Masala', '1 TL', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (37, 'Senfsamen', '1 TL', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (38, 'Tomaten', '3 Stk.', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (39, 'Blumenkohl', '500 g', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (40, 'Koriander oder Petersilie', '3 Stiele', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (41, 'Salz und Pfeffer', '1 Prise', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (42, 'Zitrone', '1/2 Stk.', 4);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (43, 'Reis', '170 g', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (44, 'Frühlingszwiebeln', '2 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (45, 'Karotten', '2 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (46, 'Brokkoli', '1/2 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (47, 'Zucchini', '1/2 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (48, 'Tiefkühl-Erbsen', '1/2 Tasse', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (49, 'Chilli', '1 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (50, 'Knoblauchzehen', '2 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (51, 'Ingwer', '1 Scheibe', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (52, 'Sojasoße', '5 EL', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (53, 'Zwiebel', '1 Stk.', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (54, 'Rührei oder Tofurührei', '100 g', 5);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (55, 'Kartoffeln', '600 g', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (56, 'Möhren', '3 Stk.', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (57, 'Zwiebeln', '2 Stk.', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (58, 'Olivenöl', '2 EL', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (59, 'Ringerhackfleisch', '600 g', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (60, 'Tomatenmark', '3 EL', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (61, 'Fleischbrühe', '300 ml', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (62, 'Pfeffer', '1 Prise', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (63, 'Salz', '1 Prise', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (64, 'Milch', '250 ml', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (65, 'Muskatpulver', '1 Prise', 6);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (66, 'Rinderbraten', '1,8 kg', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (67, 'Senf', '3 EL', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (68, 'Salz', '1 Prise', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (69, 'Pfeffer', '1 Prise', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (70, 'Öl', '6 EL', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (71, 'Rinderfond', '1 Liter', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (72, 'Lorbeerblätter', '3 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (73, 'Wacholderbeeren', '4 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (74, 'Möhren', '2 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (75, 'Knollensellerie', '1/4 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (76, 'Porree', '1/2 Stange', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (77, 'Zwiebeln', '400 g', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (78, 'Kartoffeln', '1,2 kg', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (79, 'Butter', '80 g', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (80, 'Mehl', '1 EL', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (81, 'Kopfsalat', '1 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (82, 'Zitronen', '2 Stk.', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (83, 'Vollmilch Joghurt', '2 EL', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (84, 'Weißweinessig', '1 EL', 7);
INSERT INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (85, 'Petersilie', '4 Stiele', 7);