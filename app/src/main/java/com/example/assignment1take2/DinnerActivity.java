package com.example.assignment1take2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.commonsware.cwac.merge.MergeAdapter;

import java.util.ArrayList;

public class DinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        //get breakfastArray from the Intent
        ArrayList<ArrayList<String>> dinnerArray = new ArrayList<ArrayList<String>>();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        dinnerArray = (ArrayList) bundle.getSerializable("dinner");

        System.out.println(dinnerArray);

        //get ListView of Dinner Activity and attach an adapter to it

        ListView items = (ListView) findViewById(R.id.listView_dinner);
        MergeAdapter myAdapter = new MergeAdapter();

        for (int i = 0; i<dinnerArray.size(); i++) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dinnerArray.get(i));
            myAdapter.addAdapter(adapter);
        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, breakfastArray.get(0));
        items.setAdapter(myAdapter);

    }

}
