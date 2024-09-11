package com.example.project2.service;

import com.example.project2.model.StudentModel;
import com.example.project2.repository.InMemoryStudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryStudentImpl implements StudentService {

    private final InMemoryStudentRepository studentRepository;

    public InMemoryStudentImpl(InMemoryStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public StudentModel createStudent(StudentModel student) {
        return  studentRepository.createStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return  studentRepository.updateStudent(student);
    }

    @Override
    public StudentModel findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}
