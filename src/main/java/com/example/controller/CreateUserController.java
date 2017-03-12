package com.example.controller;

import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by DEK on 12/03/2017.
 */

@Controller
@RequestMapping("/new")
public class CreateUserController {

    @RequestMapping
    public ModelAndView get(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/loginTemplate");
        mv.addObject("page","newUser");
        mv.addObject("user",new User());
        return mv;
    }

    @PostMapping
    public String post(@ModelAttribute @Valid User user){
        String[] password = user.getPassword().split(",");
        boolean valid = password[0].equals(password[1]);
        if(valid){
            user.setPassword(password[0]);
        }
        return null;
    }
}
