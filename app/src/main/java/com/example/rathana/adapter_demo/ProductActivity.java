
package com.example.rathana.adapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.rathana.adapter_demo.adapter.ProductAdapter;
import com.example.rathana.adapter_demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    GridView gridView;
    ProductAdapter adapter;
    List<Product> products=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initUI();
        getProducts();
    }

    private void initUI(){
        gridView=findViewById(R.id.gridView);
        adapter=new ProductAdapter(products);
        gridView.setAdapter(adapter);
    }

    private void getProducts(){
        for(int i=0;i<100;i++){
            this.products.add(new Product(
                    "Camery 2019 Model "+i,
                    50000d,
                    R.drawable.car
            ));
        }

        adapter.notifyDataSetChanged();
    }
}
