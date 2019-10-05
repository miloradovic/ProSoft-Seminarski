/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.23-log : Database - osiguranje
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`osiguranje` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `osiguranje`;

/*Table structure for table `cenovnik_osiguranja` */

DROP TABLE IF EXISTS `cenovnik_osiguranja`;

CREATE TABLE `cenovnik_osiguranja` (
  `CenovnikID` int(10) NOT NULL AUTO_INCREMENT,
  `Kategorija` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Cena` double DEFAULT NULL,
  PRIMARY KEY (`CenovnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `cenovnik_osiguranja` */

insert  into `cenovnik_osiguranja`(`CenovnikID`,`Kategorija`,`Cena`) values 
(1,'do 22 KW',5438),
(2,'22,1 - 33 KW',6497),
(3,'33,1 - 44 KW',7563),
(4,'44,1 - 55 KW',8630),
(5,'55,1 - 66 KW',9688),
(6,'66,1 - 84 KW',11110),
(7,'84,1 - 110 KW',13235),
(8,'preko 110 KW',15716);

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` int(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Prezime` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `JMBG` varchar(13) CHARACTER SET latin1 DEFAULT NULL,
  `UlicaBroj` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Ptt` int(5) DEFAULT NULL,
  PRIMARY KEY (`KlijentID`),
  KEY `ptt` (`Ptt`),
  CONSTRAINT `ptt` FOREIGN KEY (`Ptt`) REFERENCES `mesto` (`Ptt`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`Ime`,`Prezime`,`JMBG`,`UlicaBroj`,`Ptt`) values 
(1,'Marko','Markovic','1708994711118','Niksicka 44',18101),
(2,'Miodrag','Milicic','1111111111111','Njegoseva 13',11000),
(3,'Milica','Jokic','2222222222222','Strahinjica Bana 69',35000);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `Ptt` int(5) NOT NULL,
  `Naziv` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`Ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`Ptt`,`Naziv`) values 
(11000,'Beograd'),
(12000,'Pozarevac'),
(18101,'Nis'),
(22000,'Sremska Mitrovica'),
(31000,'Uzice'),
(34000,'Kragujevac'),
(35000,'Jagodina'),
(35213,'Despotovac');

/*Table structure for table `polisa` */

DROP TABLE IF EXISTS `polisa`;

CREATE TABLE `polisa` (
  `PolisaID` int(10) NOT NULL AUTO_INCREMENT,
  `Ukupno` double DEFAULT NULL,
  `PremijskiStepen` int(11) DEFAULT NULL,
  `DatumUgovaranja` date DEFAULT NULL,
  `DatumRaskidanja` date DEFAULT NULL,
  `KlijentID` int(10) NOT NULL,
  `VoziloID` int(10) NOT NULL,
  `ReferentUgovarao` int(10) NOT NULL,
  `ReferentRaskidao` int(10) DEFAULT NULL,
  PRIMARY KEY (`PolisaID`),
  KEY `VoziloID` (`VoziloID`),
  KEY `ReferentUgovarao` (`ReferentUgovarao`),
  KEY `ReferentRaskidao` (`ReferentRaskidao`),
  KEY `KlijentID` (`KlijentID`),
  CONSTRAINT `polisa_ibfk_2` FOREIGN KEY (`VoziloID`) REFERENCES `vozilo` (`VoziloID`),
  CONSTRAINT `polisa_ibfk_3` FOREIGN KEY (`ReferentUgovarao`) REFERENCES `referent` (`ReferentID`),
  CONSTRAINT `polisa_ibfk_4` FOREIGN KEY (`ReferentRaskidao`) REFERENCES `referent` (`ReferentID`),
  CONSTRAINT `polisa_ibfk_5` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `polisa` */

insert  into `polisa`(`PolisaID`,`Ukupno`,`PremijskiStepen`,`DatumUgovaranja`,`DatumRaskidanja`,`KlijentID`,`VoziloID`,`ReferentUgovarao`,`ReferentRaskidao`) values 
(1,11356.21,4,'2018-09-12',NULL,1,1,1,NULL),
(4,19488,4,'2018-09-17','2018-09-17',2,3,1,1),
(5,26465,7,'2018-09-20','2018-09-20',3,2,1,1);

/*Table structure for table `referent` */

DROP TABLE IF EXISTS `referent`;

CREATE TABLE `referent` (
  `ReferentID` int(10) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Prezime` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `KorisnickoIme` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `KorisnickaSifra` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`ReferentID`),
  UNIQUE KEY `KorisnickoIme` (`KorisnickoIme`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `referent` */

insert  into `referent`(`ReferentID`,`Ime`,`Prezime`,`KorisnickoIme`,`KorisnickaSifra`) values 
(1,'Darko','Miloradovic','admin','admin'),
(2,'Petar','Petrovic','petar','petar');

/*Table structure for table `stavka_polise` */

DROP TABLE IF EXISTS `stavka_polise`;

CREATE TABLE `stavka_polise` (
  `PolisaID` int(10) NOT NULL,
  `RB` int(10) NOT NULL,
  `Naziv` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Cena` double DEFAULT NULL,
  `CenovnikID` int(10) DEFAULT NULL,
  PRIMARY KEY (`PolisaID`,`RB`),
  KEY `CenovnikID` (`CenovnikID`),
  CONSTRAINT `stavka_polise_ibfk_1` FOREIGN KEY (`PolisaID`) REFERENCES `polisa` (`PolisaID`),
  CONSTRAINT `stavka_polise_ibfk_2` FOREIGN KEY (`CenovnikID`) REFERENCES `cenovnik_osiguranja` (`CenovnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavka_polise` */

insert  into `stavka_polise`(`PolisaID`,`RB`,`Naziv`,`Cena`,`CenovnikID`) values 
(1,1,'Auto-odgovornost',9658,3),
(1,2,'Auto-nezgoda',2500,NULL),
(4,1,'Auto-odgovornost',9688,5),
(4,2,'Auto-nezgoda',9800,NULL),
(5,1,'Auto-odgovornost',16665,6),
(5,2,'Auto-nezgoda',9800,NULL);

/*Table structure for table `vozilo` */

DROP TABLE IF EXISTS `vozilo`;

CREATE TABLE `vozilo` (
  `VoziloID` int(10) NOT NULL AUTO_INCREMENT,
  `RegTablice` varchar(50) DEFAULT NULL,
  `Marka` varchar(100) DEFAULT NULL,
  `Model` varchar(100) DEFAULT NULL,
  `SnagaMotora` int(10) DEFAULT NULL,
  `GodinaProizvodnje` year(4) DEFAULT NULL,
  PRIMARY KEY (`VoziloID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `vozilo` */

insert  into `vozilo`(`VoziloID`,`RegTablice`,`Marka`,`Model`,`SnagaMotora`,`GodinaProizvodnje`) values 
(1,'BG-011DE','VW','Golf',44,2009),
(2,'BG-312ZS','Honda','Civic',88,2016),
(3,'JA-007AJ','BMW','320',102,2002);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
