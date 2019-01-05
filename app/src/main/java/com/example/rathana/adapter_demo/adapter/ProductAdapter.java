package com.example.rathana.adapter_demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.adapter_demo.R;
import com.example.rathana.adapter_demo.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=null;
        if(convertView==null)
            view=LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_item_layout,parent,false);

        else
            view=convertView;

        ImageView thumb=view.findViewById(R.id.thumb);
        TextView name=view.findViewById(R.id.productName);
        TextView price=view.findViewById(R.id.productPrice);
        //bind data
        Product product=products.get(position);

        thumb.setImageResource(product.getThumb());
        name.setText(product.getName());
        price.setText(product.getPrice()+"");

        return view;
    }
}
