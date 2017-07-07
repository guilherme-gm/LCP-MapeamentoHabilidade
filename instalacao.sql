-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mapeamentohabilidade
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acesso`
--

DROP TABLE IF EXISTS `acesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acesso` (
  `idAcesso` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`idAcesso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acesso`
--

LOCK TABLES `acesso` WRITE;
/*!40000 ALTER TABLE `acesso` DISABLE KEYS */;
INSERT INTO `acesso` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `acesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `permissao` varchar(500) NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Administrador','GERENCIAR_CARGOS,GERENCIAR_PROJETOS,GERENCIAR_HABILIDADES,GERENCIAR_MEMBROS',1);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membro`
--

DROP TABLE IF EXISTS `membro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membro` (
  `idMembro` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dataContratacao` date NOT NULL,
  `ativo` tinyint(4) NOT NULL,
  `Acesso_idAcesso` bigint(20) NOT NULL,
  `Cargo_idCargo` int(11) NOT NULL,
  PRIMARY KEY (`idMembro`,`Acesso_idAcesso`,`Cargo_idCargo`),
  KEY `fk_Membro_Acesso_idx` (`Acesso_idAcesso`),
  KEY `fk_Membro_Cargo1_idx` (`Cargo_idCargo`),
  CONSTRAINT `fk_Membro_Acesso` FOREIGN KEY (`Acesso_idAcesso`) REFERENCES `acesso` (`idAcesso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membro_Cargo1` FOREIGN KEY (`Cargo_idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membro`
--

LOCK TABLES `membro` WRITE;
/*!40000 ALTER TABLE `membro` DISABLE KEYS */;
INSERT INTO `membro` VALUES (1,'Administrador','(99) 9999-9999','a@a.com','2017-01-01',1,1,1);
/*!40000 ALTER TABLE `membro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membro_has_projeto`
--

DROP TABLE IF EXISTS `membro_has_projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membro_has_projeto` (
  `Membro_idMembro` bigint(20) NOT NULL,
  `Projeto_idProjeto` bigint(20) NOT NULL,
  PRIMARY KEY (`Membro_idMembro`,`Projeto_idProjeto`),
  KEY `fk_Membro_has_Projeto_Projeto1_idx` (`Projeto_idProjeto`),
  KEY `fk_Membro_has_Projeto_Membro1_idx` (`Membro_idMembro`),
  CONSTRAINT `fk_Membro_has_Projeto_Membro1` FOREIGN KEY (`Membro_idMembro`) REFERENCES `membro` (`idMembro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membro_has_Projeto_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membro_has_projeto`
--

LOCK TABLES `membro_has_projeto` WRITE;
/*!40000 ALTER TABLE `membro_has_projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `membro_has_projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idProjeto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`idProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto_has_tecnologia`
--

DROP TABLE IF EXISTS `projeto_has_tecnologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto_has_tecnologia` (
  `Projeto_idProjeto` bigint(20) NOT NULL,
  `Tecnologia_idTecnologia` int(11) NOT NULL,
  PRIMARY KEY (`Projeto_idProjeto`,`Tecnologia_idTecnologia`),
  KEY `fk_Projeto_has_Tecnologia_Tecnologia1_idx` (`Tecnologia_idTecnologia`),
  KEY `fk_Projeto_has_Tecnologia_Projeto1_idx` (`Projeto_idProjeto`),
  CONSTRAINT `fk_Projeto_has_Tecnologia_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projeto_has_Tecnologia_Tecnologia1` FOREIGN KEY (`Tecnologia_idTecnologia`) REFERENCES `tecnologia` (`idTecnologia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto_has_tecnologia`
--

LOCK TABLES `projeto_has_tecnologia` WRITE;
/*!40000 ALTER TABLE `projeto_has_tecnologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto_has_tecnologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnologia`
--

DROP TABLE IF EXISTS `tecnologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnologia` (
  `idTecnologia` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idTecnologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnologia`
--

LOCK TABLES `tecnologia` WRITE;
/*!40000 ALTER TABLE `tecnologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnologiamembro`
--

DROP TABLE IF EXISTS `tecnologiamembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnologiamembro` (
  `idTecnologiaMembro` bigint(20) NOT NULL AUTO_INCREMENT,
  `nivel` smallint(6) NOT NULL,
  `Membro_idMembro` bigint(20) NOT NULL,
  `Tecnologia_idTecnologia` int(11) NOT NULL,
  PRIMARY KEY (`idTecnologiaMembro`,`Membro_idMembro`,`Tecnologia_idTecnologia`),
  KEY `fk_TecnologiaMembro_Membro1_idx` (`Membro_idMembro`),
  KEY `fk_TecnologiaMembro_Tecnologia1_idx` (`Tecnologia_idTecnologia`),
  CONSTRAINT `fk_TecnologiaMembro_Membro1` FOREIGN KEY (`Membro_idMembro`) REFERENCES `membro` (`idMembro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TecnologiaMembro_Tecnologia1` FOREIGN KEY (`Tecnologia_idTecnologia`) REFERENCES `tecnologia` (`idTecnologia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnologiamembro`
--

LOCK TABLES `tecnologiamembro` WRITE;
/*!40000 ALTER TABLE `tecnologiamembro` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnologiamembro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-06 22:00:42
