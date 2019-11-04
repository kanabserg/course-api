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

DO
$$
  DECLARE
    topic_id_spring BIGINT;
    topic_id_jcore  BIGINT;
    topic_id_js     BIGINT;
  BEGIN
    INSERT INTO coursemanagement.topic (name,description) VALUES ('Spring Framework', 'Spring Framework topic description')
      RETURNING id INTO topic_id_spring;

    INSERT INTO coursemanagement.topic (name,description) VALUES ('Core Java', 'Core Java topic description')
      RETURNING id INTO topic_id_jcore;

    INSERT INTO coursemanagement.topic (name, description)
    VALUES ('JavaScript', 'JavaScript topic description')
        RETURNING id INTO topic_id_js;

    INSERT INTO coursemanagement.course (topic_id, name, description)
    VALUES (topic_id_spring, 'Introduction', 'Spring Framework introduction'),
           (topic_id_spring, 'Basics', 'Discussion about basics');

  END
$$;