package com.example.controller;

import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by DEK on 11/03/2017.
 */

@Controller
@RequestMapping
public class LoginController {

    @RequestMapping
    public ModelAndView get(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/loginTemplate");
        mv.addObject("page","login");
        mv.addObject("user",new User());
        return mv;
    }

    @PostMapping
    public String post(@ModelAttribute @Valid User user){
        return null;
    }
}
