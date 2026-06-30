package com.sahil.personalblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestArticleController
{
    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }

    @GetMapping("/article/{id}")
    public String articlePage()
    {
        return "article";
    }
}
