package com.sahil.personalblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminArticleController
{
    @GetMapping("/admin")
    public String adminPage()
    {
        return "admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editPage(@PathVariable int id)
    {
        return"update";
    }

    @PostMapping("/admin/edit/{id}")
    public String editPage(@PathVariable int id, @RequestParam String title, @RequestParam String content, Model model)
    {
        // incomplete
        return"redirect:/admin";
    }

    @GetMapping("/admin/new")
    public String newPage()
    {
        return"new";
    }

    @PostMapping("/admin/new")
    public String newPage(@RequestParam String title,  @RequestParam String content, Model model)
    {
        // incomplete
        return"redirect:/admin";
    }
    @PostMapping("/admin/delete/{id}")
    public String deleteArticle(@PathVariable int id)
    {
        // Delete article
        return "redirect:/admin";
    }
}
