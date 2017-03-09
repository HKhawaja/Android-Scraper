package com.example.assignment1take2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ArrayList<ArrayList<ArrayList<String>>> menus = new ArrayList<ArrayList<ArrayList<String>>>();
//    ParseClass myValParser = new ParseClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        myValParser.delegate = this;
//        myValParser.execute("param");

        Intent intent = new Intent(MainActivity.this,DiningPage.class);
        startActivity(intent);

    }
//
//    @Override
//    public void processFinish (ArrayList<ArrayList<ArrayList<String>>> menu) {
//        menus = menu;
//        System.out.println (menus.get(0));
//    }
}
