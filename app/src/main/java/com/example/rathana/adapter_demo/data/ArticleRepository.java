package com.example.rathana.adapter_demo.data;

import com.example.rathana.adapter_demo.model.Article;
import com.example.rathana.adapter_demo.util.CurrentDateTimeHelper;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    List<Article> articles;

    public ArticleRepository() {
        this.articles = new ArrayList<>();
        for(int i=0;i<10;i++){
            articles.add(new Article(
                    "Tropical storm in Thailand"+ i,
                    CurrentDateTimeHelper.getCurrentDate().toString(),
                    "admin"
            ));
        }
    }

    public List<Article> getArticles() {
        return articles;
    }


}
