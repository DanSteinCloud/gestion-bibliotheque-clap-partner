CREATE TABLE book
(
 book_id UUID NOT NULL,
 book_type varchar(100) NOT NULL,
 authorId varchar(100) NOT NULL,
 book_reference varchar(100) NOT NULL,
 numberOfPages int,
 totalNumberOfPages int,
);

CREATE TABLE author (
 authorId int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 authorName varchar(100) NOT NULL,
);