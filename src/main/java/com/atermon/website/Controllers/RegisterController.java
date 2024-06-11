package com.atermon.website.Controllers;

import com.atermon.website.Models.User;
import com.atermon.website.Repositories.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class RegisterController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/register")
    public String get_register(Model model) {
        model.addAttribute("title", "Atermon | Create Account");
        return "register";
    }
    @PostMapping("/registration")
    public String post_register(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cnf_pass = request.getParameter("cnf_password");
        User user = userRepo.getUserByUsername(username);
        if (!password.equals(cnf_pass)) {
            model.addAttribute("msg", "Insert the same password and confirm password!!");
            model.addAttribute("username", username);
            return "register";
        } else if (user != null) {
            if (username.equals(user.getUsername())) {
                model.addAttribute("msg", "This Username already exists!!");
                model.addAttribute("username", username);
            }
            return "register";
        } else {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setRole("ROLE_USER");
            userRepo.save(newUser);
            return "login";
        }
    }
}
