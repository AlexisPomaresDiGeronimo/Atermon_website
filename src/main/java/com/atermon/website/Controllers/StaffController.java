package com.atermon.website.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class StaffController {
    @GetMapping("/staff")
    public String staff(Model model) {
        model.addAttribute("title", "Atermon | Staffing Agency");
        return "staff";
    }
}