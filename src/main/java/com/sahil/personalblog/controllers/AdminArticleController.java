package com.sahil.personalblog.controllers;

import com.sahil.personalblog.models.Article;
import com.sahil.personalblog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminArticleController
{
    private final ArticleService articleService;


    public AdminArticleController(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model)
    {
        List<Article> articleList = articleService.getAllArticles();
        model.addAttribute("articles", articleList);
        return "admin/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editPage(@PathVariable int id, Model model)
    {
        Article article = articleService.getArticle(id);
        model.addAttribute("article", article);

        return "admin/update";
    }

    @PostMapping("/admin/edit/{id}")
    public String editPage(@PathVariable int id, @RequestParam String title, @RequestParam String content)
    {
        articleService.updateArticle(id, title, content);
        return "redirect:/admin";
    }

    @GetMapping("/admin/new")
    public String newPage()
    {
        return"admin/new";
    }

    @PostMapping("/admin/new")
    public String newPage(@RequestParam String title,  @RequestParam String content)
    {
        articleService.createArticle(title, content);
        return"redirect:/admin";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteArticle(@PathVariable int id)
    {
        articleService.deleteArticle(id);
        return "redirect:/admin";
    }
}