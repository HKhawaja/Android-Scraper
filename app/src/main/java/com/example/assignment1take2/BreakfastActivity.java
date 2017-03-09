package com.example.assignment1take2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.commonsware.cwac.merge.MergeAdapter;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        //get breakfastArray from the Intent
        ArrayList<ArrayList<String>> breakfastArray = new ArrayList<ArrayList<String>>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        breakfastArray = (ArrayList) bundle.getSerializable("breakfast");

        System.out.println(breakfastArray);

        //get ListView of Breakfast Activity and attach an adapter to it

        ListView items = (ListView) findViewById(R.id.listView_breakfast);
        MergeAdapter myAdapter = new MergeAdapter();

        for (int i = 0; i<breakfastArray.size(); i++) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, breakfastArray.get(i));
            myAdapter.addAdapter(adapter);
        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, breakfastArray.get(0));
        items.setAdapter(myAdapter);
    }
}
