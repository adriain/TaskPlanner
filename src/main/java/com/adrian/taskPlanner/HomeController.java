package com.adrian.taskPlanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "This is a message from Thymeleaf!");
        return "hello";
    }
}
