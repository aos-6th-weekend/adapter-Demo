package com.example.rathana.adapter_demo;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rathana.adapter_demo.adapter.AmsAdapter;
import com.example.rathana.adapter_demo.data.Database;
import com.example.rathana.adapter_demo.model.Article;
import com.paginate.Paginate;
import com.paginate.recycler.LoadingListItemSpanLookup;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AmsActivity extends AppCompatActivity
implements AmsAdapter.AmsCallback {

    static final int ADD_AMS_CODE=2;
    RecyclerView rv;
    AmsAdapter amsAdapter;
    List<Article> articles=new ArrayList<>();


    int currentPage=1;
    boolean isLoading=false;
    int totalPage=10;

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            getArticles();
        }
    };

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


        Paginate.with(rv, callbacks)
                .setLoadingTriggerThreshold(2)
                .addLoadingListItem(true)
                .setLoadingListItemCreator(null)
                .setLoadingListItemSpanSizeLookup(new LoadingListItemSpanLookup(){
                    @Override
                    public int getSpanSize() {
                        return 2;
                    }
                })
                .build();

    }


    private Paginate.Callbacks callbacks=new Paginate.Callbacks() {
        @Override
        public void onLoadMore() {
            isLoading=true;
            //getArticles();
            new Handler().postDelayed(runnable,1500);
        }

        @Override
        public boolean isLoading() {
            return isLoading;
        }

        @Override
        public boolean hasLoadedAllItems() {
            return currentPage==totalPage;
        }
    };

    private void getArticles() {
        currentPage++;
        this.articles.addAll(Database.getInstance().getArticleRepository().getArticles());
        amsAdapter.notifyDataSetChanged();
        isLoading=false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem menuItem= menu.findItem(R.id.search);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                doSearch(s);
                return true;
            }
        });


        return true;
    }

    //search with SearchView
    private void doSearch(String s) {
        if(s.isEmpty()){
            return;
        }

        List<Article> articles=new ArrayList<>();
        articles.clear();
        List<Article> myArticles = Database.getInstance().getArticleRepository().getArticles();
        for(Article article : myArticles){
            if(article.getTitle().matches("(?i)("+s+").*")){
                articles.add(article);
            }
        }

        amsAdapter.reSetArticles(articles);

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









