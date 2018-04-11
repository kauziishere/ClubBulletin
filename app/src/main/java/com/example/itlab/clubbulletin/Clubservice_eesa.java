package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clubservice_eesa extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    ViewPager viewPager;
    Button b1;
    //CustomSwipeAdapter7 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubservice_eesa);

        MyThread t1 = new MyThread();
        t1.start();
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager = (ViewPager)findViewById(R.id.view_pager);
       // adapter = new CustomSwipeAdapter7(this);
        //viewPager.setAdapter(adapter);
        fetch_cs cs = new fetch_cs();
        cs.execute("eesa");
        b1 =(Button)findViewById(R.id.button5);
        useer_prn prn = new useer_prn();
        if(!prn.check_eesa()){
            b1.setVisibility(View.GONE);
        }
        tv1 = (TextView) findViewById(R.id.eesa_cs_title);/*
        tv2 = (TextView) findViewById(R.id.eesa_cs_date);
        tv3 = (TextView) findViewById(R.id.eesa_cs_time);
        tv4 = (TextView) findViewById(R.id.eesa_cs_room);*/
        int i = 0 ;
        while(i < 2) {
            try {
                t1.sleep(1000);
            }
            catch (Exception e){}
            tv1.setText("Title of cs: " + cs.getTitle() + "\nRoom number: "+ cs.getRoom() +"\n" + "Date: " + cs.getDate() +"\n" + "Time: " + cs.getTime());
            i++;
        }
    }
    public void onClick_eesa(View v){startActivity(new Intent(this, Eesa_update_cs.class));}
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    public class MyThread extends Thread {

        public void run(){

            System.out.println("MyThread running");
        }
    }
}

