package com.example.project2.controller;

import com.example.project2.model.FacultyModel;
import com.example.project2.model.PersonaDataModel;
import com.example.project2.model.StudentModel;
import com.example.project2.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentAll(Model model) {
        var students = studentService.findAllStudent();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateStudent(Model model) {
        StudentModel studentModel = new StudentModel();
        studentModel.setPersonaDataModel(new PersonaDataModel()); // Инициализируйте вложенные объекты
        studentModel.setFacultyModel(new FacultyModel()); // Инициализируйте вложенные объекты
        model.addAttribute("studentModel", studentModel);
        return "createStudent";
    }

    @PostMapping("/create")
    public String postCreateStudent(
            @Valid @ModelAttribute("studentModel") StudentModel studentModel,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "createStudent";
        }
        studentService.createStudent(studentModel);
        redirectAttributes.addFlashAttribute("successMessage", "Студент успешно создан!");
        return "redirect:/student";
    }
}
