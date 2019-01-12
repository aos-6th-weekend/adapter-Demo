package com.example.rathana.adapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.rathana.adapter_demo.adapter.StaggeredGridAdapter;
import com.example.rathana.adapter_demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StaggeredGridAdapter adapter;
    List<Product> products=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);



        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter=new StaggeredGridAdapter(products,this);
        recyclerView.setAdapter(adapter);

        getProducts();
    }

    private void getProducts() {

        for (int i=0;i<30;i++){
            this.products.add(new Product(i+"",5600d,R.drawable.car));
            this.products.add(new Product(i+"",5600d,R.drawable.kongfu_panda_2));
            this.products.add(new Product(i+"",5600d,R.drawable.kung_fu_1));
            this.products.add(new Product(i+"",5600d,R.drawable.kung_fu_panda));
        }
        adapter.setProducts(this.products);
    }
}
