CREATE SCHEMA IF NOT EXISTS messaging_test;

CREATE TABLE IF NOT EXISTS Project (
  ProjectID          INT(20) PRIMARY KEY,
  ProjectTitle       VARCHAR(200),
  ProjectDescription VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS ProjectCost (
  ProjectCostID    INT(20) PRIMARY KEY,
  ProjectID        INT(20),
  ProjectCostValue DOUBLE
);
