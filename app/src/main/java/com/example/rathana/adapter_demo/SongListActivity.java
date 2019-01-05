package com.example.rathana.adapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.rathana.adapter_demo.adapter.SongAdapter;
import com.example.rathana.adapter_demo.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongListActivity extends AppCompatActivity {

    ListView listView;
    SongAdapter adapter;
    List<Song> songs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        initUI();
        //get songs list
        getSongs();

    }

    private void initUI(){
        listView=findViewById(R.id.listView);
        adapter=new SongAdapter(songs);
        listView.setAdapter(adapter);
    }

    private void getSongs(){
        for(int i=0;i<100;i++){
            this.songs.add(new Song(
                    R.drawable.car,
                    "BMW "+i,
                    "Home car",
                    "1990K"
            ));
        }

        adapter.notifyDataSetChanged();
    }

}
