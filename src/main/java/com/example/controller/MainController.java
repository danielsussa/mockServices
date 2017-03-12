package com.example.controller;

import com.example.entity.RequestObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEK on 11/03/2017.
 */

@Controller
@RequestMapping("services/**")
public class MainController {

    @ResponseBody
    @RequestMapping
    public String main(HttpServletRequest request,@RequestBody String xmlRequest){
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:bjbs=\"http://schemas.datacontract.org/2004/07/BJBS.CONTRACT.INFRA.Requests\"><soapenv:Header/><soapenv:Body><tem:AutenticarUsuarioResponse><!--Optional:--><tem:AutenticarUsuarioResult><!--Optional:--><bjbs:DataCriacao>2016-12-13T07:51:13</bjbs:DataCriacao><!--Optional:--><bjbs:IdentificacaoUsuarioProprietario>monitor.teste</bjbs:IdentificacaoUsuarioProprietario><!--Optional:--><bjbs:Token>f14898ef-29d0-423f-9936-260c3f2ffb53</bjbs:Token></tem:AutenticarUsuarioResult></tem:AutenticarUsuarioResponse></soapenv:Body></soapenv:Envelope>";
        return xml;
    }
}
