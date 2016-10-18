-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 18 2016 г., 16:29
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `stone`
--
CREATE DATABASE `stone` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `stone`;

-- --------------------------------------------------------

--
-- Структура таблицы `precious_stone`
--

CREATE TABLE IF NOT EXISTS `precious_stone` (
  `STONE_ID` int(11) NOT NULL,
  `SYNGONY` varchar(30) NOT NULL,
  UNIQUE KEY `STONE_ID` (`STONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `precious_stone`
--

INSERT INTO `precious_stone` (`STONE_ID`, `SYNGONY`) VALUES
(1, 'thrigonal'),
(2, 'thrigonal'),
(3, 'cubic'),
(5, 'unstable');

-- --------------------------------------------------------

--
-- Структура таблицы `semiprecious_stone`
--

CREATE TABLE IF NOT EXISTS `semiprecious_stone` (
  `STONE_ID` int(11) NOT NULL,
  `COLOUR_FEATURES` varchar(30) NOT NULL,
  UNIQUE KEY `STONE_ID` (`STONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `semiprecious_stone`
--

INSERT INTO `semiprecious_stone` (`STONE_ID`, `COLOUR_FEATURES`) VALUES
(4, 'glass'),
(6, 'white');

-- --------------------------------------------------------

--
-- Структура таблицы `stone`
--

CREATE TABLE IF NOT EXISTS `stone` (
  `STONE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STONE_NAME` varchar(30) NOT NULL,
  `STONE_CARAT` double NOT NULL,
  `STONE_PRICE` double NOT NULL,
  `STONE_COLOUR` varchar(30) NOT NULL,
  `STONE_SOLIDITY` double NOT NULL,
  `STONE_DENCITY` double NOT NULL,
  `STONE_TYPE` varchar(30) NOT NULL,
  PRIMARY KEY (`STONE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `stone`
--

INSERT INTO `stone` (`STONE_ID`, `STONE_NAME`, `STONE_CARAT`, `STONE_PRICE`, `STONE_COLOUR`, `STONE_SOLIDITY`, `STONE_DENCITY`, `STONE_TYPE`) VALUES
(1, 'Diamond', 5, 3000, 'white', 10, 2.65, 'Padparaja'),
(2, 'Kvarcz', 10, 1000, 'greish-brown', 7, 2.52, 'Glass'),
(3, 'Corund', 11, 6000, 'dark-bluse', 9, 4.05, 'Sapfir'),
(4, 'Halczedon', 100, 50, 'dark', 6, 2.65, 'Onix'),
(5, 'Granat', 30, 2000, 'green', 6.5, 3.84, 'Demantoid'),
(6, 'Biryuza', 20, 30, 'green', 5, 2.6, 'None');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
