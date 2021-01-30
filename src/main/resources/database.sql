CREATE DATABASE TRAVEL;
CREATE TABLE CITYINFO(
                        ID  SERIAL PRIMARY KEY,
                        NAME            CHAR(100)      NOT NULL,
                        DESCRIPTION     TEXT           NOT NULL
);