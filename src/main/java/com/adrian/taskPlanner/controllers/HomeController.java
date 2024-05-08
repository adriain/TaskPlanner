package com.adrian.taskPlanner.controllers;

import com.adrian.taskPlanner.pojos.User;
import com.adrian.taskPlanner.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello(Model model){
        User user = userRepository.findById(0).orElse(new User("Empty", "123", LocalDate.now()));
        model.addAttribute("user", user);
        return "hello";
    }
}
