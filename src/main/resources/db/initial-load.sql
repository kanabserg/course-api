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