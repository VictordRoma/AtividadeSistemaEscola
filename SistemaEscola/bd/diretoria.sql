-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Out-2022 às 21:10
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `diretoria`
--
CREATE DATABASE IF NOT EXISTS `diretoria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `diretoria`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblalunos`
--

CREATE TABLE `tblalunos` (
  `rm` int(250) NOT NULL,
  `nome` text NOT NULL,
  `idade` varchar(2) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `notafinal` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblalunos`
--

INSERT INTO `tblalunos` (`rm`, `nome`, `idade`, `telefone`, `email`, `notafinal`) VALUES
(1, 'Victor Roma', '16', '968533394', 'victor25032006@gmail.com', 'MB');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblcordenador`
--

CREATE TABLE `tblcordenador` (
  `Login` varchar(255) NOT NULL,
  `Senha` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblcordenador`
--

INSERT INTO `tblcordenador` (`Login`, `Senha`) VALUES
('adm', '12345'),
('victor', '12345');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tblalunos`
--
ALTER TABLE `tblalunos`
  ADD PRIMARY KEY (`rm`);

--
-- Índices para tabela `tblcordenador`
--
ALTER TABLE `tblcordenador`
  ADD PRIMARY KEY (`Login`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tblalunos`
--
ALTER TABLE `tblalunos`
  MODIFY `rm` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
