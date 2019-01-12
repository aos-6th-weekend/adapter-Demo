package com.example.rathana.adapter_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.adapter_demo.R;
import com.example.rathana.adapter_demo.model.Product;

import java.util.List;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {

    List<Product> products;
    Context context;

    public StaggeredGridAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.staggered_grid_item_layout,viewGroup,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product=products.get(i);
        viewHolder.thumb.setImageResource(product.getThumb());
        viewHolder.price.setText(product.getPrice()+"");
        viewHolder.btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "favourite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public void setProducts(List<Product> products) {
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumb,btnFavourite;
        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            btnFavourite=itemView.findViewById(R.id.favourite);
            price=itemView.findViewById(R.id.price);
        }
    }
}
