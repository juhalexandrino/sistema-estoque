-- phpMyAdmin SQL Dump
-- version 3.5.4
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 01-Nov-2022 às 03:35
-- Versão do servidor: 5.5.28-log
-- versão do PHP: 5.4.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `db_estoque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_produto`
--

CREATE TABLE IF NOT EXISTS `tb_produto` (
  `codigo` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Extraindo dados da tabela `tb_produto`
--

INSERT INTO `tb_produto` (`codigo`, `quantidade`, `nome`, `descricao`) VALUES
(1, 26, 'Toalha de banho', 'Diversas estampas para praia e piscinas'),
(2, 30, 'Capas de almofada', 'Estampas fofas para pequenas almofadas'),
(3, 60, 'Das especies de flores mais conhecidas', 'Flores artificiais realistas'),
(4, 10, 'Estojo infantil', 'De todos os tamanhos e cores');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
