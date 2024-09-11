package com.example.project2.service;

import com.example.project2.model.StudentModel;
import com.example.project2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentModel> findAllStudent() {
        return studentRepository.findAll(); // Этот метод дублирует getAllStudents(), рассмотрите удаление
    }

    @Override
    public StudentModel createStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentModel getStudentById(Long id) {
        Optional<StudentModel> student = studentRepository.findById(id);
        return student.orElse(null); // Возвращает null, если студент не найден
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
