# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: siperpus_4
# Generation Time: 2018-05-05 14:59:20 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table literatur
# ------------------------------------------------------------

DROP TABLE IF EXISTS `literatur`;

CREATE TABLE `literatur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(50) DEFAULT NULL,
  `penulis` varchar(50) DEFAULT NULL,
  `penerbit` varchar(50) DEFAULT NULL,
  `jenis_literatur` varchar(50) DEFAULT NULL,
  `jumlah` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `literatur` WRITE;
/*!40000 ALTER TABLE `literatur` DISABLE KEYS */;

INSERT INTO `literatur` (`id`, `judul`, `penulis`, `penerbit`, `jenis_literatur`, `jumlah`)
VALUES
	(2,'klkn','nklm','lkmlk','klk','33'),
	(4,'judul 45655','fd','fd','sdf','23'),
	(5,'Judul 123','nkj','mlk','89','23'),
	(6,'cip','d','sad','sad','4');

/*!40000 ALTER TABLE `literatur` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table peminjaman_literatur
# ------------------------------------------------------------

DROP TABLE IF EXISTS `peminjaman_literatur`;

CREATE TABLE `peminjaman_literatur` (
  `id` int(11) NOT NULL,
  `id_literatur` int(11) NOT NULL,
  `username_peminjam` varchar(50) NOT NULL,
  `tanggal_peminjaman` date DEFAULT NULL,
  `tanggal_pengembalian` date DEFAULT NULL,
  `status_peminjaman` varchar(50) DEFAULT NULL,
  `id_surat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username_peminjam` (`username_peminjam`),
  KEY `id_literatur` (`id_literatur`),
  CONSTRAINT `id_literatur` FOREIGN KEY (`id_literatur`) REFERENCES `literatur` (`id`),
  CONSTRAINT `peminjaman_literatur_ibfk_2` FOREIGN KEY (`username_peminjam`) REFERENCES `user_account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table pengadaan_literatur
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pengadaan_literatur`;

CREATE TABLE `pengadaan_literatur` (
  `id` int(11) NOT NULL,
  `username_requester` varchar(50) NOT NULL,
  `judul` varchar(50) DEFAULT NULL,
  `penulis` varchar(50) DEFAULT NULL,
  `penerbit` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username_requester` (`username_requester`),
  CONSTRAINT `pengadaan_literatur_ibfk_1` FOREIGN KEY (`username_requester`) REFERENCES `user_account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_account`;

CREATE TABLE `user_account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;

INSERT INTO `user_account` (`username`, `password`, `role`)
VALUES
	('1290578781','password','ROLE_DOSEN'),
	('1290578783','password','ROLE_DOSEN'),
	('1290578785','password','ROLE_DOSEN'),
	('1290578787','password','ROLE_DOSEN'),
	('1290578789','password','ROLE_DOSEN'),
	('1290578791','password','ROLE_DOSEN'),
	('1290578793','password','ROLE_DOSEN'),
	('1290578795','password','ROLE_DOSEN'),
	('1290578797','password','ROLE_DOSEN'),
	('1290578799','password','ROLE_DOSEN'),
	('1290578801','password','ROLE_DOSEN'),
	('1290578803','password','ROLE_DOSEN'),
	('1290578805','password','ROLE_DOSEN'),
	('1290578807','password','ROLE_DOSEN'),
	('1290578809','password','ROLE_DOSEN'),
	('1290578811','password','ROLE_DOSEN'),
	('1290578813','password','ROLE_DOSEN'),
	('1290578815','password','ROLE_DOSEN'),
	('1290578817','password','ROLE_DOSEN'),
	('1290578819','password','ROLE_DOSEN'),
	('1290578821','password','ROLE_DOSEN'),
	('1290578823','password','ROLE_DOSEN'),
	('1290578825','password','ROLE_DOSEN'),
	('1290578827','password','ROLE_DOSEN'),
	('1290578829','password','ROLE_DOSEN'),
	('1290578831','password','ROLE_DOSEN'),
	('1290578833','password','ROLE_DOSEN'),
	('1290578835','password','ROLE_DOSEN'),
	('1290578837','password','ROLE_DOSEN'),
	('1290578839','password','ROLE_DOSEN'),
	('1290578841','password','ROLE_DOSEN'),
	('1290578843','password','ROLE_DOSEN'),
	('1290578845','password','ROLE_DOSEN'),
	('1290578897','password','ROLE_DOSEN'),
	('1406575815','password','ROLE_STAF'),
	('1506689692','password','ROLE_STAF'),
	('1506721756','password','ROLE_MAHASISWA'),
	('1506721762','password','ROLE_MAHASISWA'),
	('1506721775','password','ROLE_MAHASISWA'),
	('1506721781','password','ROLE_MAHASISWA'),
	('1506721794','password','ROLE_MAHASISWA'),
	('1506721806','password','ROLE_MAHASISWA'),
	('1506721812','password','ROLE_MAHASISWA'),
	('1506721825','password','ROLE_MAHASISWA'),
	('1506721831','password','ROLE_MAHASISWA'),
	('1506721844','password','ROLE_MAHASISWA'),
	('1506721863','password','ROLE_MAHASISWA'),
	('1506721876','password','ROLE_MAHASISWA'),
	('1506721882','password','ROLE_MAHASISWA'),
	('1506721895','password','ROLE_MAHASISWA'),
	('1506721900','password','ROLE_MAHASISWA'),
	('1506723231','password','ROLE_STAF'),
	('1506737823','password','ROLE_STAF'),
	('1506757642','password','ROLE_MAHASISWA'),
	('1506757655','password','ROLE_MAHASISWA'),
	('1506757661','password','ROLE_MAHASISWA'),
	('1506757680','password','ROLE_MAHASISWA'),
	('1506757693','password','ROLE_MAHASISWA');

/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
