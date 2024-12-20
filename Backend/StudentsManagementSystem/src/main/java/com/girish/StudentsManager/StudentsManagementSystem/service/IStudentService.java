package com.girish.StudentsManager.StudentsManagementSystem.service;

import com.girish.StudentsManager.StudentsManagementSystem.model.Student;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);

    List<Student> getStudents();

    Student updateStudent(Student student, Long id);

    Student getStudentbyId(Long id);

    void deleteStudent(Long id);
}
