package com.example.project2.service;

import com.example.project2.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getAllStudents();
    StudentModel createStudent(StudentModel student);
    StudentModel updateStudent(StudentModel student);
    StudentModel getStudentById(Long id); // Используйте getStudentById
    void deleteStudent(Long id);
}
