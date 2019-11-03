package com.kanabeev.courseapi.controller;

import com.kanabeev.courseapi.domain.Topic;
import com.kanabeev.courseapi.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addNewTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Long id){
        topicService.deleteTopic(id);
    }
}
