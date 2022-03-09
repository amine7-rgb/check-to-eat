-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 02 mars 2022 à 17:42
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `etudiant`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`) VALUES
(1, 'd'),
(3, 'dddx');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `id` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `salaire` float NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id`, `date_debut`, `date_fin`, `salaire`, `type`) VALUES
(1, '2022-01-05', '2022-01-26', 21, 'CDI'),
(2, '2022-01-05', '2022-01-26', 21, 'CDD');

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `categorie_id` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `menu`
--

INSERT INTO `menu` (`id`, `Nom`, `prix`, `categorie_id`, `image`, `description`) VALUES
(4, 'dddddcc', 5, 2, 'C:\\Users\\USER\\Pictures\\4.png', 'dddd'),
(5, 'ddddd', 444, 2, 'C:\\Users\\USER\\Pictures\\4.png', 'dddd'),
(6, 'ddddd', 444, 1, 'C:\\Users\\USER\\Pictures\\4.png', 'dddd'),
(7, 'ddddd', 444, 1, 'C:\\Users\\USER\\Pictures\\4.png', 'dddd'),
(8, 'ddddd', 444, 1, 'C:\\Users\\USER\\Pictures\\4.png', 'dddd');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `vol` int(255) NOT NULL,
  `nbplace` int(11) NOT NULL,
  `nom` varchar(225) NOT NULL,
  `date` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `vol`, `nbplace`, `nom`, `date`) VALUES
(77, 5, 2, 'zeze', '2022-02-01'),
(104, 4, 1, 'zzzzz', '2022-02-03'),
(105, 1, 2, 'sssssss', '2021-03-18'),
(106, 3, 2, 'aaa', '2022-02-09'),
(107, 4, 2, 'zzzzzz', '2022-02-04'),
(108, 1, 1, 'zzz', '2017-01-01'),
(109, 3, 3, 'aaa', '2022-02-09'),
(110, 44, 7, 'aaaa', '2017-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `id` int(11) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`id`, `destination`, `prix`, `date`) VALUES
(4, 'zzzzzz', 11, '2022-02-04'),
(5, 'ssssss', 444, '2022-02-03'),
(8, 'ZZF', 555, '2022-02-26'),
(9, 'parix', 500, '2022-01-01');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `reservation_ibfk_1` (`vol`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT pour la table `vol`
--
ALTER TABLE `vol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
