package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clubservice_sait extends AppCompatActivity {


    TextView tv1, tv2, tv3, tv4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubservice_sait);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        b1 = (Button)findViewById(R.id.button7) ;
        useer_prn prn = new useer_prn();
        if(!prn.check_sait()){
            b1.setVisibility(View.GONE);
        }
        fetch_cs cs = new fetch_cs();
        cs.execute("sait");
        MyThread t1 = new MyThread();

        tv1 = (TextView) findViewById(R.id.textView35);
        /*tv2 = (TextView) findViewById(R.id.textView36);
        tv3 = (TextView) findViewById(R.id.textView37);
        tv4 = (TextView) findViewById(R.id.textView38);*/
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
    public void Update_cs_sait(View v){
        startActivity(new Intent(this, Sait_update_cs.class));
    }

    public class MyThread extends Thread {

        public void run(){

            System.out.println("MyThread running");
        }
    }
}
