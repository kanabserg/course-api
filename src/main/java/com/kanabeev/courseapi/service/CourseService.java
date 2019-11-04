package com.kanabeev.courseapi.service;

import com.kanabeev.courseapi.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllTopicCourses(long topicId);

    Course getCourse(long id);

    void addCourse(Course course);

    void updateCourse(Course course, long id);

    void deleteCourse(long id);
}
