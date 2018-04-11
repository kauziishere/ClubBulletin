package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clubservice_mesa extends AppCompatActivity
{

    ViewPager viewPager;
    Button b1;

    TextView tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        MyThread t1 = new MyThread();

        t1.start();
        setContentView(R.layout.activity_clubservice_mesa);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager = (ViewPager)findViewById(R.id.view_pager);
     //   adapter = new CustomSwipeAdapter1(this);
       // viewPager.setAdapter(adapter);
        b1 =(Button)findViewById(R.id.update_screen);
        useer_prn prn = new useer_prn();
        if(!prn.check_mesa()){
            b1.setVisibility(View.GONE);
        }
        fetch_cs cs = new fetch_cs();
        cs.execute("mesa");


        tv1 = (TextView) findViewById(R.id.title_mesa);
        /*
        tv2 = (TextView) findViewById(R.id.textView27);
        tv3 = (TextView) findViewById(R.id.textView10);
        tv4 = (TextView) findViewById(R.id.textView28);*/
        int i = 0 ;
        while(i < 2) {
            try {
                t1.sleep(100);
            }
            catch (Exception e){}
            tv1.setText("Title of cs: " + cs.getTitle() + "\nRoom number: "+ cs.getRoom() +"\n" + "Date: " + cs.getDate() +"\n" + "Time: " + cs.getTime());
            i++;
        }

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void Click(View v){
        startActivity(new Intent(this, Mesa_update_cs.class));
    }

    public class MyThread extends Thread {

        public void run(){

            System.out.println("MyThread running");
        }
    }
}

