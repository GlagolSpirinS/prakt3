package com.example.project2.repository;

import com.example.project2.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryStudentRepository {

    private final Map<Long, StudentModel> studentMap = new HashMap<>();
    private long currentId = 1;

    public List<StudentModel> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    public StudentModel createStudent(StudentModel student) {
        student.setId(currentId++);
        studentMap.put(student.getId(), student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student) {
        studentMap.put(student.getId(), student);
        return student;
    }

    public StudentModel findStudentById(Long id) {
        return studentMap.get(id);
    }

    public void deleteStudent(Long id) {
        studentMap.remove(id);
    }
}
