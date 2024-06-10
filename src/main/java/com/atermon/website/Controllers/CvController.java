package com.atermon.website.Controllers;

import com.atermon.website.Models.Candidate;
import com.atermon.website.Repositories.CandidateRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class CvController {
    CandidateRepo candidatesRepo;

    @GetMapping("/applyCv")
    public String applyCv(Model model) {
        model.addAttribute("title", "Atermon | Apply CV");
        return "applyCv";
    }
    @GetMapping("/downloadCv/{id}")
    public String downloadCv(@PathVariable("id") long candidateId , Model model) {
        model.addAttribute("title", "Atermon | Apply CV");
        Candidate candidates = candidatesRepo.getReferenceById(candidateId);
        System.out.println(candidates);
        return "applyCv";
    }
    @PostMapping("/uploadCv")
    public String uploadCv(HttpServletRequest request) {
        String cv_firstname = request.getParameter("cv_firstname");
        String cv_lastname = request.getParameter("cv_lastname");
        String cv_email = request.getParameter("cv_email");
        Long cv_phone = Long.valueOf(request.getParameter("cv_phone"));
        String cv_location = request.getParameter("cv_location");
        LocalDate cv_birthdate = LocalDate.parse(request.getParameter("cv_birthdate"));
        int cv_yearsOfExperience = Integer.parseInt(request.getParameter("cv_yearsOfExperience"));
        String cv = request.getParameter("cv");
        Candidate newCandidate = new Candidate();
        newCandidate.firstname = cv_firstname;
        newCandidate.lastname = cv_lastname;
        newCandidate.email = cv_email;
        newCandidate.phone = cv_phone;
        newCandidate.location = cv_location;
        newCandidate.birthday = cv_birthdate;
        newCandidate.age = (LocalDate.now().getYear() - cv_birthdate.getYear());
        newCandidate.yearsOfExperience = cv_yearsOfExperience;
        if (!cv.isEmpty()) {
            newCandidate.setCv(cv.getBytes());
        }
        System.out.println(newCandidate);
        candidatesRepo.save(newCandidate);
        return "applyCv";
    }
}

