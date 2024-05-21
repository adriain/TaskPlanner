package com.adrian.taskPlanner.controllers;

import com.adrian.taskPlanner.pojos.MyUserDetails;
import com.adrian.taskPlanner.pojos.SecurityUser;
import com.adrian.taskPlanner.pojos.User;
import com.adrian.taskPlanner.pojos.UserDTO;
import com.adrian.taskPlanner.repositories.SecurityUserRepository;
import com.adrian.taskPlanner.repositories.UserRepository;
import com.adrian.taskPlanner.utilities.error.AlreadyExistingUsername;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    SecurityContextRepository securityContextRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute @Valid UserDTO newUser, BindingResult result, Model model,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        if(result.hasErrors()){
            model.addAttribute("userDTO", newUser);
            return "register";
        }
        try {
            User alreadyExistingUser = userRepository.getUserByUsername(newUser.getUsername());
            if(alreadyExistingUser != null) throw new AlreadyExistingUsername("The username " + newUser.getUsername() + " already exists.");
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            userRepository.save(new User(newUser));
            SecurityUser user = new SecurityUser(newUser);
            securityUserRepository.save(user);
            MyUserDetails userDetails = new MyUserDetails(user);

            SecurityContext context = getSecurityContext(userDetails);

            securityContextRepository.saveContext(context, request, response);
            return "redirect:/";
        }catch (AlreadyExistingUsername e){
            model.addAttribute("userDTO", newUser);
            model.addAttribute("error", "Username already used, please try a different one.");
            return "register";
        }
    }

    private static SecurityContext getSecurityContext(MyUserDetails userDetails) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
                .getContextHolderStrategy();

        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        return context;
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}
