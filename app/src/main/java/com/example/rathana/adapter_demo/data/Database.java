package com.example.rathana.adapter_demo.data;

public class Database {

    private Database(){}
    public static Database getInstance(){
        return new Database();
    }


    private static ArticleRepository articleRepository;

    public static ArticleRepository getArticleRepository() {
        if(articleRepository==null)
            articleRepository=new ArticleRepository();

        return articleRepository;
    }
}

