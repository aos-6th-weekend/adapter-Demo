package com.example.rathana.adapter_demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rathana.adapter_demo.adapter.AmsAdapter;
import com.example.rathana.adapter_demo.data.Database;
import com.example.rathana.adapter_demo.model.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AmsActivity extends AppCompatActivity
implements AmsAdapter.AmsCallback {

    static final int ADD_AMS_CODE=2;
    RecyclerView rv;
    AmsAdapter amsAdapter;
    List<Article> articles=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ams);

        initUI();
        getArticles();

    }

    private void initUI() {
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        amsAdapter=new AmsAdapter(this,articles);
        rv.setAdapter(amsAdapter);
    }

    private void getArticles() {

        this.articles.addAll(Database.getInstance().getArticleRepository().getArticles());
        amsAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
        case R.id.addNewAms:
            startActivityForResult(new Intent(this,AddAmsActivity.class),ADD_AMS_CODE);
            return true;
        default: return  false;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== ADD_AMS_CODE && resultCode==RESULT_OK){
            Article article=data.getParcelableExtra("data");
            amsAdapter.setArticle(article);
            rvScroll(0);
        }
    }

    //Ams Adapter callback
    @Override
    public void onDeleteListener(Article article, int position) {
        amsAdapter.removeArticle(article,position);
    }

    private void rvScroll(int pos){
        rv.smoothScrollToPosition(pos);
    }
}









