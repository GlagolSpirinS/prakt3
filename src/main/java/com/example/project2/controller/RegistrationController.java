package com.example.project2.controller;

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

import com.example.project2.model.UserModel;
import com.example.project2.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration"; //  "registration.html" -  Имя файла представления для формы регистрации
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "login"; //  "login.html" -  Имя файла представления для страницы входа
    }


    @PostMapping
    public String registerUser(@Valid @ModelAttribute("userModel") UserModel userModel,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "registration"; //  Вернуть представление формы регистрации с ошибками
        }

        try {
            userService.createUser(userModel);
            redirectAttributes.addFlashAttribute("successMessage", "Регистрация прошла успешно!");
            return "redirect:/login"; //  Redirect to the new login page
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ошибка при регистрации: " + e.getMessage());
            return "redirect:/registration"; //  Перенаправить пользователя обратно на страницу регистрации с ошибкой
        }
    }
}