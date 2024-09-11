package com.example.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project2.model.UserModel;
import com.example.project2.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("userModel", new UserModel()); //  Create a new userModel object
        return "login"; //  "login.html" -  Имя файла представления для страницы входа
    }

    @PostMapping
    public String loginUser(@ModelAttribute("userModel") UserModel userModel, Model model) {
        // Implement your login logic here
        UserModel user = userService.findUserByUsernameAndPassword(userModel.getUsername(), userModel.getPassword());

        if (user != null) {
            // User found, set session or redirect to home page
            return "redirect:/"; // Redirect to the main page
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login"; // Return the login page with error message
        }
    }
}