package com.atermon.website.Controllers;

import com.atermon.website.Models.Job;
import com.atermon.website.Repositories.JobRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class JobController {
    JobRepo jobsRepo;
    @GetMapping("/jobs/{id}")
    public String index(@PathVariable("id") long jobId, Model model) {
        model.addAttribute("title", "Atermon | Jobs Details");
        List<Job> allJobs = jobsRepo.findAll();
        model.addAttribute("allJobs", allJobs);
        Job job = jobsRepo.getJobsByJobId(jobId);
        model.addAttribute("jobById", job);
        return "jobs";
    }
}
