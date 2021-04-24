CREATE TABLE if NOT EXISTS publishers(
	id INT PRIMARY KEY,
	company VARCHAR(100),
	address VARCHAR(100),
	email VARCHAR(30),
	establish DATE);

CREATE TABLE IF NOT EXISTS books(
	id INT AUTO_INCREMENT PRIMARY KEY,
	author VARCHAR(100),
	title VARCHAR(150),
	price DOUBLE,
	publisher INT,
	FOREIGN KEY(publisher) REFERENCES publishers(id));

INSERT INTO publishers VALUE(1,'Anonymus Kiadó','1141 Budapest,Cinkotai út 57.','info@anonymuskiado.hu','2017-03-21');
INSERT INTO publishers VALUE(2,'Bábel Kiadó','6000 Kecskemét, Vágó u. 1.','info@babelkiado.hu','2000-12-20');
INSERT INTO publishers VALUE(3,'Európa Könyvkiadó','2040 Budaörs, Ébner György köz 4. fszt. 2.','info@europakiado.hu','1846-02-23');
INSERT INTO publishers VALUE(4,'Libri Könyvkiadó','1073 Budapest, Király utca 13.','info@librikiado.hu','1999-12-31');
INSERT INTO publishers VALUE(5,'Park Könyvkiadó','1066 Budapest, Nyugati tér 1.','info@parkkiado.hu','2003-05-21');
INSERT INTO publishers VALUE(6,'Helikon Könyvkiadó','1103 Budapest, Etele tér 7.','info@helikon.hu','1973-02-27');
INSERT INTO publishers VALUE(7,'Jelenkor Könyvkiadó','2041 Budaörs, Puskás Tivadar utca 2.','info@jelenkorkiado.hu','1981-08-20');
INSERT INTO publishers VALUE(8,'Kolibri Gyerekkönyvkiadó','1051 Budapest, Kossuth tér 1.','kolibri@kolibrikiado.hu','1944-10-25');

