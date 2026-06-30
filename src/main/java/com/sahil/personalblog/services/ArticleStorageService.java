package com.sahil.personalblog.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahil.personalblog.models.Article;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
public class ArticleStorageService
{
    public Article readArticle(int id)
    {

        return null;
    }

    public void writeArticle(Article article)
    {
        File directory = new File("data/articles");
        directory.mkdirs();

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("data/articles/" + article.getId() + ".json");
        try
        {
            mapper.writeValue(file,article);
        }catch (IOException e)
        {
            System.out.println("writeArticle method failed to write data to file: " + e.getMessage());
        }
    }

    public void deleteArticle(int id)
    {

    }

    public List<Article> readAllArticles()
    {
        // this will loop the readArticle until it has all the articles in a list
        return null;
    }
}
