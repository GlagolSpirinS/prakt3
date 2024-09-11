package com.example.project2.controller;

import com.example.project2.model.FacultyModel;
import com.example.project2.model.PersonaDataModel;
import com.example.project2.model.StudentModel;
import com.example.project2.service.FacultyService;
import com.example.project2.service.StudentService;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private final FacultyService facultyService;

    @Autowired
    public StudentController(StudentService studentService, FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @GetMapping("")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "studentList"; // Убедитесь, что файл studentList.html существует в папке templates
    }

    @GetMapping("/create")
    public String getCreateStudent(Model model) {
        model.addAttribute("studentModel", new StudentModel());
        model.addAttribute("faculties", facultyService.getAllFaculties()); // Передаем список факультетов
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

        // Извлекаем объект FacultyModel по переданному ID
        FacultyModel faculty = facultyService.getFacultyById(studentModel.getFacultyModel().getId());
        studentModel.setFacultyModel(faculty);

        studentService.createStudent(studentModel);
        redirectAttributes.addFlashAttribute("successMessage", "Студент успешно добавлен!");
        return "redirect:/student";
    }

    @PostMapping("/edit")
    public String postEditStudent(
            @Valid @ModelAttribute("studentModel") StudentModel studentModel,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "editStudent";
        }

        FacultyModel faculty = facultyService.getFacultyById(studentModel.getFacultyModel().getId());
        studentModel.setFacultyModel(faculty);

        studentService.updateStudent(studentModel);
        redirectAttributes.addFlashAttribute("successMessage", "Студент успешно обновлен!");
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        if (student == null) {
            return "redirect:/student"; // Если студент не найден, перенаправляем на список
        }
        model.addAttribute("studentModel", student);
        model.addAttribute("faculties", facultyService.getAllFaculties()); // Передаем список факультетов
        return "editStudent";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("successMessage", "Студент успешно удален!");
        return "redirect:/student";
    }
}