INSERT INTO books(title,author,publisher,price) VALUE('Az Isteni kód - Múltunk titkai és jövőnk ígérete','Gregg Braden',1,'2992');
INSERT INTO books(title,author,publisher,price) VALUE('Ne függj senkitől! - Az önmagunkkal való törődés alapjai','Melody Bettie',2,'2467.5');
INSERT INTO books(title,author,publisher,price) VALUE('A legnagyobb Titok','Rhonda Byrne',3,'3217.1');
INSERT INTO books(title,author,publisher,price) VALUE('A változatlanság hullámhossza','SZEPES MÁRIA',4,'2242.7');
INSERT INTO books(title,author,publisher,price) VALUE('Szuperélet - Egyszerű megoldások, amelyektől egészségesebb, fittebb és energikusabb leszel','Darin Olien',2,'2767.2');
INSERT INTO books(title,author,publisher,price) VALUE('Küzdelem a Parkinson-kór ellen - Egy teljesebb életért!','Ray Dorsey MD, Todd Sherer PhD, Michael S. Okun MD, Bastiaan R. Bloem MD, PhD',3,'2767.9');
INSERT INTO books(title,author,publisher,price) VALUE('A békés harcos útja','Dan Millman',6,'2467.1');
INSERT INTO books(title,author,publisher,price) VALUE('Egyél az egészségedért','Fuhrman Joel',2,'2767.3');
INSERT INTO books(title,author,publisher,price) VALUE('Elvesztett társaink - Szeretetteljes gondviselés a gyászunk feldolgozásához','Jeffrey Moussaieff Masson',3,'2467.7');
INSERT INTO books(title,author,publisher,price) VALUE('A három királyság története II.','LO KUAN-CSUNG',4,'3217.6');
INSERT INTO books(title,author,publisher,price) VALUE('Visszatérés a szeretethez - Gondolatok A csodák tanítása alapelveiről','Marianne Williamson',4,'2467.8');
INSERT INTO books(title,author,publisher,price) VALUE('Klíma - Átfogó megoldások egy élhető jövőért','Charles Eisenstein',3,'2767.4');
INSERT INTO books(title,author,publisher,price) VALUE('Történhetnek csodák - 42 lépés a csodák útján a boldogság eléréséhez','GABRIELLE BERNSTEIN',4,'2467');
INSERT INTO books(title,author,publisher,price) VALUE('CBD - Az orvosi kannabisz csodája','Leonard Leinow - Juliana Birnbaum',8,'2767.3');
INSERT INTO books(title,author,publisher,price) VALUE('Élet stressz nélkül tinédzsereknek - Figyelem, tudatosság, problémamegoldás, bátorság, tervezés, döntés... félelem és szorongás helyett','Galanti Regine',8,'2242.7');
INSERT INTO books(title,author,publisher,price) VALUE('Gyász-napról napra','Jan Warner',4,'2767.6');
INSERT INTO books(title,author,publisher,price) VALUE('Egyél úgy, hogy ne halj meg - Áttörés az egészség és a súlycsökkentés területén','Dr. Michael Greger',1,'3742.0');
INSERT INTO books(title,author,publisher,price) VALUE('Társ a magányban - Önbizalom és lelkierő az elszigeteltség és magány leküzdéséhez','Shrein H. Bahrami',4,'2467.2');
INSERT INTO books(title,author,publisher,price) VALUE('Az emberiség ereje - Ismerd meg a benned rejlő csodákat : öngyógyítás, hosszú élet, intuíció, tiszta','Gregg Braden',5,'2992.7');
INSERT INTO books(title,author,publisher,price) VALUE('Azonnali elemzés - 100 mindenkit érintő viselkedésminta gyakorlatokkal és lehetséges megoldásokkal','Dr. David J. Lieberman',3,'2767.9');
INSERT INTO books(title,author,publisher,price) VALUE('Szociopata a szomszédom? - Szadista tornatanár, hazudozó házastárs, folyamatosan alázó főnök, ötleteinket rendszeresen ellopó kollégák','Stout Martha',6,'2467.1');
INSERT INTO books(title,author,publisher,price) VALUE('Siker - A gazdagság, amelyre vágysz és megérdemled','Napoleon Hill',8,'2467.7');
INSERT INTO books(title,author,publisher,price) VALUE('Tisztulj és gyógyulj','Anthony William',1,'3742.8');
INSERT INTO books(title,author,publisher,price) VALUE('Fejleszd a gondolkodásod - Változtasd meg a gondolkodásod a tudomány segítségével','Joe Dispenza',8,'3367.2');
INSERT INTO books(title,author,publisher,price) VALUE('A lélek lakhelye','Gary Zukav',8,'2767.5');
INSERT INTO books(title,author,publisher,price) VALUE('Szuperimmunitás - Táplálkozási útmutató a maximális immunvédelemhez, a hosszú, egészséges életért','Furman Dr. Joel',7,'2767.5');
INSERT INTO books(title,author,publisher,price) VALUE('Az elbűvölő NŐ - Minden pasi téged akar','Marie Forleo',2,'2017');
INSERT INTO books(title,author,publisher,price) VALUE('Sorsunk a csillagokban - Fejtsd meg életed titkait az asztrológia segítségével','Chani Nicholas',7,'2467');
INSERT INTO books(title,author,publisher,price) VALUE('Az ébredés könyve - Éld meg a jelen pillanatot álmaid jövőjéért','Mark Nepo',5,'2992');
INSERT INTO books(title,author,publisher,price) VALUE('A csodák tanítása egyszerűen','Pam Grout',1,'2992.3');
INSERT INTO books(title,author,publisher,price) VALUE('Szupervonzás - Teremts meg az életet, amire mindig is vágytál!','GABRIELLE BERNSTEIN',6,'2467.7');
INSERT INTO books(title,author,publisher,price) VALUE('A meditáció útja','OSHO',8,'2242.1');
INSERT INTO books(title,author,publisher,price) VALUE('Meddőségből termékenység - Természetes megoldások egy új életért','Dr. Csomai Zita',8,'2767.9');
INSERT INTO books(title,author,publisher,price) VALUE('Heal - A gyógyító benned él','Noonan Gore Kelly',4,'2992.8');
INSERT INTO books(title,author,publisher,price) VALUE('Változtasd meg a gondolataid pozitív megerősítésekkel','Helmstetter Shad',2,'2467.2');
INSERT INTO books(title,author,publisher,price) VALUE('A három királyság I.','LO KUAN-CSUNG',3,'3217.1');
INSERT INTO books(title,author,publisher,price) VALUE('A szeretet iskolája - Ősi tanítások az emberi kapcsolatokról','RUIZ DON MIGUEL',8,'2467.4');
INSERT INTO books(title,author,publisher,price) VALUE('Sikeres emberek kiemelkedő szokásai','Brendon Burchard',1,'2992.5');
INSERT INTO books(title,author,publisher,price) VALUE('Akasa-krónika - Hogyan érzékeld és használd az univerzum tudástárát?','Linda Howe',1,'2242.6');
INSERT INTO books(title,author,publisher,price) VALUE('Karma és reinkarnáció','Stephen Knapp',7,'2242.7');
INSERT INTO books(title,author,publisher,price) VALUE('Rúmi aranykora - válogatott költemények','Dzselál ed-Din Rúmí',6,'2767.3');
INSERT INTO books(title,author,publisher,price) VALUE('Minden megoldható!','Marie Forleo',1,'2767.2');
INSERT INTO books(title,author,publisher,price) VALUE('Az öt egyezség - Ősi tanításik az öntudatra ébredésről','RUIZ DON MIGUEL',8,'2467.2');
INSERT INTO books(title,author,publisher,price) VALUE('Elveszett kapcsolatok - A szorongás és a depresszió valódi okai és meghökkentő gyógymódjai','Johann Hari',4,'2767.2');
INSERT INTO books(title,author,publisher,price) VALUE('Élet adta bölcsesség - Beszélgetések korunk meghatározó spirituális tanítóival','Oprah Winfrey',3,'3217.7');
INSERT INTO books(title,author,publisher,price) VALUE('Csodatévő zeller','Anthony William',1,'2767.5');
INSERT INTO books(title,author,publisher,price) VALUE('Energiakódok - 7 lépés a testi-lelki gyógyulásért és egy jobb életért','Dr. Sue Morter',5,'2467.3');
INSERT INTO books(title,author,publisher,price) VALUE('Az élet hét törvénye','Deepak Chopra',2,'2092.1');
INSERT INTO books(title,author,publisher,price) VALUE('Napszél - Űrrobinzonok','SZEPES MÁRIA',1,'1492.0');
