package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class, secure = false)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception {
//        place mock data here - must use a list versus a db
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() {
    }

    @Test
    public void getCountStudentsInCourses() {
    }

//    @Test
//    public void getCourseById() {
//
//        String url = "course/12";
//
//        Mockito.when(courseService.findCourseById(12)).thenReturn(courseList.get(1));
//
//        RequestBuilder rb = MockMvcRequestBuilders.get(apiURL).accept(MediaType.APPLICATION_JSON);
//        MvcResult r = mockMvc.perform(rb).andReturn();
//        String tr = r.getResponse().getContentAsString();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String er = mapper.writeValueAsString(courseList.get(1));
//
//        assertsEquals("Rest API Returns List, er, tr");
//    }

    @Test
    public void getRestaurantByIdNotFound() throws Exception
    {
        String apiUrl = "/course/77";
​
        Mockito.when(courseService.findCourseById(77)).thenReturn(null);
​
        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();
​
        String er = "";
​
        assertEquals("Rest API Returns List", er, tr);
    }

    @Test
    public void deleteCourseById() {
    }
}