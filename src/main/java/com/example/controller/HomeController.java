package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEK on 11/03/2017.
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping
    public String main(HttpServletRequest request){
        return null;
    }
}
