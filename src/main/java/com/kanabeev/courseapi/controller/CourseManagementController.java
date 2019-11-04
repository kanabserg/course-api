package com.kanabeev.courseapi.controller;

import com.kanabeev.courseapi.domain.Course;
import com.kanabeev.courseapi.domain.Topic;
import com.kanabeev.courseapi.service.CourseService;
import com.kanabeev.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseManagementController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CourseService courseService;

    /****************************************Topic endpoints****************************************/

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable long id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addNewTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable long id){
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable long id){
        topicService.deleteTopic(id);
    }


    /****************************************Course endpoints****************************************/

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllTopicCourses(@PathVariable("id") long topicId){
        return courseService.getAllTopicCourses(topicId);
    }
}
