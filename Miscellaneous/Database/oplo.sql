-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 03 mars 2022 à 18:43
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `oplo`
--

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT 'Nom de la compétence',
  `description` varchar(300) DEFAULT NULL COMMENT 'Description de la compétence'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`id`, `name`, `description`) VALUES
(1, 'Blockchain', 'Peut développer des applications sur la blockchain.'),
(2, 'Marketing', NULL),
(3, 'Comptabilité', 'Un comptable collecte, analyse et contrôle les dépenses, revenus ou investissements de l\'entreprise. Il retranscrit ces flux sous forme de chiffres dans des comptes différents du plan comptable.'),
(4, 'Gestion de personnel', 'Est capable de gérer jusqu\'à 20 employés.'),
(5, 'Outils informatiques', NULL),
(6, 'Expert en réseaux informatiques', NULL),
(7, 'Expert en programmation fonctionnelle', 'Maitrise tous les langages fonctionnels.'),
(8, 'Expert en sécurité informatique', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `deadline`
--

CREATE TABLE `deadline` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT 'titre de la deadline',
  `date` datetime NOT NULL COMMENT 'Date de la deadline',
  `description` varchar(200) NOT NULL,
  `project_id` int(11) NOT NULL COMMENT 'id du projet auquel la deadline appartient'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `identity`
--

CREATE TABLE `identity` (
  `id` int(11) NOT NULL,
  `num_secu` varchar(15) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `others` varchar(200) DEFAULT NULL COMMENT 'Informations complémentaire à ajouter sur l''utilisateur',
  `profile_pic` varchar(100) NOT NULL DEFAULT 'profile.png' COMMENT 'Nom de la photo de profil ex "facedebouk.png"'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `identity_has_competence`
--

CREATE TABLE `identity_has_competence` (
  `competence_id` int(11) NOT NULL COMMENT 'Id de la compétence ',
  `identity_id` int(11) NOT NULL COMMENT 'id de l''identité qui possède cette compétence'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `content` varchar(500) NOT NULL COMMENT 'Contenu du message',
  `date` datetime NOT NULL DEFAULT current_timestamp() COMMENT 'Date d''écriture du message',
  `author_login` varchar(45) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Id de l''auteur du message',
  `project_id` int(11) NOT NULL COMMENT 'Id du projet sur lequel ce message doit apparaitre'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT 'Nom du projet',
  `description` varchar(500) DEFAULT NULL COMMENT 'Description du projet',
  `start_date` date NOT NULL DEFAULT current_timestamp() COMMENT 'Date début du projet',
  `end_date` date NOT NULL COMMENT 'Date fin du projet',
  `creator_login` varchar(45) CHARACTER SET utf8mb4 NOT NULL COMMENT 'login de l''user qui a creer ce projet'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `login` varchar(45) CHARACTER SET utf8mb4 NOT NULL COMMENT 'Identifiant avec lequel l''user se connecte',
  `password` varchar(256) NOT NULL COMMENT 'Mot de passe de l''utilisateur',
  `role` enum('chefProjet','admin','employe','responsable') NOT NULL COMMENT 'Quel role dans l''application a l''user'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_has_identity`
--

CREATE TABLE `user_has_identity` (
  `user_login` varchar(45) NOT NULL,
  `identity_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user_has_project`
--

CREATE TABLE `user_has_project` (
  `project_id` int(11) NOT NULL COMMENT 'id du projet',
  `user_login` varchar(45) CHARACTER SET utf8mb4 NOT NULL COMMENT 'login de l''utilisateur'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `deadline`
--
ALTER TABLE `deadline`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_project_id` (`project_id`);

--
-- Index pour la table `identity`
--
ALTER TABLE `identity`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `identity_has_competence`
--
ALTER TABLE `identity_has_competence`
  ADD PRIMARY KEY (`competence_id`,`identity_id`),
  ADD KEY `identity_id` (`identity_id`);

--
-- Index pour la table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_author_login` (`author_login`),
  ADD KEY `fk_project_id` (`project_id`);

--
-- Index pour la table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_creator_login` (`creator_login`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `user_has_identity`
--
ALTER TABLE `user_has_identity`
  ADD PRIMARY KEY (`user_login`,`identity_id`),
  ADD KEY `identity_id` (`identity_id`);

--
-- Index pour la table `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD PRIMARY KEY (`project_id`,`user_login`),
  ADD KEY `user_login` (`user_login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `deadline`
--
ALTER TABLE `deadline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `identity`
--
ALTER TABLE `identity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `deadline`
--
ALTER TABLE `deadline`
  ADD CONSTRAINT `deadline_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Contraintes pour la table `identity_has_competence`
--
ALTER TABLE `identity_has_competence`
  ADD CONSTRAINT `identity_has_competence_ibfk_1` FOREIGN KEY (`identity_id`) REFERENCES `identity` (`id`),
  ADD CONSTRAINT `identity_has_competence_ibfk_2` FOREIGN KEY (`competence_id`) REFERENCES `competence` (`id`);

--
-- Contraintes pour la table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`author_login`) REFERENCES `user` (`login`),
  ADD CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Contraintes pour la table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`creator_login`) REFERENCES `user` (`login`);

--
-- Contraintes pour la table `user_has_identity`
--
ALTER TABLE `user_has_identity`
  ADD CONSTRAINT `user_has_identity_ibfk_1` FOREIGN KEY (`identity_id`) REFERENCES `identity` (`id`),
  ADD CONSTRAINT `user_has_identity_ibfk_2` FOREIGN KEY (`user_login`) REFERENCES `user` (`login`);

--
-- Contraintes pour la table `user_has_project`
--
ALTER TABLE `user_has_project`
  ADD CONSTRAINT `user_has_project_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  ADD CONSTRAINT `user_has_project_ibfk_2` FOREIGN KEY (`user_login`) REFERENCES `user` (`login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
