package com.example.usmanahmed.phonelog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Gson gson = new Gson();

        String datatoget = getIntent().getStringExtra("pop");
        user gets = gson.fromJson(datatoget,user.class);

        Toast.makeText(this,gets.no,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,gets.fullname,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,gets.gender,Toast.LENGTH_SHORT).show();
    }
}
