package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.repository.CourseRepository;
import com.lambdaschool.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studrepos;

    @Autowired
    private CourseRepository courserepos;

    @Override
    public ArrayList<Student> findAll()
    {
        ArrayList<Student> list = new ArrayList<>();
        studrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Student findStudentById(long id) throws EntityNotFoundException
    {
        return studrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public Student save(Student student)
    {
        Student newStudent = new Student();

        newStudent.setStudname(student.getStudname());

        for (Course c: student.getCourses())
        {
            newStudent.getCourses().add(courserepos.findById(c.getCourseid()).orElseThrow(() -> new EntityNotFoundException(Long.toString(c.getCourseid()))));
        }

        return studrepos.save(newStudent);
    }
}
