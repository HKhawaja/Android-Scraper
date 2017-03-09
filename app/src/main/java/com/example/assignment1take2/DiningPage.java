package com.example.assignment1take2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DiningPage extends AppCompatActivity {

    ArrayList<ArrayList<ArrayList<String>>> menus = new ArrayList<ArrayList<ArrayList<String>>>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_page);


        //myValParser.execute("param");

    }

    public void getBreakfast (View v) {
        ParseClass breakfastParser = new ParseClass() {
            @Override
            public void receiveData(Object object) {
                menus = (ArrayList) object;
                ArrayList<ArrayList<String>> breakfast = new ArrayList<ArrayList<String>> ();
                breakfast = menus.get(0);

                Intent intent = new Intent(DiningPage.this,BreakfastActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("breakfast",breakfast);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        breakfastParser.execute();

    }

    public void getLunch (View v) {
        ParseClass lunchParser = new ParseClass() {
            @Override
            public void receiveData(Object object) {
                menus = (ArrayList) object;
                ArrayList<ArrayList<String>> lunch = new ArrayList<ArrayList<String>> ();
                lunch = menus.get(1);

                Intent intent = new Intent(DiningPage.this,LunchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("lunch",lunch);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        lunchParser.execute();
    }

    public void getDinner (View v) {
        ParseClass dinnerParser = new ParseClass() {
            @Override
            public void receiveData(Object object) {
                menus = (ArrayList) object;
                ArrayList<ArrayList<String>> dinner = new ArrayList<ArrayList<String>> ();
                dinner = menus.get(2);

                Intent intent = new Intent(DiningPage.this,DinnerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dinner",dinner);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        dinnerParser.execute();
    }
}
