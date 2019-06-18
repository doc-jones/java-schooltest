package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Student;

import java.util.ArrayList;

public interface StudentService
{
    ArrayList<Student> findAll();

    Student findStudentById(long id);

    Student save(Student student);
}
