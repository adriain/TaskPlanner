package com.adrian.taskPlanner;

import com.adrian.taskPlanner.pojos.User;
import com.adrian.taskPlanner.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String hello(Model model){
        User user = userRepository.findById(0).orElse(null);
        model.addAttribute("user", user);
        return "hello";
    }
}
