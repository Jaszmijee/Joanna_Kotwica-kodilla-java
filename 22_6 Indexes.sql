# Procedure and index for BOOKS

DROP PROCEDURE IF EXISTS FindBookByTitle;

DELIMITER $$

CREATE PROCEDURE FindBookByTitle(BOOKTITLE VARCHAR(255))
    BEGIN
SELECT * FROM BOOKS WHERE TITLE = BOOKTITLE;
END $$

DELIMITER ;

EXPLAIN
SELECT * FROM BOOKS WHERE TITLE = 'The Stranger';

# Output:
[2023-02-14 09:50:29] 1 row retrieved starting from 1 in 40 ms (execution: 6 ms, fetching: 34 ms)

CREATE INDEX BOOK_TITLE ON BOOKS (TITLE);

EXPLAIN
SELECT * FROM BOOKS WHERE TITLE = 'The Stranger';

# Output:
[2023-02-14 09:51:35] 1 row retrieved starting from 1 in 37 ms (execution: 5 ms, fetching: 32 ms)


# Procedure and index for READERS

DROP PROCEDURE IF EXISTS FindReaderByName;

DELIMITER $$

CREATE PROCEDURE FindReaderByName(FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255))
BEGIN
    SELECT *
    FROM READERS
    WHERE :FIRST_NAME IS NULL
       OR FIRSTNAME = FIRST_NAME
       AND :LAST_NAME IS NULL
       OR LASTNAME = LAST_NAME;
END $$

DELIMITER ;

EXPLAIN SELECT *
    FROM READERS
    WHERE :FIRST_NAME IS NULL
       OR FIRSTNAME = 'John'
       AND :LAST_NAME IS NULL
       OR LASTNAME = null;

# Output:
[2023-02-14 10:26:24] 1 row retrieved starting from 1 in 54 ms (execution: 12 ms, fetching: 42 ms)

CREATE INDEX FIRST_NAME ON READERS (FIRSTNAME);
CREATE INDEX LAST_NAME ON READERS (LASTNAME);

EXPLAIN SELECT *
    FROM READERS
    WHERE :FIRST_NAME IS NULL
       OR FIRSTNAME = 'John'
       AND :LAST_NAME IS NULL
       OR LASTNAME = null;

# Output:
[2023-02-14 10:28:33] 1 row retrieved starting from 1 in 61 ms (execution: 5 ms, fetching: 56 ms)