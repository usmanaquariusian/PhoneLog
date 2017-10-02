package com.example.usmanahmed.phonelog;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
Intent intent;
    void call()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayList<user> arrayList = new ArrayList<user>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new user("Full Name: "+i, " No#" +i,"Gender"));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String call = arrayList.get(i).no;
                String uri = "tel:" +call.trim();
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                Toast.makeText(getApplicationContext(),"Calling "+call,Toast.LENGTH_SHORT).show();
                call();
            }
        });

    }
}

