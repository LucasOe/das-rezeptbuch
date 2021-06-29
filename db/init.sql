create table if not exists rezeptliste (Name text not null, IdRezept int auto_increment primary key, Favorit tinyint(1) not null, Beschreibung text not null, Zeit int not null, BildUrl text not null, constraint rezeptliste_IdRezept_uindex unique (IdRezept) );

create table if not exists kategorien (IdKategorie int auto_increment primary key, Kategorie char(30) not null, fkRezept int not null, constraint kategorien_IdKategorie_uindex unique (IdKategorie), constraint kategorien_rezeptliste_IdRezept_fk foreign key (fkRezept) references rezeptliste (IdRezept) );

create table if not exists zutaten (IdZutat int auto_increment primary key, Zutat char(50) not null, Menge char(50) not null, fkRezept int not null, constraint zutaten_IdZutat_uindex unique (IdZutat), constraint zutaten_rezeptliste_IdRezept_fk foreign key (fkRezept) references rezeptliste (IdRezept) );

INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Hühnerfrikasse', 1, 0, 'Zuerst legst Du Dir Deine Hähnchenfleisch-Reste zurecht und schneidest sie beliebig klein. Ich schneide zum Beispiel immer Würfelchen.\\nIm Anschluss schälst Du die Möhren und schneidest sie in sehr kleine Stücke, die Champignons putzen und nach Belieben klein schneiden, die 150g Tiefkühl-Erbsen abwiegen. Die Hühnerbrühe bereitstellen.\\nJetzt bereitest Du die Mehlschwitze vor, in dem Du die 25g Butter in einem Topf zerlässt und dann 25 g Mehl zur geschmolzenen Butter gibst. Unter ständigem, schnellen Rühren mit dem Schneebesen lässt Du das Mehl in der Butter anschwitzen, bis es goldgelb wird.\\nIm Anschluss rührst Du wieder mit dem Schneebesen nach und nach und etwas langsamer Deine Hühnerbrühe unter (egal ob warm oder kalt). Dabei wieder schnell rühren, wegen der Klümpchenbildung. Jetzt lässt Du alles nochmal kurz aufkochen.\\nNun gibst Du die Sahne, die Champignons, die Möhrenstückchen und Erbsen heinein, und lässt alles für 5-8 Minuten köcheln. Dabei ab und zu umrühren!\\nDas Frikassee mit einem Spritzer Zitronensaft, Salz und Pfeffer abschmecken und noch die Hähnchenfleisch-Reste für 5 Minuten darin ziehen lassen, um sie zu erwärmen.', 30, 'Huehnerfrikassee.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Ratatouille mit Mozarella', 2, 0, 'Als erstes heizt Du den Ofen auf 200 Grad Umluft vor.\\nDann rührst Du das Tomatenmark und die Chiliflocken hinein, lässt beides kurz mit rösten und schmeckst mit Salz und Pfeffer ab. Vom Herd nehmen und kurz zur Seite stellen\\nDie Aubergine, die Zucchini und die Tomaten waschen und so weit wie möglich in gleichmäßig dünne Scheiben schneiden: ca. 2-3 mm.\\nDie Schalotten-Masse unten in einer passenden Auflaufform gleichmäßig verteilen und darauf abwechselnd dicht an dicht das Gemüse dachziegelartig schichten.\\nKräftig mit Salz und Pfeffer würzen und mit 6 EL Olivenöl beträufeln.\\nDie Auflaufform mit Alufolie verschließen und auf der mittleren Schiene ca. 40-45 Minuten backen.\\nIn der Zeit den Mozzarella  fein zupfen und nach den 40 oder 45 Minuten das Gemüse damit bestreuen. OHNE Alufolie bei gleicher Temperatur für weitere 10-15 Minuten auf der mittleren Schiene zu Ende backen bzw. bis der Käse die gewünschte Farbe angekommen hat.', 75, 'Ratatouille_mit_Mozzarella.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Blumenkohl Kartoffel Eintopf mit weißen Bohnen & Grünkohl', 3, 0, 'Zwiebeln und Knoblauch in 2 EL Olivenöl anbraten. Thymian, Karotten dazugeben und 2-3 Minuten auf mittlerer Hitze anbraten. Mit Brühe ablöschen und den Blumenkohl und die Kartoffeln dazugeben.\\n20-30 Minuten köcheln lassen. 1 Schöpfkelle der Suppe fein pürieren und wieder in den Topf zurück geben.\\nWeiße Bohnen abspülen und mit dem Grünkohl unter den Eintopf mischen.\\n3-5 Minuten auf kleiner Hitze köcheln lassen und mit Salz und Pfeffer abschmecken.\\nPetersilie hacken und unter den Eintopf mischen. Wer mag gibt noch Kresse dazu.', 30, 'Blumenkohl_Eintopf.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Linsen-Dal mit gebratenem Blumenkohl', 4, 0, 'Linsen kalt abspülen und abtropfen lassen. Ingwer schälen und fein hacken. Zwiebeln schälen und fein würfeln.\\n2 EL Öl in einem Topf erhitzen. Chili, Ingwer, Kreuzkümmel, Garam Masala und Senfsamen darin unter Rühren kurz anrösten, bis es zu duften anfängt. ­Linsen zufügen und kurz andünsten. 1 l Wasser zugießen, aufkochen.\\nBei mittlerer Hitze unter gelegentlichem Rühren zugedeckt 15–20 Minuten köcheln.\\nTomaten waschen, vierteln und in Würfel schneiden. Ca. 10 Minuten vor Ende der Garzeit zum Dal geben. Blumenkohl putzen, waschen und in Röschen teilen. Koriander waschen, trocken schütteln, Blätter von den Stielen zupfen und fein hacken.\\n1 EL Öl in einer Pfanne erhitzen. BLumenkohl unter Wenden 5-8 Minuten goldbraun braten. Mit Salz und Pfeffer würzen.\\nGehackten Koriander unter die Linsen heben. Mit Salz und Zitronensaft abschmecken. Mit gebratenem Blumenkohl in vier tiefen Tellern anrichten.', 30, 'Linsen_Dal_mit_gebratenem_Blumenkohl.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Gebratener Reis mit Gemüse und Ei', 5, 0, 'Alls erstes den Reis nach Packungsanleitung gar kochen.\\nGemüse klein schneiden und in Öl knusprig anbraten. (ausgenommen die Erbsen)\\nDas Gemüse in eine Schale geben. Gewürze in die Pfanne geben und ebenfalls anbraten. Den Reis dazugeben und unter gelegentlichen rühren anbraten. Das Gemüse zurück in die Pfanne geben und mit dem Reis mischen. Nun die Erbsen und die Sojasauce dazugeben.\\nZwiebeln in einer Pfanne mit Öl kräftig anrösten.\\nReis in Schalen verteilen und mit gebratenen Zwiebeln und Rührei/Tofurührei servieren.\\nMit Salz und Pfeffer abschmecken.', 35, 'Gebratener_Reis.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Hackfleischauflauf mit Kartoffelhaube (Shepherd''s Pie)', 6, 0, 'Kartoffeln schälen, waschen und in Salzwasser 25–30 Minuten kochen.\\nMöhre waschen und sehr klein würfeln. Zwiebeln schälen und fein würfeln. Olivenöl in einer Pfanne erhitzen. Möhre, Zwiebeln und Rinderhackfleisch zugeben und 5–8 Minuten bei mittlerer Hitze anbraten. Tomatenmark zugeben und 1 Minute mitrösten. Brühe angießen und mit Salz und Pfeffer abschmecken.\\nKartoffeln abgießen, abtropfen lassen und zerstampfen. Milch in einem Topf erwärmen und unterrühren. Mit Salz, Pfeffer und Muskat würzen. Hackfleisch auf vier Auflaufformen aufteilen. Kartoffelpüree in einen Spritzbeutel mit Sternentülle geben und auf dem Hack verteilen. Im vorgeheizten Backofen bei 200 °C (Umluft 180 °C; Gas: Stufe 3) ca. 35–40 Minuten goldbraun backen. Herausnehmen und sofort servieren.', 115, 'Hackfleischauflauf_mit_Kartoffelhaube.png');
INSERT IGNORE INTO rezepte_test.rezeptliste (Name, IdRezept, Favorit, Beschreibung, Zeit, BildUrl) VALUES ('Rinderbraten mit Zwiebelsoße', 7, 0, 'Fleisch trocken tupfen und rundherum mit Senf einreiben. Mit Salz und Pfeffer würzen. 4 EL Öl in einem Bräter erhitzen. Fleisch darin rundherum kräftig anbraten. Fond angießen und aufkochen. Gewürze zufügen. Zugedeckt ca. 2 Stunden garen. Dabei das Fleisch alle ca. 30 Minuten wenden.\\nMöhren und Sellerie schälen. Beides klein schneiden. Porree putzen, waschen und in Stücke schneiden. Zwiebeln schälen. 2 Zwiebeln vierteln. Nach ca. 1 Stunde der Garzeit Möhren, Sellerie, Porree und Zwiebelviertel zum Fleisch geben und mitgaren.\\nInzwischen Kartoffeln schälen und waschen. In Salzwasser ca. 20 Minuten kochen. Übrige Zwiebeln halbieren und in Streifen schneiden. 50 g Butter in einer Pfanne erhitzen. Zwiebeln darin bei mittlerer Hitze 8–10 Minuten braten. Fleisch aus dem Bräter nehmen und warmstellen. Bratenfond durch ein Sieb gießen und auffangen. Zwiebeln mit Mehl bestäuben, mit dem Bratenfond ablöschen und ca. 10 Minuten köcheln lassen. Soße mit Salz und Pfeffer würzen.\\nSalat putzen, waschen, trocken schütteln und in mundgerechte Stücke zupfen. Zitronen halbieren und auspressen. Joghurt, Zitronensaft, 3 EL Wasser, Essig und 2 EL Öl verrühren. Dressing mit Salz und Pfeffer würzen. Petersilie waschen und trocken schütteln. Blättchen von den Stielen zupfen und, bis auf einige zum Garnieren, hacken. 30 g Butter in einem Topf schmelzen. Gehackte Petersilie zufügen. Kartoffeln abgießen und in der Petersilienbutter schwenken.\\nSalat und Joghurtdressing mischen. Braten in Scheiben schneiden. Mit den Kartoffeln auf einer Platte anrichten. Etwas Zwiebelsoße über den Braten geben. Mit übriger Petersilie garnieren. Übrige Zwiebelsoße und Salat in Schälchen dazu reichen.', 150, 'Rinderbraten_mit_Zwiebelsoße.png');

INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (1, 'Fleischgericht', 1);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (2, 'Vegetarisch', 2);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (3, 'Vegetarisch', 3);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (4, 'Vegetarisch', 4);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (5, 'Vegetarisch', 5);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (6, 'Fleischgericht', 6);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (7, 'Fleischgericht', 7);
INSERT IGNORE INTO rezepte_test.kategorien (IdKategorie, Kategorie, fkRezept) VALUES (8, 'Vegan', 3);

INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (1, 'Hühnerbrühe', '400 ml', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (2, 'Hähnchenfleisch', '250 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (3, 'Möhren', '150 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (4, 'Champignons', '150 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (5, 'Tiefkühlerbsen', '150 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (6, 'Butter', '25 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (7, 'Mehl', '25 g', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (8, 'Sahne', '100 ml', 1);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (9, 'Mozzarella oder Büffelmozzarella', '125 g', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (10, 'Aubergine', '1 Stk.', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (11, 'Zucchini', '2 Stk.', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (12, 'Tomaten', '3-4 Stk.', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (13, 'Schalotten', '3 Stk.', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (14, 'Knoblauchzehen', '2 Stk.', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (15, 'Olivenöl', '8 EL', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (16, 'Chiliflocken', '1 Messerspitze', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (17, 'Tomatenmark', '1 1/2 EL', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (18, 'Salz und Pfeffer', 'Abschmecken', 2);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (19, 'Zwiebel', '1 Stk.', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (20, 'Knoblauchzehen', '2-3 Stk.', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (21, 'Thymian', '1 TL', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (22, 'Karotten', '3 Stk.', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (23, 'Blumenkohl', '400 g', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (24, 'Kartoffeln', '2 Stk.', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (25, 'Weiße Bohnen', '200 g', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (26, 'Grünkohl', '100 g', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (27, 'Gemüsebrühe', '1 Liter', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (28, 'Meersalz', '1 Prise', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (29, 'Schwarzer Pfeffer', '1 Prise', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (30, 'Petersilie', '1/2 Bund', 3);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (31, 'Rote Linsen', '300 g', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (32, 'Ingwer', '10 g', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (33, 'Zwiebeln', '2 Stk.', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (34, 'Öl', '3 EL', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (35, 'Kreuzkümmel', '1/2 TL', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (36, 'Garam Masala', '1 TL', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (37, 'Senfsamen', '1 TL', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (38, 'Tomaten', '3 Stk.', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (39, 'Blumenkohl', '500 g', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (40, 'Koriander oder Petersilie', '3 Stiele', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (41, 'Salz und Pfeffer', '1 Prise', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (42, 'Zitrone', '1/2 Stk.', 4);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (43, 'Reis', '170 g', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (44, 'Frühlingszwiebeln', '2 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (45, 'Karotten', '2 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (46, 'Brokkoli', '1/2 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (47, 'Zucchini', '1/2 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (48, 'Tiefkühl-Erbsen', '1/2 Tasse', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (49, 'Chilli', '1 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (50, 'Knoblauchzehen', '2 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (51, 'Ingwer', '1 Scheibe', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (52, 'Sojasoße', '5 EL', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (53, 'Zwiebel', '1 Stk.', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (54, 'Rührei oder Tofurührei', '100 g', 5);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (55, 'Kartoffeln', '600 g', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (56, 'Möhren', '3 Stk.', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (57, 'Zwiebeln', '2 Stk.', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (58, 'Olivenöl', '2 EL', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (59, 'Ringerhackfleisch', '600 g', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (60, 'Tomatenmark', '3 EL', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (61, 'Fleischbrühe', '300 ml', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (62, 'Pfeffer', '1 Prise', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (63, 'Salz', '1 Prise', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (64, 'Milch', '250 ml', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (65, 'Muskatpulver', '1 Prise', 6);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (66, 'Rinderbraten', '1,8 kg', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (67, 'Senf', '3 EL', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (68, 'Salz', '1 Prise', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (69, 'Pfeffer', '1 Prise', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (70, 'Öl', '6 EL', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (71, 'Rinderfond', '1 Liter', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (72, 'Lorbeerblätter', '3 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (73, 'Wacholderbeeren', '4 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (74, 'Möhren', '2 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (75, 'Knollensellerie', '1/4 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (76, 'Porree', '1/2 Stange', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (77, 'Zwiebeln', '400 g', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (78, 'Kartoffeln', '1,2 kg', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (79, 'Butter', '80 g', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (80, 'Mehl', '1 EL', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (81, 'Kopfsalat', '1 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (82, 'Zitronen', '2 Stk.', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (83, 'Vollmilch Joghurt', '2 EL', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (84, 'Weißweinessig', '1 EL', 7);
INSERT IGNORE INTO rezepte_test.zutaten (IdZutat, Zutat, Menge, fkRezept) VALUES (85, 'Petersilie', '4 Stiele', 7);