package com.example.assignment1take2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.commonsware.cwac.merge.MergeAdapter;

import java.util.ArrayList;

public class LunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        //get lunchArray from the Intent
        ArrayList<ArrayList<String>> lunchArray = new ArrayList<ArrayList<String>>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        lunchArray = (ArrayList) bundle.getSerializable("lunch");

        System.out.println(lunchArray);

        //get ListView of Lunch Activity and attach an adapter to it

        ListView items = (ListView) findViewById(R.id.listView_lunch);
        MergeAdapter myAdapter = new MergeAdapter();

        for (int i = 0; i<lunchArray.size(); i++) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lunchArray.get(i));
            myAdapter.addAdapter(adapter);
        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, breakfastArray.get(0));
        items.setAdapter(myAdapter);
    }
}
