package com.example.project2.controller;

import com.example.project2.model.FacultyModel;
import com.example.project2.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/create")
    public String showCreateFacultyForm(Model model) {
        model.addAttribute("facultyModel", new FacultyModel());
        return "createFaculty";
    }

    @PostMapping("/create")
    public String createFaculty(@Valid @ModelAttribute("facultyModel") FacultyModel facultyModel, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "createFaculty";
        }
        facultyService.createFaculty(facultyModel);
        redirectAttributes.addFlashAttribute("successMessage", "Факультет успешно добавлен!");
        return "redirect:/faculty";
    }

    @GetMapping
    public String listFaculties(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "facultyList";
    }
}

