package com.adrian.taskPlanner.controllers;

import com.adrian.taskPlanner.pojos.User;
import com.adrian.taskPlanner.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        return "indexAnonymous";
    }

    @GetMapping("/header")
    public String header(Model model){
        return "header";
    }
}
