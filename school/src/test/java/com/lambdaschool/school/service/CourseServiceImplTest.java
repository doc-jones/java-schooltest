package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {

        assertEquals(6, courseService.findAll().size());
    }

//    @Test
//    public void findById() {
//
//        assertEquals("JavaScript", courseService.findById(2).getName());
//    }
//
//    @Test
//    public void findByIdNo() {
//
//        assertEquals(23, courseService.findById(23).getName());
//    }

    @Test
    public void getCountStudentsInCourse() {
    }

    @Test
    public void delete() {
        courseService.delete(2);
        assertEquals(5, courseService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound() {
     courseService.delete(23);
     assertEquals(5, courseService.findAll().size());
    }
}