-- Create a new database clap_db (if it doesn't exist)
CREATE DATABASE IF NOT EXISTS clap_db;

-- Use the newly created clap_db database
USE clap_db;

CREATE TABLE book
(
 bookId UUID NOT NULL,
 bookType varchar(100) NOT NULL,
 authorId varchar(100) NOT NULL,
 book_reference varchar(100) NOT NULL,
 numberOfPages int,
 totalNumberOfPages int,
 published boolean;
);

CREATE TABLE author (
 authorId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 firstName varchar(100) NOT NULL,
 lastName varchar(100) NOT NULL,
 authorName varchar(100) NOT NULL,
);

CREATE TABLE book_authors (
  PRIMARY KEY (bookId, authorId),
  FOREIGN KEY (bookId) REFERENCES Book(bookId),
  FOREIGN KEY (authorId) REFERENCES Author(AuthorId)
);