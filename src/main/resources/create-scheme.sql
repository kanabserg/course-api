CREATE SCHEMA IF NOT EXISTS coursemanagement AUTHORIZATION postgres;

CREATE SEQUENCE coursemanagement.common_id_seq START 1 CACHE 20;

CREATE DOMAIN coursemanagement.PRIMARYKEY AS BIGINT NOT NULL DEFAULT nextval('coursemanagement.common_id_seq');

CREATE TABLE IF NOT EXISTS coursemanagement.topic
(
  id      coursemanagement.PRIMARYKEY  CONSTRAINT topic_pk PRIMARY KEY,
  name    TEXT      NOT NULL,
  description TEXT      NOT NULL
);

INSERT INTO coursemanagement.topic (name,description) VALUES ('Spring Framework', 'Spring Framework topic description');
INSERT INTO coursemanagement.topic (name,description) VALUES ('Core Java', 'Core Java topic description');
INSERT INTO coursemanagement.topic (name,description) VALUES ('JavaScript', 'JavaScript topic description');