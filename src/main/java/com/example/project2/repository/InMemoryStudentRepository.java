package com.example.project2.repository;

import com.example.project2.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@Repository
public class InMemoryStudentRepository {
    private final List<StudentModel> STUDENTS = new ArrayList<>();

    public List<StudentModel> findAllStudent(){
        return STUDENTS;
    }

    public  StudentModel findStudentById(Long id){
       return STUDENTS.stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
    }

    public StudentModel createStudent(StudentModel student){
        STUDENTS.add(student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student){
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index-> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex == -1){
            return null;
        }
        STUDENTS.set(studentIndex, student);
        return student;
    }

    public void deleteStudent (Long  id){
        var student = findStudentById(id);
        if(student != null){
            STUDENTS.remove(student);
        }
    }
}
