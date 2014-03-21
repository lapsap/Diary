CREATE DATABASE IF NOT EXISTS lapsapjava CHARACTER SET utf8;
USE lapsapjava;

DROP TABLE IF EXISTS diary;
DROP VIEW IF EXISTS diary;
CREATE TABLE diary (
   `id` int(11) NOT NULL AUTO_INCREMENT,
  `event` longtext NOT NULL ,
`date` char(25) ,
`title` char(25) ,
`image` longblob NULL,
`mood` char(25) ,
 PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
