CREATE DATABASE IF NOT EXISTS lapsapjava CHARACTER SET utf8;
USE lapsapjava;

DROP TABLE IF EXISTS dairy;
DROP VIEW IF EXISTS dairy;
CREATE TABLE dairy (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `event` longtext NOT NULL DEFAULT '',
`date` char(25) ,
`title` char(25) ,
 PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
