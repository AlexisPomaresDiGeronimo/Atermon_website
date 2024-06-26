package com.atermon.website.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Atermon | Home Page");
        return "index";
    }
}
