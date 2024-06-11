package com.atermon.website.Controllers;

import com.atermon.website.Models.User;
import com.atermon.website.Repositories.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserRepo userRepo;
    @GetMapping("/login")
    public String get_login(Model model) {
        model.addAttribute("title", "Atermon | Login Page");
        return "login";
    }
}
