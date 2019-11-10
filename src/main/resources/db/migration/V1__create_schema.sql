CREATE SCHEMA IF NOT EXISTS coursemanagement AUTHORIZATION postgres;

CREATE SEQUENCE coursemanagement.common_id_seq START 1 CACHE 20;

CREATE DOMAIN coursemanagement.PRIMARYKEY AS BIGINT NOT NULL DEFAULT nextval('coursemanagement.common_id_seq');

CREATE TABLE IF NOT EXISTS coursemanagement.topic
(
  id          coursemanagement.PRIMARYKEY   CONSTRAINT topic_pk PRIMARY KEY,
  name        TEXT                          NOT NULL,
  description TEXT                          NOT NULL
);

CREATE TABLE IF NOT EXISTS coursemanagement.course
(
  id          coursemanagement.PRIMARYKEY   CONSTRAINT course_pk PRIMARY KEY,
  name        TEXT                          NOT NULL,
  description TEXT                          NOT NULL,
  topic_id    BIGINT                        NOT NULL,
  CONSTRAINT course_topic_fk FOREIGN KEY (topic_id) REFERENCES coursemanagement.topic (id) ON DELETE CASCADE
);
