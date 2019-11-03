package com.kanabeev.courseapi.service;

import com.kanabeev.courseapi.domain.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopic(long id);

    void addTopic(Topic topic);

    void updateTopic(Topic topic, long id);

    void deleteTopic (long id);
}
