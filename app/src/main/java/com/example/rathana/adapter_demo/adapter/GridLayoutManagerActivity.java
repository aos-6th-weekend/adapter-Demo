package com.example.rathana.adapter_demo.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rathana.adapter_demo.R;
import com.example.rathana.adapter_demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutManagerActivity extends AppCompatActivity {

    RecyclerView gridRV;
    GridAdapter gridAdapter;
    List<Product> products=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_manager);

        setUpUI();
        getProducts();
    }

    private void getProducts() {
        for (int i=0;i<100;i++){
            this.products.add(new Product(i+"",5600d,R.drawable.car));
        }
        gridAdapter.setProducts(this.products);
    }

    private void setUpUI() {
        gridRV=findViewById(R.id.rvGrid);
        gridAdapter=new GridAdapter(products,this);
        gridRV.setLayoutManager(new GridLayoutManager(this,2));
        gridRV.setAdapter(gridAdapter);
    }
}
