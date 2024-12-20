package com.girish.StudentsManager.StudentsManagementSystem.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
