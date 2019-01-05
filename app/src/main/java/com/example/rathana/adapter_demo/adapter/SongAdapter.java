package com.example.rathana.adapter_demo.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.adapter_demo.R;
import com.example.rathana.adapter_demo.model.Song;

import java.util.List;

public class SongAdapter extends BaseAdapter {

    List<Song> songs;

    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return this.songs.size();
    }

    @Override
    public Object getItem(int position) {
        return this.songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //inflate layout and bind data to views in layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflate layout

        View view=null;
        if(convertView==null)
            view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.song_item_layout,parent,false);

        else
            view=convertView;

        //bind data to views in layout
        ImageView thumb=view.findViewById(R.id.imageView);
        TextView title=view.findViewById(R.id.title);
        TextView channel=view.findViewById(R.id.channel);
        TextView views= view.findViewById(R.id.views);

        Song song= songs.get(position);
        thumb.setImageResource(song.getThumb());
        title.setText(song.getTitle());
        channel.setText(song.getChannelName());
        views.setText(song.getViews());
        
        return view;
    }
}
