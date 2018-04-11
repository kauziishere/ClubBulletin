package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Clubservice_acses extends AppCompatActivity
{

    ViewPager viewPager;
    Button b1, b2;
    TextView tv1;
    private static RadioGroup rg;
    private static RadioButton radiob;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        MyThread t1 = new MyThread();

        t1.start();
        setContentView(R.layout.activity_clubservice_acses);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        viewPager = (ViewPager)findViewById(R.id.view_pager);
       // adapter = new CustomSwipeAdapter1(this);
        //viewPager.setAdapter(adapter);
        b1 = (Button)findViewById(R.id.update_screen_acses);
        useer_prn prn = new useer_prn();
        if(!prn.check_acses()){
            b1.setVisibility(android.view.View.GONE);
        }
        fetch_cs cs = new fetch_cs();
        cs.execute("acses");


        tv1 = (TextView) findViewById(R.id.title_acses);
        int i = 0 ;
       while(i < 2) {
           try {
               t1.sleep(100);
           }
           catch (Exception e){}
           tv1.setText("Title of cs: " + cs.getTitle() + "\nRoom number: "+ cs.getRoom() +"\n" + "Date: " + cs.getDate() +"\n" + "Time: " + cs.getTime());
            i++;
       }
       rg = (RadioGroup)findViewById(R.id.radiogroup);
        rg.clearCheck();
        rg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectid = rg.getCheckedRadioButtonId();
                radiob = (RadioButton)findViewById(selectid);
                if(radiob.getText().equals("Intrested")){
                    useer_prn for_naem = new useer_prn();
                    String a = for_naem.getUser_prn();
                    update_people_list obj = new update_people_list();
                    obj.execute("acses",a);
                }
            }
        }
    );

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void Click(View v){
        startActivity(new Intent(this, Acses_update_cs.class));
    }

    public class MyThread extends Thread {

        public void run(){

            System.out.println("MyThread running");
        }
    }
}

