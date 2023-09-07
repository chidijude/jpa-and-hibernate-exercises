package com.cjude.learnjpaandhibernate.course.springdatajpa;

import com.cjude.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    //To have custom search queries use findBy followed by name of property
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
