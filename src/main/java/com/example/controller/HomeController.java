package com.example.controller;

import com.example.entity.Project;
import com.example.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DEK on 12/03/2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProjectRepo projectRepo;

    @RequestMapping
    public ModelAndView get(){
        ModelAndView mv = new ModelAndView("/template");
        mv.addObject("page","mainView");
        mv.addObject("projects",projectRepo.findAll());
        mv.addObject("newProject",new Project());
        return mv;
    }

    @PostMapping
    public String save(@ModelAttribute Project project){
        projectRepo.save(project);
        return "redirect:/";
    }

    @DeleteMapping
    public String delete(@RequestParam(value = "id") Long id) {
        projectRepo.delete(id);
        return "redirect:/";
    }
}
