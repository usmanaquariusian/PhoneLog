package com.example.usmanahmed.phonelog;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import com.google.gson.Gson;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements BlankFragment2.OnFragmentInteractionListener
{
Intent intent;
    static ArrayList<user> arrayList;
    void call()
    {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Gson gson= new Gson();
        ListView listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<user>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new user("Full Name: "+i, " No#" +i,"Gender"));
        }
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
                String datatosend=gson.toJson(arrayList.get(i));
                intent.putExtra("pop",datatosend);
                onFragmentInteraction(arrayList.get(i).fullname);

                //startActivity(intent);
                //call();

            }
        });

    }

    @Override
    public void onFragmentInteraction(String string) {
        Toast.makeText(this,"fragments clicked and activity worked",Toast.LENGTH_SHORT).show();
        ((TextView) findViewById(R.id.textviewfr2)).setText(string);
    }
}

