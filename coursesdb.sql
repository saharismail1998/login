-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2020 at 12:22 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `coursetb`
--

CREATE TABLE `coursetb` (
  `cid` int(11) NOT NULL,
  `cname` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coursetb`
--

INSERT INTO `coursetb` (`cid`, `cname`) VALUES
(9, 'hhhhyyy'),
(13, 'php'),
(14, 'Data Base55');

-- --------------------------------------------------------

--
-- Table structure for table `stdcoursetb`
--

CREATE TABLE `stdcoursetb` (
  `scid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student_tb`
--

CREATE TABLE `student_tb` (
  `sid` int(11) NOT NULL,
  `sname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_tb`
--

INSERT INTO `student_tb` (`sid`, `sname`) VALUES
(1, 'fatemah'),
(2, 'lama'),
(3, 'ali'),
(4, 'ahmad'),
(5, 'balsam'),
(6, 'noor');

-- --------------------------------------------------------

--
-- Table structure for table `techcoursetb`
--

CREATE TABLE `techcoursetb` (
  `tid` int(11) NOT NULL,
  `cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tech_tb`
--

CREATE TABLE `tech_tb` (
  `tid` int(11) NOT NULL,
  `tname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coursetb`
--
ALTER TABLE `coursetb`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `stdcoursetb`
--
ALTER TABLE `stdcoursetb`
  ADD PRIMARY KEY (`scid`),
  ADD KEY `cid` (`cid`),
  ADD KEY `sid` (`sid`);

--
-- Indexes for table `student_tb`
--
ALTER TABLE `student_tb`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `techcoursetb`
--
ALTER TABLE `techcoursetb`
  ADD PRIMARY KEY (`cid`,`tid`),
  ADD KEY `tid` (`tid`);

--
-- Indexes for table `tech_tb`
--
ALTER TABLE `tech_tb`
  ADD PRIMARY KEY (`tid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coursetb`
--
ALTER TABLE `coursetb`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `stdcoursetb`
--
ALTER TABLE `stdcoursetb`
  MODIFY `scid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `student_tb`
--
ALTER TABLE `student_tb`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tech_tb`
--
ALTER TABLE `tech_tb`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `stdcoursetb`
--
ALTER TABLE `stdcoursetb`
  ADD CONSTRAINT `stdcoursetb_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `coursetb` (`cid`),
  ADD CONSTRAINT `stdcoursetb_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student_tb` (`sid`);

--
-- Constraints for table `techcoursetb`
--
ALTER TABLE `techcoursetb`
  ADD CONSTRAINT `techcoursetb_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `coursetb` (`cid`),
  ADD CONSTRAINT `techcoursetb_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tech_tb` (`tid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
