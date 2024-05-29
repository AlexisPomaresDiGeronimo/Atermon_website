package com.atermon.website.Controllers;

import com.atermon.website.Models.Candidate;
import com.atermon.website.Models.Job;
import com.atermon.website.Repositories.CandidateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StaffController {
    CandidateRepo candidateRepo;
    @GetMapping("/staff")
    public String staff(Model model) {
        model.addAttribute("title", "Atermon | Staffing Agency");
        List<Candidate> allCandidates = candidateRepo.findAll();
        model.addAttribute("allCandidates", allCandidates);
        return "staff";
    }
}