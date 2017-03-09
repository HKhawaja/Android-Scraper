package com.example.assignment1take2;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Array;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Created by Harith on 02/11/17.
 */

public abstract class ParseClass extends AsyncTask <String, Void, ArrayList<ArrayList<ArrayList<String>>>>  {

//    public AsyncResponse delegate = null;

    @Override
    public ArrayList<ArrayList<ArrayList<String>>> doInBackground (String... params) {

        ArrayList<ArrayList<ArrayList<String>>> total = new ArrayList<ArrayList<ArrayList<String>>>();

        ArrayList<ArrayList<String>> breakfast = new ArrayList<ArrayList<String>> ();
        ArrayList<ArrayList<String>> lunch = new ArrayList<ArrayList<String>>() ;
        ArrayList<ArrayList<String>> dinner = new ArrayList<ArrayList<String>>();

        Document doc = null;

        try {
            doc = Jsoup.connect("https://www.amherst.edu/campuslife/housing-dining/dining/menu").get();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        //get the String that represents class

        String idToSearch = "dining-menu-";

        Calendar date = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = df.format(date.getTime());
        //System.out.println(currentDateString);

        idToSearch += currentDateString;

        //gets all meals for current day

        Elements selected = doc.select("div#" + idToSearch);
        //System.out.println(selected.toString());

        Element select = selected.first();
        String text = select.text();

        //prints all meals for current day
        //System.out.println(text);

        //Here we get the breakfast ArrayLists
        Element totalBreakfast = select.getElementById(""+ idToSearch + "-Breakfast");
        //System.out.println (totalBreakfast.text());

        Element breakfastMenu = totalBreakfast.getElementById("" + idToSearch + "-Breakfast-menu-listing");
        //System.out.println(breakfastMenu.text());

        Elements headers = breakfastMenu.getElementsByClass("dining-course-name");
        //System.out.println (headers.get(1).text());
        Elements paragraphs = breakfastMenu.getElementsByTag("p");

        for (int i = 0; i<headers.size(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(headers.get(i).text());

            String items = paragraphs.get(i).text();

            /*
            StringTokenizer tokenizer = new StringTokenizer(items,";");

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                list.add(token);
            }
            */

            list.add(items);

            //first item of each ArrayList added to List of Arrays is the header
            //each subsequent item is on the menu
            breakfast.add(list);
        }

        total.add(breakfast);
        //System.out.println (breakfast.get(1).toString());

        //begin lunch parsing
        Element totalLunch = select.getElementById("" + idToSearch + "-Lunch");
        Element lunchMenu = select.getElementById("" + idToSearch + "-Lunch-menu-listing");
        headers = lunchMenu.getElementsByClass("dining-course-name");
        paragraphs = lunchMenu.getElementsByTag("p");

        for (int i = 0; i<headers.size(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(headers.get(i).text());

            String items = paragraphs.get(i).text();
//            StringTokenizer tokenizer = new StringTokenizer(items,";");
//
//            while (tokenizer.hasMoreTokens()) {
//                String token = tokenizer.nextToken();
//                list.add(token);
//            }
            list.add(items);
            lunch.add(list);
        }

        total.add(lunch);
        //System.out.println (lunch.get(4));


        //begin dinner parsing
        Element totalDinner = select.getElementById("" + idToSearch + "-Dinner");
        Element dinnerMenu = select.getElementById("" + idToSearch + "-Dinner-menu-listing");
        headers = dinnerMenu.getElementsByClass("dining-course-name");
        paragraphs = dinnerMenu.getElementsByTag("p");

        for (int i = 0; i<headers.size(); i++) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(headers.get(i).text());

            String items = paragraphs.get(i).text();
//            StringTokenizer tokenizer = new StringTokenizer(items, ";");
//
//            while (tokenizer.hasMoreTokens()) {
//                String token = tokenizer.nextToken();
//                list.add(token);
//            }
            list.add(items);
            dinner.add(list);
        }

        total.add(dinner);

        //System.out.println (dinner.get(6));
        //System.out.println (total.get(0));
        return total;

    }

    @Override
    protected void onPostExecute (ArrayList<ArrayList<ArrayList<String>>> result) {
        receiveData (result);
//        delegate.processFinish(result);
    }

    public abstract void receiveData (Object object);

}
