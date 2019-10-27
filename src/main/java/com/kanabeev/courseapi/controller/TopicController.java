package com.kanabeev.courseapi.controller;

import com.kanabeev.courseapi.domain.Topic;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic (1, "Spring Framework", "Spring Framework topic description"),
                new Topic (2, "Core Java", "Core Java topic description"),
                new Topic (3, "JavaScript", "JavaScript topic description")
        );
    }

    @GetMapping(("/topics/{id}"))
    public Topic getTopic(@PathVariable Long id){
        return new Topic();
    }

    @PostMapping(("/topics"))
    public void addNewTopic(@RequestParam Topic topic){
    }

    @PutMapping(("/topics/{id}"))
    public void updateTopic(@PathVariable Long id){
    }

    @DeleteMapping("/topics/{id}")
    public void addNewTopic(@PathVariable Long id){
    }
}
