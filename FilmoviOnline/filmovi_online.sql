-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: filmovi_online
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `filmovi`
--

DROP TABLE IF EXISTS `filmovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `filmovi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `drzava` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `glumci` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `godina_premijere` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `datum_postavljanja` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reziser` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `vreme_trajanja` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `url_slike` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `url_prevoda` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `jezik` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_videa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_videa_2` (`id_videa`),
  KEY `id_videa` (`id_videa`),
  CONSTRAINT `filmovi_ibfk_1` FOREIGN KEY (`id_videa`) REFERENCES `videi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmovi`
--

LOCK TABLES `filmovi` WRITE;
/*!40000 ALTER TABLE `filmovi` DISABLE KEYS */;
INSERT INTO `filmovi` VALUES (1,'Nueve Reinas','Argentina',' Ricardo Darín, Gastón Pauls, Leticia Brédice, María Mercedes Villagra, Gabriel Correa, Pochi Ducasse, Luis Armesto, Ernesto Arias, Amancay Espíndola, Isaac Fajm, Jorge Noya, Graciela Tenenbaum, Oscar Nuñez, Ignasi Abadal, Carlos Lanari','2000','2018-06-14 15:55:31','Fabián Bielinsky','01:27:00','img/Nueve_Reinas.jpg','URLP1','Early one morning, Marcos observes Juan successfully pulling off a bill-changing scam on a cashier, and then getting caught as he attempts to pull the same trick on the next shift. Marcos steps in, claiming to be a policeman, and drags Juan out of the store. Once they are back on the street, Marcos reveals himself to be a fellow swindler with a game of much higher stakes in mind, and he invites Juan to be his partner in crime. A once-in-a-lifetime scheme seemingly falls into their laps - an old-time con man enlists them to sell a forged set of extremely valuable rare stamps, The Nine Queens. The tricky negotiations that ensue bring into the picture a cast of suspicious characters, including Marcos\' sister Valeria, their younger brother Federico and a slew of thieves, conmen and pickpockets. As the deceptions mount, it becomes more and more difficult to figure out who is conning whom.','Spanish',2),(2,'Harry Potter and the Order of the Phoenix','UK, USA',' Daniel Radcliffe, Harry Melling, Jason Boyd, Richard Macklin, Kathryn Hunter, Miles Jupp, Fiona Shaw, Richard Griffiths, Jessica Hynes, Adrian Rawlins, Geraldine Somerville, Robert Pattinson, Ralph Fiennes, Natalia Tena, Brendan Gleeson','2018','2018-06-13 15:55:31','David Yates','02:16:00','img/Harry_Potter_and_the_Order_of_the_Phoenix_(2007).jpg','URLP2','After a lonely summer on Privet Drive, Harry returns to a Hogwarts full of ill-fortune. Few of students and parents believe him or Dumbledore that Voldemort is really back. The ministry had decided to step in by appointing a new Defence Against the Dark Arts teacher that proves to be the nastiest person Harry has ever encountered. Harry also can\'t help stealing glances with the beautiful Cho Chang. To top it off are dreams that Harry can\'t explain, and a mystery behind something Voldemort is searching for. With these many things Harry begins one of his toughest years at Hogwarts School of Witchcraft and Wizardry.','English',3),(3,'Deadpool ','USA, Canada',' Ryan Reynolds, Karan Soni, Ed Skrein, Michael Benyaer, Stefan Kapicic, Brianna Hildebrand, Style Dayne, Kyle Cassie, Taylor Hickson, Ayzee, Naika Toussaint, Randal Reeder, T.J. Miller, Isaac C. Singleton Jr., Morena Baccarin','2016','2018-06-15 15:55:31','-','01:44:00','img/Deadpool_(2016).jpg','URLP3','This is the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.','English',1),(4,'10,000 BC','USA, South Africa',' Steven Strait, Camilla Belle, Cliff Curtis, Joel Virgel, Affif Ben Badra, Mo Zinal, Nathanael Baring, Mona Hammond, Marco Khan, Reece Ritchie, Joel Fry, Omar Sharif, Kristian Beazley, Junior Oliphant, Louise Tu\'u','2008','2018-06-16 19:48:11','Roland Emmerich','01:34:00','img/10,000_BC_(2008).jpg','subtitle/10,000_BC_(2008).vtt','A prehistoric epic that follows a young mammoth hunter named D\'Leh\'s journey through uncharted territory to secure the future of his tribe. When a band of mysterious horse-riding warlords raid the Yaghal camp and kidnaps his heart\'s desire - the beautiful Evolet along with many others, D\'Leh is forced to lead a small group of hunters south to pursue the warlords to the end of the world to save her. Driven by destiny, the unlikely band of warriors must battle saber-toothed cats and terror birds in the Levant.','English',5),(5,'Next (2007)','USA','Nicolas Cage, Julianne Moore, Jessica Biel, Thomas Kretschmann','2007','2018-06-16 20:04:39',' Lee Tamahori ','01:27:00','img/Next_(2007).jpg','subtitle/Next_(2007).vtt','A Las Vegas magician who can see into the future is pursued by FBI agents seeking to use his abilities to prevent a nuclear terrorist attack.','English',6),(6,'Push',' USA, Canada',' Colin Ford, Joel Gretsch, Djimon Hounsou, Dakota Fanning, Robert Tsonos, Brandon Rhea, Camilla Belle, Neil Jackson, Chris Evans, Kai Cheung Leung, Sun Nan Hung, Corey Stoll, Scott Michael Campbell, Wai Man Tam, Hal Yamanouchi','2009','2018-06-16 20:15:51','Paul McGuigan ','01:41:00','img/Push_(2009).jpg','subtitle/Push_(2009).vtt','A group of young American ex-pats with telekinetic and clairvoyant abilities are hiding from a clandestine U.S. government agency. They must utilize their different talents and band together for a final job enabling them to escape the agency forever.','English',7),(7,'The Dark Knight (2008)','USA, UK',' Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine, Maggie Gyllenhaal, Gary Oldman, Morgan Freeman, Monique Gabriela Curnen, Ron Dean, Cillian Murphy, Chin Han, Nestor Carbonell, Eric Roberts, Ritchie Coster, Anthony Michael Hall','2008','2018-06-16 20:22:14','Christopher Nolan','02:32:00','img/The_Dark_Knight_(2008).jpg','xcv','Batman raises the stakes in his war on crime. With the help of Lieutenant Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the city streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as The Joker.','English, Mandarin ',8),(8,'Gangster Land','USA',' Sean Faris, Milo Gibson, Jason Patric, Jamie-Lynn Sigler, Peter Facinelli, Mark Rolston, Michael Paré, Sean Kanan, Al Sapienza, Don Harvey, Jason Brooks, Ryan Kiser, Stephen Brown, Jared Safier, Ronnie Kerr, Ryan Wiik, Louis Fasanaro, Joe Coffey, Danny Hansen, Shane P. Allen, Christian Hicks, Mark Krenik, Alan Donnes, Robert Goon, Michael DeBartolo, Jon Klaft, Alfonso Colichon, Jody Barton, Ilia Yordanov, Drake Andrew, Veronica Parks, Andrew Shelton, Floris Bosveld','2017','2018-06-17 07:55:56','Timothy Woodward Jr.','01:43:00','img/Gangster_Land.jpg','-','The story of America\'s most famous mobsters and their rise to power, GANGSTER LAND examines Al Capone\'s...','English',4),(9,'Se7en','USA','Morgan Freeman, Andrew Kevin Walker, Daniel Zacapa, Brad Pitt, Gwyneth Paltrow, John Cassini, Bob Mack, Peter Crombie, Reg E. Cathey, R. Lee Ermey, George Christy, Endre Hules, Hawthorne James, William Davidson, Bob Collins','1995','2018-06-17 08:04:11','David Fincher','02:07:00','img/Se7en_(1995).jpg','-','A film about two homicide detectives\' desperate hunt for a serial killer who justifies his crimes as absolution for the world\'s ignorance of the Seven Deadly Sins. The movie takes us from the tortured remains of one victim to the next as the sociopathic \"John Doe\" sermonizes to Detectives Sommerset and Mills -- one sin at a time. The sin of Gluttony comes first and the murderer\'s terrible capacity is graphically demonstrated in the dark and subdued tones characteristic of film noir. The seasoned and cultured but jaded Sommerset researches the Seven Deadly Sins in an effort to understand the killer\'s modus operandi while the bright but green and impulsive Detective Mills scoffs at his efforts to get inside the mind of a killer...','English',10),(10,'The Conjuring 2','USA',' Patrick Wilson, Vera Farmiga, Madison Wolfe, Frances O\'Connor, Lauren Esposito, Benjamin Haigh, Patrick McAuley, Simon McBurney, Maria Doyle Kennedy, Simon Delaney, Franka Potente, Bob Adrian, Robin Atkin Downes, Bonnie Aarons, Javier Botet','2016','2018-06-17 08:09:59','-','02:13:00','img/The_Conjuring_2_(2016).jpg','-','In 1977, paranormal investigators Ed and Lorraine Warren travel to London, England, where single mother Peggy Hodgson believes that something evil is in her home. When Peggy\'s youngest daughter starts showing signs of demonic possession, Ed and Lorraine attempt to help the besieged girl, only to find themselves targeted by the malicious spirits.','English',11),(11,'Residue','Canada',' James Clayton, Taylor Hickson, Matt Frewer, Elysia Rotaru, Alika Autran, Dan Payne, Costas Mandylor, William B. Davis, Blaine Anderson, Scotty Mac, Jason Burkart, Michael Matic, Linda Darlow, Thomas Potter, Paul Vigano, Will Williams, Nikolai Witschl, James Hutson, Matthew Graham, Dalias Blake, Christopher Laurence, Jaclyn Later, John Gillich, Julianne Alexander, Adam Lolacher, Caroline Rose Thompson, Olivier Lunardi','2017','2018-06-17 08:14:12','Rusty Nixon','01:22:00','img/Residue_(2017).jpg','-','A private investigator reads a book of sinister origins and unknowingly puts his daughter and himself in a fight for their lives...and their eternal souls.','English',12),(12,'The Exorcist','USA',' Ellen Burstyn, Max von Sydow, Lee J. Cobb, Kitty Winn, Jack MacGowran, Jason Miller, Linda Blair, William O\'Malley, Barton Heyman, Peter Masterson, Rudolf Schündler, Gina Petrushka, Robert Symonds, Arthur Storch, Thomas Bermingham','1973','2018-06-17 08:17:57','William Friedkin','02:02:00','img/The_Exorcist_(1973).jpg','-','A visiting actress in Washington, D.C., notices dramatic and dangerous changes in the behavior and physical make-up of her 12-year-old daughter. Meanwhile, a young priest at nearby Georgetown University begins to doubt his faith while dealing with his mother\'s terminal sickness. And, book-ending the story, a frail, elderly priest recognizes the necessity for a show-down with an old demonic enemy.','English, Latin, Greek, French, German, Arabic ',13),(13,'Agora','Spain',' Rachel Weisz, Max Minghella, Oscar Isaac, Ashraf Barhom, Michael Lonsdale, Rupert Evans, Homayoun Ershadi, Sami Samir, Richard Durden, Omar Mostafa, Manuel Cauchi, Oshri Cohen, Charles Thake, Harry Borg, Yousef \'Joe\' Sweid','2009','2018-06-17 08:21:49','Alejandro Amenábar','02:07:00','img/Agora_(2009).jpg','-','Alexandria, 391 AD: Hypatia teaches astronomy, mathematics, and philosophy. Her student Orestes is in love with her, as is Davus, her personal slave. As the city\'s Christians, led by Ammonius and Cyril, gain political power, the institutions of learning may crumble along with the governance of slavery. Jump ahead 20 years: Orestes, the city\'s prefect, has an uneasy peace with Christians, led by Cyril. A group from the newly empowered Christians has now taken to enforce their cultural hegemony zealously; first they see the Jews as their obstacle, then nonbelievers. Hypatia has no interest in faith; she\'s concerned about the movement of celestial bodies and \"the brotherhood of all\". Although her former slave doesn\'t see it that way.','English',14),(14,'Titanic','USA',' Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Frances Fisher, Gloria Stuart, Bill Paxton, Bernard Hill, David Warner, Victor Garber, Jonathan Hyde, Suzy Amis, Lewis Abernathy, Nicholas Cascone, Anatoly M. Sagalevitch','1997','2018-06-17 08:25:48','James Cameron','03:14:00','img/Titanic_(1997).jpg','-','84 years later, a 101-year-old woman named Rose DeWitt Bukater tells the story to her granddaughter Lizzy Calvert, Brock Lovett, Lewis Bodine, Bobby Buell and Anatoly Mikailavich on the Keldysh about her life set in April 10th 1912, on a ship called Titanic when young Rose boards the departing ship with the upper-class passengers and her mother, Ruth DeWitt Bukater, and her fiancé, Caledon Hockley. Meanwhile, a drifter and artist named Jack Dawson and his best friend Fabrizio De Rossi win third-class tickets to the ship in a game. And she explains the whole story from departure until the death of Titanic on its first and last voyage April 15th, 1912 at 2:20 in the morning.','English',15),(15,'Tigerland','USA, Germany','Colin Farrell, Matthew Davis, Clifton Collins Jr., Tom Guiry, Shea Whigham, Russell Richardson, Nick Searcy, Afemo Omilami, James MacDonald, Keith Ewell, Matt Gerald, Stephen Fulton, Tyler Cravens, Michael Edmiston, Arian Waring Ash','2000','2018-06-17 08:30:52','Joel Schumacher','01:41:00','img/Tigerland_(2000).jpg','-','In September 1971, a platoon of recruits arrives in Ft. Polk, LA, for infantry training before leaving for war. The final week takes place in Tigerland, a swamp similar to Vietnam. Jim Paxton has enlisted; he wants to experience everything and write books later. He befriends Roland Bozz, a cool Texan with a gift for getting into trouble and for helping misfits get discharges. At least one sociopath in the platoon hates Bozz, even as the sergeants grudgingly recognize his leadership abilities. As the platoon heads into its week in Tigerland, Paxton\'s body gives out, Bozz makes plans to go AWOL, and the sociopath gets hold of live ammo. Is the Louisiana swamp more dangerous than the DMZ?','English',16),(16,'My Name Is Nobody','Italy, France, West Germany',' Terence Hill, Henry Fonda, Jean Martin, R.G. Armstrong, Karl Braun, Leo Gordon, Steve Kanaly, Geoffrey Lewis, Neil Summers, Piero Lulli, Mario Brega, Marc Mazza, Benito Stefanelli, Alexander Allerson, Rainer Peets','1973','2018-06-17 08:35:30','Tonino Valerii','01:56:00','img/My_Name_Is_Nobody_(1973).jpg','-','Jack Beauregard, once the greatest gunslinger of the Old West, only wants to move to Europe and retire in peace. But a young gunfighter, known only as \"Nobody\", idolizes him and wants to see him go out in a blaze of glory. He arranges for Jack to face the 150-man gang known as The Wild Bunch and earn his place in history.','Italian ',17),(22,'Day of the Dead Bloodline 2018','USA',' Sophie Skelton, Johnathon Schaech, Jeff Gum','2018','2018-06-19 19:27:09','Hèctor Hernández Vicens','2:18','img/Day_of_the_Dead Bloodline_2018.jpg','subtitle/Day_of_the_Dead Bloodline_2018.vtt','Day of the Dead: Bloodline is a movie starring Sophie Skelton, Johnathon Schaech, and Jeff Gum. A small group of military personnel and survivalists dwell in an underground bunker as they seek to find a cure in a world overrun by zombies.',' English',21),(23,'Primal Rage 2018','USA',' Casey Gagliardi, Andrew Joseph Montgomery, Jameson Pazak','2018','2018-06-19 19:38:47','Patrick Magee','1:36','img/Primal_Rage_2018.jpg','subtitle/Primal_Rage_2018.vtt','Lost deep in the forest of the Pacific Northwest, Ashley and Max Carr are stalked by a terrifying creature that might be Bigfoot. Soon they find themselves embroiled in a strange land of Native American myth and legend turned real. Hopelessly trying to survive, with a handful of unsavory locals, they must fight back against this monster in a desperate battle of life or death. ',' English',25);
/*!40000 ALTER TABLE `filmovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `komentari`
--

DROP TABLE IF EXISTS `komentari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `komentari` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sadrzaj` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `datum_objave` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_videa` int(11) NOT NULL,
  `id_korisnika` int(11) NOT NULL,
  `odgovor_na` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_filma` (`id_videa`),
  KEY `id_korisnika` (`id_korisnika`),
  KEY `odgovor_na` (`odgovor_na`),
  CONSTRAINT `komentari_ibfk_2` FOREIGN KEY (`id_videa`) REFERENCES `videi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `komentari_ibfk_3` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnici` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `komentari_ibfk_4` FOREIGN KEY (`odgovor_na`) REFERENCES `komentari` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komentari`
--

LOCK TABLES `komentari` WRITE;
/*!40000 ALTER TABLE `komentari` DISABLE KEYS */;
INSERT INTO `komentari` VALUES (5,'blabla1','2018-06-12 23:00:00',5,1,NULL),(6,'dsgdsgdfgdfgdfg','2018-06-20 17:06:22',5,7,NULL),(7,'dfgdfgdfgdg','2018-06-20 17:06:22',5,5,NULL),(8,'komentar 1','2018-06-20 21:05:31',21,7,NULL),(9,'komentar 2','2018-06-20 21:05:31',21,6,NULL),(10,'asdsfdgdfhgjghjhjhj','2018-06-21 08:29:09',4,7,NULL),(11,'Odlican film!','2018-06-21 08:38:59',4,6,NULL),(12,'Dobar film','2018-06-21 08:43:02',8,7,NULL),(13,'Najnoviji komentar. :)','2018-11-11 10:02:07',4,6,NULL);
/*!40000 ALTER TABLE `komentari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnici`
--

DROP TABLE IF EXISTS `korisnici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `korisnici` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnici`
--

LOCK TABLES `korisnici` WRITE;
/*!40000 ALTER TABLE `korisnici` DISABLE KEYS */;
INSERT INTO `korisnici` VALUES (1,'k1ime','k1prezime','k1p1','k1p1','k1p1@gmail.com'),(2,'k2ime','k2prezime','k2p2','k2p2','k2p2@gmail.com'),(3,'k3ime','p3ime','k3p3','k3p3','k3p3@gmail.com'),(4,'k4ime','k4prezime','k4p4','k4p4','k4p4@gmail.com'),(5,'Stefan','Simonovic','StefanAdmin','admin','stefanSimon@gmail.com'),(6,'pera','peric','Perica','Perica','peraPeric@gmail.com'),(7,'Branislav','Kundovic','bane','banek','bane7070@gmail.com');
/*!40000 ALTER TABLE `korisnici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videi`
--

DROP TABLE IF EXISTS `videi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `videi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv_videa` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `url_videa` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videi`
--

LOCK TABLES `videi` WRITE;
/*!40000 ALTER TABLE `videi` DISABLE KEYS */;
INSERT INTO `videi` VALUES (1,'Deadpool','-'),(2,'Nueve Reinas','-'),(3,'Harry Potter and the Order of the Phoenix (2007)','-'),(4,'Gangster Land','-'),(5,'10,000 BC (2008)','videos/10,000_BC_(2008).mp4'),(6,'Next 2007','videos/Next_(2007).mp4'),(7,'Push (2009)','videos/Push_(2009).mp4'),(8,'The Dark Knight (2008)','-'),(10,'Se7en (1995)','-'),(11,'The Conjuring 2 (2016)','-'),(12,'Residue (2017)','-'),(13,'The Exorcist (1973)','-'),(14,'Agora (2009)','-'),(15,'Titanic (1997)','-'),(16,'Tigerland (2000)','-'),(17,'My Name Is Nobody (1973)','-'),(20,'NAZIV FILMA','ASASASAS'),(21,'Day_of_the_Dead Bloodline_2018','videos/Day_of_the_Dead Bloodline_2018.mp4'),(24,'Wild_Card_2015','videos/Wild_Card_2015.mp4'),(25,'Primal Rage (2018)','videos/Primal_Rage_2018.mp4'),(26,'The Commuter ','videos/The_Commuter_2018.mp4'),(27,'Wild Card ','videos/Wild_Card_2015.mp4'),(28,'sdgdsgd','asdasd'),(29,'aaaa','aaaaaaa');
/*!40000 ALTER TABLE `videi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zanr_videa`
--

DROP TABLE IF EXISTS `zanr_videa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `zanr_videa` (
  `id_videa` int(11) NOT NULL,
  `id_zanra` int(11) NOT NULL,
  PRIMARY KEY (`id_videa`,`id_zanra`),
  KEY `id_videa` (`id_videa`),
  KEY `id_zanra` (`id_zanra`),
  CONSTRAINT `zanr_videa_ibfk_1` FOREIGN KEY (`id_zanra`) REFERENCES `zanrovi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `zanr_videa_ibfk_2` FOREIGN KEY (`id_videa`) REFERENCES `videi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zanr_videa`
--

LOCK TABLES `zanr_videa` WRITE;
/*!40000 ALTER TABLE `zanr_videa` DISABLE KEYS */;
INSERT INTO `zanr_videa` VALUES (1,3),(1,4),(1,7),(1,8),(1,9),(1,14),(2,1),(2,5),(2,8),(3,7),(3,9),(4,1),(4,5),(5,4),(5,5),(5,7),(6,3),(6,4),(6,8),(7,4),(7,8),(7,9),(7,12),(8,1),(8,4),(8,5),(10,1),(10,8),(10,12),(11,6),(12,4),(12,6),(12,8),(13,6),(13,8),(14,2),(14,5),(14,7),(15,2),(15,5),(15,7),(15,15),(16,5),(16,11),(17,13),(17,14),(21,6),(24,4),(24,8),(25,6),(25,9),(29,1),(29,2);
/*!40000 ALTER TABLE `zanr_videa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zanrovi`
--

DROP TABLE IF EXISTS `zanrovi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `zanrovi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zanrovi`
--

LOCK TABLES `zanrovi` WRITE;
/*!40000 ALTER TABLE `zanrovi` DISABLE KEYS */;
INSERT INTO `zanrovi` VALUES (1,'Crime'),(2,'History'),(3,'Sci-Fi'),(4,'Action'),(5,'Drama'),(6,'Horor'),(7,'Adventure'),(8,'Thriller'),(9,'Fantasy'),(11,'War'),(12,'Mystery'),(13,'Western'),(14,'Comedy'),(15,'Romance');
/*!40000 ALTER TABLE `zanrovi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'filmovi_online'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 15:21:37
