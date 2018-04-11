package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

public class Event_update_eesa extends AppCompatActivity {
    EditText date_from , name , date_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update_eesa);
        date_from = (EditText)findViewById(R.id.eesa_title);
        name = (EditText)findViewById(R.id.eesa_date_from);
        date_to = (EditText)findViewById(R.id.eesa_date_to);
        Log.e("234","work");
    }
    public void update_eesa_event_2(View v){
        String name_1 = name.getText().toString();
        String from_1 = date_from.getText().toString();
        String to_1 = date_to.getText().toString();
        Event_update event = new Event_update(this);
        event.execute(name_1, from_1, to_1, "eesa");
        Log.e("eesa",name_1);
        Thread1 t1 = new Thread1();
        try {
            t1.sleep(2000);
        }catch (Exception e){}
        startActivity(new Intent(this, Events_eesa.class));
    }

    public class Thread1 extends Thread{
        public void run(){

        }
    }
}
