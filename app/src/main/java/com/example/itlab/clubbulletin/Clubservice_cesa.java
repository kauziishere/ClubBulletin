package com.example.itlab.clubbulletin;

import android.content.Intent;

import android.content.Intent;
import android.net.Uri;
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
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.itlab.clubbulletin.R.styleable.View;

public class Clubservice_cesa extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;

    ViewPager viewPager;
    Button b1;
    //CustomSwipeAdapter4 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubservice_cesa);
        fetch_cs cs = new fetch_cs();
        cs.execute("cesa");
        MyThread t1 = new MyThread();
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
       // viewPager = (ViewPager)findViewById(R.id.view_pager);
        b1 = (Button)findViewById(R.id.button4);
        useer_prn prn = new useer_prn();
        if(!prn.check_cesa()){
            b1.setVisibility(android.view.View.GONE);
        }
        tv1 = (TextView) findViewById(R.id.cesa_title);
        /*
        tv2 = (TextView) findViewById(R.id.cesa_date);
        tv3 = (TextView) findViewById(R.id.cesa_time);
        tv4 = (TextView) findViewById(R.id.cesa_room);*/
        int i = 0 ;
        while(i < 3) {
            try {
                t1.sleep(100);
            }
            catch (Exception e){}
            tv1.setText("Title of cs: " + cs.getTitle() + "\nRoom number: "+ cs.getRoom() +"\n" + "Date: " + cs.getDate() +"\n" + "Time: " + cs.getTime());
           /* tv2.setText("Room number: "+ cs.getRoom());
            tv3.setText("Date: " + cs.getDate());
            tv4.setText("Time: " + cs.getTime());*/
            i++;
        }
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClick_cesa(View v){
        startActivity(new Intent(this, Cesa_update_cs.class));
    }
    public class MyThread extends Thread {

        public void run(){

            System.out.println("MyThread running");
        }
    }
}
