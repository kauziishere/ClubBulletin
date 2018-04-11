package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Event_update_elesa extends AppCompatActivity {
    EditText date_from , name , date_to;
    String name_1, from_1, to_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update_elesa);
        date_from = (EditText) findViewById(R.id.elesa_title);
        name = (EditText) findViewById(R.id.elesa_date_from);
        date_to = (EditText) findViewById(R.id.elesa_date_to);
        Log.e("234","work");


        // viewPager = (ViewPager) findViewById(R.id.view_pager);


    }
    public void update_elesa_event_2(View v){
         name_1 = name.getText().toString();
         from_1 = date_from.getText().toString();
         to_1 = date_to.getText().toString();
        Event_update event = new Event_update(this);
        event.execute(name_1, from_1, to_1, "elesa");
        Log.e("elesa",name_1);
        Thread1 t1 = new Thread1();
        try {
            t1.sleep(2000);
        }catch (Exception e){}
        startActivity(new Intent(this, Events_elesa.class));
    }
    public class Thread1 extends Thread{
        public void run(){

        }
    }

}
