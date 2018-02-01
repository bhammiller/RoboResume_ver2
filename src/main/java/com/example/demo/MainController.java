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


    @RequestMapping("/")
    public String listPosts(Model model, Model model2){
        model.addAttribute("exp", expRepository.findAll());
        model2.addAttribute("addskill", new SkillsResume());
        return "resumeouput";
    }

    @GetMapping("/add")
    public String postForm(Model model, Model model2){
        model.addAttribute("addexp", new ExpResume());
        model2.addAttribute("addskill", new SkillsResume());
        return "inputpage";
    }

    @PostMapping("/add")
    public String postedForm(Model model, Model model2){
        model.addAttribute("addexp", new ExpResume());
        model2.addAttribute("addskill", new SkillsResume());
        return "inputpage";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("addexp") ExpResume expresume,
                              @Valid @ModelAttribute("addskill") SkillsResume skillresume, BindingResult result){
        if (result.hasErrors()){
            return "inputpage";
        }
        expRepository.save(expresume);
        skillRepository.save(skillresume);
        return "redirect:/";
    }
/*

    @RequestMapping("/update/{id}")
    public String updateAddress(@PathVariable("id") long id, Model model){
        model.addAttribute("addpost", postRepository.findOne(id));
        return "addpostpage";
    }

    @RequestMapping("/delete/{id}")
    public String delAddress(@PathVariable("id") long id){
        postRepository.delete(id);
        return "redirect:/";
    }
*/

}
