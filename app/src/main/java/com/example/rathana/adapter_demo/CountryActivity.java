package com.example.rathana.adapter_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        textView=findViewById(R.id.textView);

        //get data from intent
        if(getIntent()!=null){
            String text= getIntent().getStringExtra("country");
            textView.setText(text);
        }
    }
}
