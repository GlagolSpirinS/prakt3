package com.example.project2.service;

import com.example.project2.model.StudentModel;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentImpl implements StudentService {

    private final List<StudentModel> students = new ArrayList<>();

    @Override
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public StudentModel createStudent(StudentModel student) {
        students.add(student);
        return student;
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        // Реализация обновления
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    @Override
    public StudentModel getStudentById(Long id) {
        // Реализация поиска студента по ID
        for (StudentModel student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
