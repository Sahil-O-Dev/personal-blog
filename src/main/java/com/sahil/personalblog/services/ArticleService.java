package com.sahil.personalblog.services;

import com.sahil.personalblog.models.Article;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService
{
    private final ArticleStorageService articleStorageService;

    public ArticleService(ArticleStorageService articleStorageService)
    {
        this.articleStorageService = articleStorageService;
    }

    public void createArticle(String title, String content)
    {
        String publicationDate = LocalDate.now().toString();
        Article article = new Article(title, content);
        article.setId(assignId());
        article.setPublishingDate(publicationDate);

        articleStorageService.writeArticle(article);

    }

    public void updateArticle(int id, String title, String content)
    {

        Article article = getArticle(id);
        if(article == null)
        {
            System.out.println("Article with id " + id + " was not found.");
            return;
        }

        article.setTitle(title);
        article.setContent(content);
        article.setPublishingDate(LocalDate.now().toString());

        articleStorageService.writeArticle(article);
    }

    public void deleteArticle(int id)
    {
        articleStorageService.deleteArticle(id);
    }

    public Article getArticle(int id)
    {

        return articleStorageService.readArticle(id);
    }

    public List<Article> getAllArticles()
    {
        return articleStorageService.readAllArticles();
    }

    private int assignId()
    {
        int id = -1;

        List<Article> articleList = getAllArticles();
        for(Article article: articleList)
        {
            if(article.getId() > id)
            {
                id = article.getId();
            }
        }

        return id + 1;
    }
}