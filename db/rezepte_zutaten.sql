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

INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (1, 'Hühnerbrühe', '400 ml', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (2, 'Hähnchenfleisch', '250 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (3, 'Möhren', '150 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (4, 'Champignons', '150 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (5, 'Tiefkühlerbsen', '150 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (6, 'Butter', '25 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (7, 'Mehl', '25 g', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (8, 'Sahne', '100 ml', 1);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (9, 'Mozzarella oder Büffelmozzarella', '125 g', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (10, 'Aubergine', '1 Stk.', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (11, 'Zucchini', '2 Stk.', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (12, 'Tomaten', '3-4 Stk.', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (13, 'Schalotten', '3 Stk.', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (14, 'Knoblauchzehen', '2 Stk.', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (15, 'Olivenöl', '8 EL', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (16, 'Chiliflocken', '1 Messerspitze', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (17, 'Tomatenmark', '1 1/2 EL', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (18, 'Salz und Pfeffer', 'Abschmecken', 2);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (19, 'Zwiebel', '1 Stk.', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (20, 'Knoblauchzehen', '2-3 Stk.', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (21, 'Thymian', '1 TL', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (22, 'Karotten', '3 Stk.', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (23, 'Blumenkohl', '400 g', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (24, 'Kartoffeln', '2 Stk.', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (25, 'Weiße Bohnen', '200 g', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (26, 'Grünkohl', '100 g', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (27, 'Gemüsebrühe', '1 Liter', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (28, 'Meersalz', '1 Prise', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (29, 'Schwarzer Pfeffer', '1 Prise', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (30, 'Petersilie', '1/2 Bund', 3);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (31, 'Rote Linsen', '300 g', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (32, 'Ingwer', '10 g', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (33, 'Zwiebeln', '2 Stk.', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (34, 'Öl', '3 EL', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (35, 'Kreuzkümmel', '1/2 TL', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (36, 'Garam Masala', '1 TL', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (37, 'Senfsamen', '1 TL', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (38, 'Tomaten', '3 Stk.', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (39, 'Blumenkohl', '500 g', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (40, 'Koriander oder Petersilie', '3 Stiele', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (41, 'Salz und Pfeffer', '1 Prise', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (42, 'Zitrone', '1/2 Stk.', 4);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (43, 'Reis', '170 g', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (44, 'Frühlingszwiebeln', '2 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (45, 'Karotten', '2 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (46, 'Brokkoli', '1/2 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (47, 'Zucchini', '1/2 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (48, 'Tiefkühl-Erbsen', '1/2 Tasse', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (49, 'Chilli', '1 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (50, 'Knoblauchzehen', '2 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (51, 'Ingwer', '1 Scheibe', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (52, 'Sojasoße', '5 EL', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (53, 'Zwiebel', '1 Stk.', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (54, 'Rührei oder Tofurührei', '100 g', 5);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (55, 'Kartoffeln', '600 g', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (56, 'Möhren', '3 Stk.', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (57, 'Zwiebeln', '2 Stk.', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (58, 'Olivenöl', '2 EL', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (59, 'Ringerhackfleisch', '600 g', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (60, 'Tomatenmark', '3 EL', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (61, 'Fleischbrühe', '300 ml', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (62, 'Pfeffer', '1 Prise', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (63, 'Salz', '1 Prise', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (64, 'Milch', '250 ml', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (65, 'Muskatpulver', '1 Prise', 6);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (66, 'Rinderbraten', '1,8 kg', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (67, 'Senf', '3 EL', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (68, 'Salz', '1 Prise', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (69, 'Pfeffer', '1 Prise', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (70, 'Öl', '6 EL', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (71, 'Rinderfond', '1 Liter', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (72, 'Lorbeerblätter', '3 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (73, 'Wacholderbeeren', '4 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (74, 'Möhren', '2 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (75, 'Knollensellerie', '1/4 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (76, 'Porree', '1/2 Stange', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (77, 'Zwiebeln', '400 g', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (78, 'Kartoffeln', '1,2 kg', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (79, 'Butter', '80 g', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (80, 'Mehl', '1 EL', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (81, 'Kopfsalat', '1 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (82, 'Zitronen', '2 Stk.', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (83, 'Vollmilch Joghurt', '2 EL', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (84, 'Weißweinessig', '1 EL', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (85, 'Petersilie', '4 Stiele', 7);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (86, 'Zwiebel', '1', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (87, 'Knoblauchzehe', '1', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (88, 'Tomaten', '4', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (89, 'Grüne Paprikaschoten', '250 g', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (90, 'Öl', '1 EL', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (91, 'Rinderhackfleisch', '400 g', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (92, 'Chili Con Carne Fix', '1 Tüte', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (93, 'Kidney Bohnen', '1 Dose', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (94, 'Gemüsemais', '1 Dose', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (95, 'Salz', '1 Prise', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (96, 'Pfeffer', '1 Prise', 8);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (97, 'TK-Prinzessbohnen', '400 g', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (98, 'Pfeffer', '1 Prise', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (99, 'Salz', '1 Prise', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (100, 'Fenchelknolle', '1', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (101, 'Zwiebel', '1', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (102, 'Knoblauchzehen', '2', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (103, 'Stiele Minzze', '2', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (104, 'Kabeljaufilet', '4 Stück', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (105, 'Zitronenabrieb und Saft', '1/2', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (106, 'Olivenöl', '1 EL', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (107, 'Stückige Tomaten', '1 Dose', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (108, 'Trockener Weißwein', '100 ml', 9);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (109, 'Zwiebel', '1', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (110, 'Knoblauchzehen', '2', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (111, 'Öl', '2-3 EL', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (112, 'TK-Blattspinat', '450 g', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (113, 'Salz', '1 Prise', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (114, 'Pfeffer', '1 Prise', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (115, 'Muskat', '1 Prise', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (116, 'Lachsfilet (ohne Haut)', '400 g', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (117, 'Zitronenpfeffer', '1 Prise', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (118, 'frische Bandnudeln', '500 g', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (119, 'Gemüsebrühe', '1 TL', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (120, 'Zitrone', '4 Scheiben', 10);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (121, 'Erdbeeren', '500 g', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (122, 'Zitronenmelisse', '3-4 Stiele', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (123, 'Zucker', '2-4 EL', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (124, 'Mascarpone', '125 g', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (125, 'Sahnequark', '250 g', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (126, 'Limettensaft', '2-3 EL', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (127, 'Balsamico-Crem oder Schokosoße zum verzieren', '1 EL', 12);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (128, 'weiße Schokolade', '150 g', 11);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (129, 'Vollmilch-Joghurt', '200 g', 11);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (130, 'Schlagsahne', '250 g', 11);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (131, 'Zucker', '3 EL', 11);
INSERT INTO rezepte.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (132, 'Zartbitter-Schokolade', '75 g', 11);