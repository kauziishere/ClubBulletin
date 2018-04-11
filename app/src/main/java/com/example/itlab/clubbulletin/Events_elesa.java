package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Events_elesa extends AppCompatActivity {

    ViewPager viewPager;
    //CustomSwipeAdapter11 adapter;
    static  int i = 0;
    public static TextView t1, t2, t3, t4 ;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_elesa);
        fetch_event_acses event = new fetch_event_acses();
        event.execute("elesa");
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        //adapter = new CustomSwipeAdapter11(this);
       // viewPager.setAdapter(adapter);
        b1 = (Button)findViewById(R.id.update_elesa) ;
        useer_prn prn = new useer_prn();
        if(!prn.check_elesa()){
            b1.setVisibility(View.GONE);
        }
        t1 = (TextView)findViewById(R.id.elesa_event_1);
        /*
        t2 = (TextView)findViewById(R.id.elesa_event_2);
        t3 = (TextView)findViewById(R.id.elesa_event_3);
        t4 = (TextView)findViewById(R.id.elesa_event_4);*/

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public void update_elesa_event(View v){
        startActivity(new Intent(this, Event_update_elesa.class));
    }
    public void setEvent1(String name, String date_from, String date_to){
        if(i==1) {
            t1.setText("Name of the Event: " + name + "\nDate from: " + date_from + "\nDate to: " + date_to);
        }
        else {
            Log.e(t1.getText().toString(),"name");
            t1.setText(t1.getText() + "\n\nName of the Event: " + name + "\nDate from: " + date_from + "\nDate to: " + date_to);
        }
        i++;
    }
   /* public void setEvent2(String name, String date_from, String date_to){
        Log.e("Whatever", name);
        t2.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }
    public void setEvent3(String name, String date_from, String date_to){
        t3.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }
    public void setEvent4(String name, String date_from, String date_to){
        t4.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }*/
}
