package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.view.CountStudentsInCourses;

import javax.persistence.Id;
import java.util.ArrayList;

public interface CourseService
{
    ArrayList<Course> findAll();

    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void findCourseById(long Id);

    void delete(long id);
}
