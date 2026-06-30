package com.sahil.personalblog.controllers;

import com.sahil.personalblog.models.Article;
import com.sahil.personalblog.services.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class GuestArticleController
{
    private final ArticleService articleService;


    public GuestArticleController(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String homePage(Model model)
    {
        List<Article> articleList = articleService.getAllArticles();
        model.addAttribute("articles", articleList);

        return "guest/home";
    }

    @GetMapping("/article/{id}")
    public String articlePage(@PathVariable int id, Model model)
    {
        Article article =  articleService.getArticle(id);
        model.addAttribute("article", article);

        return "guest/article";
    }
}
