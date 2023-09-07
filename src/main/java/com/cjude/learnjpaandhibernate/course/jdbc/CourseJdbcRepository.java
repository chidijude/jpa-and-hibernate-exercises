package com.cjude.learnjpaandhibernate.course.jdbc;

import com.cjude.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_QUERY =
            """
                INSERT INTO COURSE (id, name, author)
                VALUES (?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
                DELETE FROM COURSE 
                WHERE id = ?;
            """;

    private static final String SELECT_QUERY =
            """
                SELECT * FROM COURSE 
                WHERE id = ?;
            """;
    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        //ResultSet -> Bean ==> RowMapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
