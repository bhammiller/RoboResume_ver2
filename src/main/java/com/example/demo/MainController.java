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

    @Autowired
    ReferenceRepository referenceRepository;


    // Homepage Methods
    @GetMapping("/")
    public String resumeStarter(){
        return "homepage";
    }


    // Contact Information Methods
    @GetMapping("/contact")
    public String startContact(Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addwhole", new WholeResume());
        return "resumebuilder";
    }

    @PostMapping("/process")
    public String processBegin(@Valid @ModelAttribute("addwhole") WholeResume wholeResume, BindingResult result){
        if (result.hasErrors()){
            return "resumebuilder";
        }
        wholeResumeRepository.save(wholeResume);
        return "redirect:/contact";
    }

    @RequestMapping("/updatecontact/{id}")
    public String updateContact(@PathVariable("id") long id, Model model) {
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addwhole", wholeResumeRepository.findOne(id));
        return "resumebuilder";
    }


    // Education Methods
    @GetMapping("/addeducation")
    public String educationForm(Model model){
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("addeducation", new EducationResume());
        return "inputeducation";
    }

    @PostMapping("/addeducation")
    public String postedEducation(@Valid @ModelAttribute("addeducation") Model model){
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("addeducation", new EducationResume());
        return "inputeducation";
    }

    @PostMapping("/processeducation")
    public String processEducation(@Valid @ModelAttribute("addeducation") EducationResume educationResume, BindingResult result){
        if (result.hasErrors()){
            return "inputeducation";
        }
        educationRepository.save(educationResume);
        return "redirect:/addeducation";
    }

    @RequestMapping("/updateeducation/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("addeducation", educationRepository.findOne(id));
        return "inputeducation";
    }

    @RequestMapping("/deleteeducation/{id}")
    public String delEducation(@PathVariable("id") long id){
        educationRepository.delete(id);
        return "redirect:/addeducation";
    }

    // Experience Methods
    @GetMapping("/addexp")
    public String expForm(Model model){
        model.addAttribute("experience", expRepository.findAll());
        model.addAttribute("addexp", new ExpResume());
        return "inputexp";
    }

    @PostMapping("/addexp")
    public String postedExp(@Valid @ModelAttribute("addexp") Model model){
        model.addAttribute("experience", expRepository.findAll());
        model.addAttribute("addexp", new ExpResume());
        return "inputexp";
    }

    @PostMapping("/processexp")
    public String processExp(@Valid @ModelAttribute("addexp") ExpResume expresume, BindingResult result){
        if (result.hasErrors()){
            return "inputexp";
        }
        expRepository.save(expresume);
        return "redirect:/addexp";
    }

    @RequestMapping("/updateexp/{id}")
    public String updateExp(@PathVariable("id") long id, Model model){
        model.addAttribute("experience", expRepository.findAll());
        model.addAttribute("addexp", expRepository.findOne(id));
        return "inputexp";
    }

    @RequestMapping("/deleteexp/{id}")
    public String delExp(@PathVariable("id") long id){
        expRepository.delete(id);
        return "redirect:/addexp";
    }

    // Skills Methods
    @GetMapping("/addskills")
    public String skillsForm(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("addskill", new SkillsResume());
        return "inputskills";
    }

    @PostMapping("/addskills")
    public String postedSkills(@Valid @ModelAttribute("addskill") Model model){
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("addskill", new SkillsResume());
        return "inputskills";
    }

    @PostMapping("/processskill")
    public String processSkills(@Valid @ModelAttribute("addskill") SkillsResume skillsResume, BindingResult result){
        if (result.hasErrors()){
            return "inputskills";
        }
        skillRepository.save(skillsResume);
        return "redirect:/addskills";
    }

    @RequestMapping("/updateskill/{id}")
    public String updateSkill(@PathVariable("id") long id, Model model){
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("addskills", skillRepository.findOne(id));
        return "addressform";
    }

    @RequestMapping("/deleteskill/{id}")
    public String delSkill(@PathVariable("id") long id){
        skillRepository.delete(id);
        return "redirect:/addskills";
    }

    // References Methods
    @GetMapping("/addreferals")
    public String refForm(Model model){
        model.addAttribute("referes", referenceRepository.findAll());
        model.addAttribute("addreferals", new References());
        return "referalpage";
    }

    @PostMapping("/addreferals")
    public String postedRef(@Valid @ModelAttribute("addreferals") Model model){
        model.addAttribute("referes", referenceRepository.findAll());
        model.addAttribute("addreferals", new References());
        return "referalpage";
    }

    @PostMapping("/processreferals")
    public String processref(@Valid @ModelAttribute("addreferals") References references, BindingResult result){
        if (result.hasErrors()){
            return "referalpage";
        }
        referenceRepository.save(references);
        return "redirect:/addreferals";
    }

    @RequestMapping("/updateref/{id}")
    public String updateRef(@PathVariable("id") long id, Model model){
        model.addAttribute("referes", referenceRepository.findAll());
        model.addAttribute("addreferals", referenceRepository.findOne(id));
        return "referalpage";
    }

    @RequestMapping("/deleteref/{id}")
    public String delRef(@PathVariable("id") long id){
        referenceRepository.delete(id);
        return "redirect:/addreferals";
    }


    // Cover Letter Methods
    @GetMapping("/addcover")
    public String coverForm(Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addcover", new WholeResume());
        return "coverletter";
    }

    @PostMapping("/addcover")
    public String postedCover(@Valid @ModelAttribute("addcover") Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addcover", new WholeResume());
        return "coverletter";
    }

    @PostMapping("/processcover")
    public String processCover(@Valid @ModelAttribute("addcover") WholeResume wholeResume, BindingResult result){
        if (result.hasErrors()){
            return "coverletter";
        }
        wholeResumeRepository.save(wholeResume);
        return "redirect:/addcover";
    }

    @RequestMapping("/updatecover/{id}")
    public String updateCover(@PathVariable("id") long id, Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addcover", wholeResumeRepository.findOne(id));
        return "coverletter";
    }

    @RequestMapping("/deletecover/{id}")
    public String delCover(@PathVariable("id") long id){
        wholeResumeRepository.delete(id);
        return "redirect:/addcover";
    }


    // Summary Methods
    @GetMapping("/addsummary")
    public String summaryForm(Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addsummary", new WholeResume());
        return "summary";
    }

    @PostMapping("/addsummary")
    public String postedSummary(@Valid @ModelAttribute("addskill") Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addsummary", new WholeResume());
        return "summary";
    }

    @PostMapping("/processsummary")
    public String processSummary(@Valid @ModelAttribute("addsummary") WholeResume wholeResume, BindingResult result){
        if (result.hasErrors()){
            return "summary";
        }
        wholeResumeRepository.save(wholeResume);
        return "redirect:/addsummary";
    }

    @RequestMapping("/updatesummary/{id}")
    public String updateSummary(@PathVariable("id") long id, Model model){
        model.addAttribute("whole", wholeResumeRepository.findAll());
        model.addAttribute("addsummary", wholeResumeRepository.findOne(id));
        return "addressform";
    }

    @RequestMapping("/deletesummary/{id}")
    public String delSummary(@PathVariable("id") long id){
        wholeResumeRepository.delete(id);
        return "redirect:/addsummary";
    }


    // Completed Resume
    @RequestMapping("/complete")
    public String listAddresses(Model model1, Model model2, Model model3, Model model4){
        model1.addAttribute("whole", wholeResumeRepository.findAll());
        model2.addAttribute("education", educationRepository.findAll());
        model3.addAttribute("experience", expRepository.findAll());
        model4.addAttribute("skills", skillRepository.findAll());
        return "resumeouput";
    }

}
