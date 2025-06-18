-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 18 juin 2025 à 11:55
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `recouvrement_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `alerte`
--

CREATE TABLE `alerte` (
  `id_alerte` bigint(20) NOT NULL,
  `date_detection` datetime(6) DEFAULT NULL,
  `est_Consultee` tinyint(1) NOT NULL DEFAULT 0,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `alerte`
--

INSERT INTO `alerte` (`id_alerte`, `date_detection`, `est_Consultee`, `message`, `type`, `utilisateur_id`) VALUES
(1, '2025-06-17 11:00:00.000000', 1, 'Ceci est une alerte test', 'Test', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `reseau` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `email`, `nom`, `prenom`, `reseau`, `telephone`) VALUES
(1, 'may.sall@example.com', 'Sall', 'maymouna', 'expresso', '770000002'),
(7, 'dieynaba2.sow@example.com', 'Sy', 'Dieynaba', 'Orange', '770000001'),
(8, 'jean.dupont@example.com', 'Dupont', 'Jean', NULL, NULL),
(10, 'fatou.ba@sonatel.sn', 'Ba', 'Fatou', NULL, NULL),
(11, 'dieynaba.sow@example.com', 'Sow', 'Dieynaba', 'Orange', '770000000');

-- --------------------------------------------------------

--
-- Structure de la table `evenement_recouvrement`
--

CREATE TABLE `evenement_recouvrement` (
  `id_evenement` bigint(20) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date_evenement` date DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement_recouvrement`
--

INSERT INTO `evenement_recouvrement` (`id_evenement`, `commentaire`, `date_evenement`, `statut`, `type`, `client_id`) VALUES
(2, '', '2025-06-17', 'INACTIF', 'RESTRICTION', NULL),
(3, '', '2025-06-17', 'INACTIF', 'RESTRICTION', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id_facture` bigint(20) NOT NULL,
  `date_emission` date DEFAULT NULL,
  `echeance` date DEFAULT NULL,
  `montant` double NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `solde` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id_facture`, `date_emission`, `echeance`, `montant`, `statut`, `client_id`, `solde`) VALUES
(3, '2025-06-17', '2025-08-17', 120000, 'Partiellement payé', 1, 80000),
(5, '2025-06-17', '2025-07-17', 110000, 'En cours', 10, 20000);

-- --------------------------------------------------------

--
-- Structure de la table `indicateur`
--

CREATE TABLE `indicateur` (
  `id_indicateur` bigint(20) NOT NULL,
  `marche` varchar(255) DEFAULT NULL,
  `offre` varchar(255) DEFAULT NULL,
  `periode` varchar(255) DEFAULT NULL,
  `segment` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `valeur` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id_paiement` bigint(20) NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `mode_paiement` varchar(255) DEFAULT NULL,
  `montant_paye` double NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `facture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `parametre_general`
--

CREATE TABLE `parametre_general` (
  `id_parametre` bigint(20) NOT NULL,
  `marche` varchar(255) DEFAULT NULL,
  `offre` varchar(255) DEFAULT NULL,
  `periode_analyse` varchar(255) DEFAULT NULL,
  `segment` varchar(255) DEFAULT NULL,
  `seuil_alerte` double NOT NULL,
  `unite_monetaire` varchar(255) DEFAULT NULL,
  `admin_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` bigint(20) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(31) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `date_creation`, `email`, `mot_de_passe`, `nom`, `prenom`, `role`) VALUES
(2, '2025-06-17', 'mamadou.fall@example.com', 'admin123', 'Fall', 'Mamadou', 'ADMIN'),
(3, '2025-06-17', 'fatou.sow@example.com', 'util123', 'Sow', 'Fatou', 'UTILISATEUR_METIER');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alerte`
--
ALTER TABLE `alerte`
  ADD PRIMARY KEY (`id_alerte`),
  ADD KEY `FKa5jx0jtqovrcn2vcoyua9tldw` (`utilisateur_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `UKbfgjs3fem0hmjhvih80158x29` (`email`),
  ADD UNIQUE KEY `UK1rxa00yetw8yyqg6eus42k6ig` (`telephone`);

--
-- Index pour la table `evenement_recouvrement`
--
ALTER TABLE `evenement_recouvrement`
  ADD PRIMARY KEY (`id_evenement`),
  ADD KEY `FKqhm5hskmo2oki73vhtrwykxlr` (`client_id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`),
  ADD KEY `FKkimq62662qs9wrpfvsw8mcnvf` (`client_id`);

--
-- Index pour la table `indicateur`
--
ALTER TABLE `indicateur`
  ADD PRIMARY KEY (`id_indicateur`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id_paiement`),
  ADD KEY `FKcdf4b0vtaiu864ir0bhwm0jog` (`facture_id`),
  ADD KEY `FK2x9kwbd40g3ic8j4n3v512j7h` (`client_id`);

--
-- Index pour la table `parametre_general`
--
ALTER TABLE `parametre_general`
  ADD PRIMARY KEY (`id_parametre`),
  ADD KEY `FKdpc34m7aumg10udoca6glgo8b` (`admin_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `alerte`
--
ALTER TABLE `alerte`
  MODIFY `id_alerte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `evenement_recouvrement`
--
ALTER TABLE `evenement_recouvrement`
  MODIFY `id_evenement` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `indicateur`
--
ALTER TABLE `indicateur`
  MODIFY `id_indicateur` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id_paiement` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `parametre_general`
--
ALTER TABLE `parametre_general`
  MODIFY `id_parametre` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alerte`
--
ALTER TABLE `alerte`
  ADD CONSTRAINT `FKa5jx0jtqovrcn2vcoyua9tldw` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `evenement_recouvrement`
--
ALTER TABLE `evenement_recouvrement`
  ADD CONSTRAINT `FKqhm5hskmo2oki73vhtrwykxlr` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FKkimq62662qs9wrpfvsw8mcnvf` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `FK2x9kwbd40g3ic8j4n3v512j7h` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKcdf4b0vtaiu864ir0bhwm0jog` FOREIGN KEY (`facture_id`) REFERENCES `facture` (`id_facture`);

--
-- Contraintes pour la table `parametre_general`
--
ALTER TABLE `parametre_general`
  ADD CONSTRAINT `FKdpc34m7aumg10udoca6glgo8b` FOREIGN KEY (`admin_id`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
