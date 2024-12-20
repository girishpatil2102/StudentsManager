package com.girish.StudentsManager.StudentsManagementSystem.service;

import com.girish.StudentsManager.StudentsManagementSystem.exception.StudentAlreadyExistsException;
import com.girish.StudentsManager.StudentsManagementSystem.exception.StudentNotFoundException;
import com.girish.StudentsManager.StudentsManagementSystem.model.Student;
import com.girish.StudentsManager.StudentsManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getEmail()+"already exists!");
        }
        return studentRepository.save(student);
    }
    private boolean studentAlreadyExists(String email){
         return studentRepository.findByEmail(email).isPresent();
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(s->{
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setDepartment(student.getDepartment());
            return studentRepository.save(s);
        }).orElseThrow(()->new StudentNotFoundException("Student not found!"));
    }


    @Override
    public Student getStudentbyId(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student Not Found !"));
    }


    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student Not Found!");
        }

        studentRepository.deleteById(id);
    }
}
