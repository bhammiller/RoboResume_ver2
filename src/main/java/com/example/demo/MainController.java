package com.example.demo;

import com.example.demo.Classes.*;
import com.example.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExpRepository expRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    WholeResumeRepository wholeResumeRepository;


    //Startpoint
    @GetMapping("/")
    public String startResumeBuilder(Model model){
        model.addAttribute("addwhole", new WholeResume());
        return "resumebuilder";
    }

    @PostMapping("/process")
    public String processBegin(@Valid @ModelAttribute("addwhole") WholeResume wholeResume, BindingResult result){
        if (result.hasErrors()){
            return "resumebuilder";
        }
        wholeResumeRepository.save(wholeResume);
        return "redirect:/addeducation";
    }

    //Education Methods
    @GetMapping("/addeducation")
    public String educationForm(Model model){
        model.addAttribute("addeducation", new EducationResume());
        return "inputeducation";
    }

    @PostMapping("/addeducation")
    public String postedEducation(@Valid @ModelAttribute("addeducation") Model model){
        model.addAttribute("addeducation", new EducationResume());
        return "inputeducation";
    }

    @PostMapping("/processeducation")
    public String processEducation(@Valid @ModelAttribute("addeducation") EducationResume educationResume, BindingResult result){
        if (result.hasErrors()){
            return "inputeducation";
        }
        educationRepository.save(educationResume);
        return "redirect:/addexp";
    }

    //Experience Methods
    @GetMapping("/addexp")
    public String expForm(Model model){
        model.addAttribute("addexp", new ExpResume());
        return "inputexp";
    }

    @PostMapping("/addexp")
    public String postedExp(@Valid @ModelAttribute("addexp") Model model){
        model.addAttribute("addexp", new ExpResume());
        return "inputexp";
    }

    @PostMapping("/processexp")
    public String processExp(@Valid @ModelAttribute("addexp") ExpResume expresume, BindingResult result){
        if (result.hasErrors()){
            return "inputexp";
        }
        expRepository.save(expresume);
        return "redirect:/addskills";
    }

    //Skills Methods
    @GetMapping("/addskills")
    public String skillsForm(Model model){
        model.addAttribute("addskill", new SkillsResume());
        return "inputskills";
    }

    @PostMapping("/addskills")
    public String postedSkills(@Valid @ModelAttribute("addskill") Model model){
        model.addAttribute("addskill", new SkillsResume());
        return "inputskills";
    }

    @PostMapping("/processskill")
    public String processSkills(@Valid @ModelAttribute("addskill") SkillsResume skillsResume, BindingResult result){
        if (result.hasErrors()){
            return "inputskills";
        }
        skillRepository.save(skillsResume);
        return "redirect:/complete";
    }

    @RequestMapping("/complete")
    public String listAddresses(Model model1, Model model2, Model model3, Model model4){
        model1.addAttribute("whole", wholeResumeRepository.findAll());
        model2.addAttribute("education", educationRepository.findAll());
        model3.addAttribute("experience", expRepository.findAll());
        model4.addAttribute("skills", skillRepository.findAll());
        return "resumeouput";
    }

}
