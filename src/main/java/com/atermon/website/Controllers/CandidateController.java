package com.atermon.website.Controllers;
import com.atermon.website.Models.Job;
import com.atermon.website.Repositories.JobRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CandidateController {
    JobRepo jobsRepo;
    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("title", "Atermon | Candidates");
        List<Job> allJobs = jobsRepo.findAll();
        model.addAttribute("jobs", allJobs);
        return "candidates";
    }
}