package com.example.controller;

import com.example.entity.Module;
import com.example.entity.Project;
import com.example.repo.ModuleRepo;
import com.example.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEK on 12/03/2017.
 */

@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ModuleRepo moduleRepo;

    @RequestMapping("/{project}")
    public ModelAndView get(@PathVariable("project") Long projectId){
        ModelAndView mv = new ModelAndView("/template");
        mv.addObject("page","projectView");
        mv.addObject("modules",moduleRepo.findModuleByProjectId(projectId));
        mv.addObject("project",projectRepo.findOne(projectId));
        mv.addObject("newModule",new Module());
        return mv;
    }

    @PostMapping("/{project}")
    public String save(@ModelAttribute Module module, HttpServletRequest request){
        moduleRepo.save(module);
        return "redirect:"+request.getRequestURI();
    }

    @DeleteMapping("/{project}")
    public String delete(@RequestParam(value = "id") Long id, HttpServletRequest request) {
        moduleRepo.delete(id);
        return "redirect:"+request.getRequestURI();
    }
}
