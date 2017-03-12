package com.example.controller;

import com.example.entity.Mock;
import com.example.repo.MockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by DEK on 11/03/2017.
 */

@Controller
@RequestMapping("/mock")
public class MainController {

    @Autowired
    MockRepo mockRepo;

    @ResponseBody
    @RequestMapping("/{project}/**")
    public String main(@PathVariable("project") String project, @RequestBody String xmlRequest){
        xmlRequest = xmlRequest.replaceAll("^\\s|\n\\s|\\s$", "");
        List<Mock> mocks = mockRepo.findMockByRequest(xmlRequest);
        if(mocks.size()>0){
            return mocks.get(0).getResponse();
        }
        return null;
    }
}
