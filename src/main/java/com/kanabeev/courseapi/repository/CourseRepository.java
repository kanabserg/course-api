package com.kanabeev.courseapi.repository;

import com.kanabeev.courseapi.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    public List<Course> findByTopicId(long id);

}
