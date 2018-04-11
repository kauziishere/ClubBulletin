package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Event_update_cesa extends AppCompatActivity {
    TextView t1, t2, t3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update_cesa);
        t1 = (TextView)findViewById(R.id.cesa_title);
        t2 = (TextView)findViewById(R.id.cesa_date_from);
        t3 = (TextView)findViewById(R.id.cesa_date_to);
    }

    public void Cesa_update(View v){
        String name = t1.getText().toString();
        String date_from =  t2.getText().toString();
        String date_to =  t3.getText().toString();
        Event_update var = new Event_update(this);
        var.execute(name, date_from, date_to, "cesa");
        Event_update_cesa.thread1 t1 = new Event_update_cesa.thread1();
        try {
            t1.sleep(2000);
        }catch (Exception e){}
        startActivity(new Intent(this, Events_cesa.class));
    }
    public class thread1 extends Thread{
        public void run(){

        }
    }
}
