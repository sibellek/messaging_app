-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Sep 30, 2022 at 11:21 AM
-- Server version: 5.7.31
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `public_chat`
--

DROP TABLE IF EXISTS `public_chat`;
CREATE TABLE IF NOT EXISTS `public_chat` (
  `id_pc` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) NOT NULL,
  `message` varchar(30) NOT NULL,
  `receiver` varchar(30) NOT NULL,
  PRIMARY KEY (`id_pc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `public_chat`
--

INSERT INTO `public_chat` (`id_pc`, `sender`, `message`, `receiver`) VALUES
(1, 's', 'hey', 'u'),
(2, 'u', 'heyy', 's'),
(3, 's', 'hey', 'u'),
(4, 'u', 'hey', 's');

-- --------------------------------------------------------

--
-- Table structure for table `the_app_users`
--

DROP TABLE IF EXISTS `the_app_users`;
CREATE TABLE IF NOT EXISTS `the_app_users` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_fname` varchar(30) NOT NULL,
  `u_lname` varchar(30) NOT NULL,
  `u_uname` varchar(30) NOT NULL,
  `u_pass` varchar(30) NOT NULL,
  `u_gender` varchar(6) NOT NULL,
  `u_ppic` varchar(50) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `the_app_users`
--

INSERT INTO `the_app_users` (`u_id`, `u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_gender`, `u_ppic`) VALUES
(1, 'sibelle', 'khayrallah', 's', 's', 'Male', 'C:\\Users\\USER\\Desktop\\pics\\images.png'),
(2, 'another', 'user', 'u', 'u', 'Male', 'C:\\Users\\USER\\Desktop\\pics\\images.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
