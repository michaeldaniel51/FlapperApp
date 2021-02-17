package com.daniel.flapperapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/sign-in")
public class LoginController {

    @GetMapping
  public String signIn(){

        return "sign-in";

    }



}