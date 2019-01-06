package com.example.rathana.adapter_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.adapter_demo.CountryActivity;
import com.example.rathana.adapter_demo.R;
import com.example.rathana.adapter_demo.model.Article;

import java.util.List;

public class AmsAdapter extends RecyclerView.Adapter<AmsAdapter.ViewHolder> {

    List<Article> articles;
    Context mContext;
    public AmsAdapter(Context context,List<Article> articles) {
        this.articles = articles;
        this.mContext=context;
        amsCallback= (AmsCallback) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext)
                .inflate(R.layout.ams_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Article article=articles.get(i);

        if(article.getThumb()!=null){
            Bitmap bitmap= BitmapFactory.decodeFile(article.getThumb());
            viewHolder.thumb.setImageBitmap(bitmap);
        }else
            viewHolder.thumb.setImageResource(R.drawable.tropical_storm);

        viewHolder.title.setText(article.getTitle());
        viewHolder.date.setText(article.getDate());
        viewHolder.author.setText(article.getAuthorName());

        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "you have been favorite this article.", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback
                amsCallback.onDeleteListener(article,viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.articles.size();
    }

    public void setArticle(Article article) {
        this.articles.add(0,article);
        notifyItemInserted(0);
    }

    public void removeArticle(Article article, int position) {
        this.articles.remove(article);
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumb,favorite,btnDelete;
        TextView title,date,author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
            author=itemView.findViewById(R.id.author);
            favorite=itemView.findViewById(R.id.favorite);
            btnDelete=itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext,CountryActivity.class));
                }
            });
        }
    }

    AmsCallback amsCallback;
    public interface AmsCallback{
        void onDeleteListener(Article article,int position);
    }

}
