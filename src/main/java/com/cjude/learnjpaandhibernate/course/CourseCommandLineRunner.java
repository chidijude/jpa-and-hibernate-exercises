package com.cjude.learnjpaandhibernate.course;

import com.cjude.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //@Autowired
    //private CourseJdbcRepository repository;

    //@Autowired
    //private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn Python JPA", "Chid Wong"));
        repository.save(new Course(2, "Learn Java JPA", "Kome Wong"));
        repository.save(new Course(3, "Learn Azure JPA", "Oba Nikoro"));
        repository.save(new Course(4, "Learn AWS JPA", "Dera Love"));

        repository.deleteById(2l);

        System.out.println(repository.findById(3l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Dera Love"));
        System.out.println(repository.findByName("Learn AWS JPA"));
    }
}
