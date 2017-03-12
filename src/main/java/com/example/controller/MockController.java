package com.example.controller;

import com.example.entity.Mock;
import com.example.entity.Module;
import com.example.repo.MockRepo;
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
public class MockController {

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ModuleRepo moduleRepo;

    @Autowired
    MockRepo mockRepo;

    @RequestMapping("/{project}/{module}")
    public ModelAndView get(@PathVariable("project") Long projectId,@PathVariable("module") Long moduleId){
        ModelAndView mv = new ModelAndView("/template");
        mv.addObject("page","moduleView");
        mv.addObject("mocks",mockRepo.findAll());
        mv.addObject("project",projectRepo.findOne(projectId));
        mv.addObject("module",moduleRepo.findOne(moduleId));
        mv.addObject("newMock",new Mock());
        return mv;
    }

    @PostMapping("/{project}/{module}")
    public String save(@ModelAttribute Mock mock, HttpServletRequest request){
        mock.setRequest(mock.getRequest().replaceAll("^\\s|\n\\s|\\s$", ""));
        mock.setResponse(mock.getResponse().replaceAll("^\\s|\n\\s|\\s$", ""));
        mockRepo.save(mock);
        return "redirect:"+request.getRequestURI();
    }

    @DeleteMapping("/{project}/{module}")
    public String delete(@RequestParam(value = "id") Long id, HttpServletRequest request) {
        mockRepo.delete(id);
        return "redirect:"+request.getRequestURI();
    }
}
