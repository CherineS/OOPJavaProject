-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 02 déc. 2020 à 16:46
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `project`
--

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productNo` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `minimumPromotion` int(11) DEFAULT NULL,
  `valuePromotion` double DEFAULT NULL,
  `lienURL` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`productNo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`productNo`, `name`, `price`, `quantity`, `minimumPromotion`, `valuePromotion`, `lienURL`) VALUES
(0, 'Banane', 1, 100, 10, 0.05, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLTllaf8plA2p_AU2je69iF2arlW-eptBAgQ&usqp=CAU'),
(1, 'Kiwi', 1.2, 150, 10, 0.12, NULL),
(2, 'Pomme', 0.2, 100, 20, 5, 'https://produits.bienmanger.com/35111-0w600h600_Pommes_Story_France_Bio.jpg'),
(3, 'Jus de pomme', 2, 40, 6, 5, 'https://www.carrefour.fr/media/1500x1500/Photosite/PGC/P.L.S./3560070370504_PHOTOSITE_20190521_163656_0.jpg?placeholder=1'),
(4, 'Compote de pomme', 2, 50, 5, 10, 'https://www.carrefour.fr/media/1500x1500/Photosite/PGC/P.L.S./3608580784524_PHOTOSITE_20200911_171202_0.jpg?placeholder=1'),
(5, 'Tarte aux pommes', 13, 40, 3, 20, 'https://img.cuisineaz.com/660x660/2018-11-19/i144326-tarte-aux-pommes-pate-sablee-thermomix.jpeg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
