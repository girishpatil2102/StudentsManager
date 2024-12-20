package com.girish.StudentsManager.StudentsManagementSystem.controller;

import com.girish.StudentsManager.StudentsManagementSystem.model.Student;
import com.girish.StudentsManager.StudentsManagementSystem.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return iStudentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return iStudentService.updateStudent(student,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return iStudentService.getStudentbyId(id);
    }
}
