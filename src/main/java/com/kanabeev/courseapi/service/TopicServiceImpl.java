package com.kanabeev.courseapi.service;

import com.kanabeev.courseapi.domain.Topic;
import com.kanabeev.courseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopic(long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(Topic topic, long id) {
        topic.setId(id);
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(long id) {
        topicRepository.deleteById(id);
    }
}
