package com.sahil.personalblog.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahil.personalblog.models.Article;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ArticleStorageService
{
    public Article readArticle(int id)
    {
        File file = new File("data/articles/" + id + ".json");

        ObjectMapper mapper = new ObjectMapper();

        try
        {
            return mapper.readValue(file, Article.class);
        }catch (IOException e)
        {
            System.out.println("readArticle was unable to read from file: " + e.getMessage());
            return null;
        }
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
        File file = new File("data/articles/" + id + ".json");

        if (file.delete())
        {
            System.out.println("Article deleted.");
        }
        else
        {
            System.out.println("Article not found or could not be deleted.");
        }
    }

    public List<Article> readAllArticles()
    {
        List<Article> articleList = new ArrayList<>();

        File directory = new File("data/articles");

        File[] files = directory.listFiles();
        ObjectMapper mapper = new ObjectMapper();

        if(files == null)
        {
            return articleList;
        }

        for(File file: files)
        {
            try
            {
                articleList.add(mapper.readValue(file, Article.class));
            }catch (IOException e)
            {
                System.out.println("readAllArticles failed to read articles: " + e.getMessage());
            }
        }
        return articleList;
    }
}
