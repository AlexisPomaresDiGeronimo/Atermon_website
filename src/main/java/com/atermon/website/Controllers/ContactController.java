package com.atermon.website.Controllers;

import com.atermon.website.Models.ContactSender;
import com.atermon.website.Repositories.ContactRepo;
import com.atermon.website.Services.EmailSenderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private EmailSenderService senderService;
    private ContactRepo contactUsRepo;
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Atermon | Contact Us");
        return "contact";
    }
    @PostMapping("/contact_us")
    public String contact_us(HttpServletRequest request, Model model) {
        model.addAttribute("title", "Atermon | Contact Us");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        Long phone = Long.valueOf((request.getParameter("phone")));
        String message = request.getParameter("message");
        ContactSender newSender = new ContactSender();
        newSender.firstname= firstname;
        newSender.lastname= lastname;
        newSender.email= email;
        newSender.phone= phone;
        newSender.message= message;
        contactUsRepo.save(newSender);
        System.out.printf(String.valueOf(newSender));
        senderService.sendEmail(email);
        return "contact";
    }
}
