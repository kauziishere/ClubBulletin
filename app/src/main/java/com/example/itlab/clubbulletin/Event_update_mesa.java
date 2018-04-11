package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Event_update_mesa extends AppCompatActivity {
    EditText name;
    EditText date_from;
    EditText date_to;
    String to_1,from_1,name_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update_mesa);
        Log.e("123","work");
        date_from = (EditText)findViewById(R.id.mesa_date_from);
        name = (EditText)findViewById(R.id.mesa_title);
        date_to = (EditText)findViewById(R.id.mesa_date_to);
        Log.e("234","work");
    }
    public void mesa_event_update(View v){
        name_1 = name.getText().toString();
        from_1 = date_from.getText().toString();
        to_1 = date_to.getText().toString();
        Event_update event = new Event_update(this);
        event.execute(name_1, from_1, to_1, "mesa");
        thread1 t1 = new thread1();
        try {
            t1.sleep(2000);
        }catch (Exception e){}
        startActivity(new Intent(this, Events_mesa.class));
    }
    public class thread1 extends Thread{
        public void run(){

        }
    }
}
