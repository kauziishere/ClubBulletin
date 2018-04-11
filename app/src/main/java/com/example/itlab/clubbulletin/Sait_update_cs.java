package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sait_update_cs extends AppCompatActivity {
    EditText title, time, room_no, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sait_update_cs);
        title = (EditText)findViewById(R.id.sait_cs_title);
        room_no = (EditText)findViewById(R.id.sait_cs_room);
        time = (EditText)findViewById(R.id.sait_cs_time);
        date = (EditText)findViewById(R.id.sait_cs_date);
    }
    public void onClick_sait(View v){

        String name = "sait";
        String title_1 = title.getText().toString();
        String room_1 = room_no.getText().toString();
        String date_1 = date.getText().toString();
        String time_1 = time.getText().toString();

        Cs_update update = new Cs_update(this);
        update.execute(name ,title_1, date_1, time_1, room_1);

        startActivity(new Intent(this, Clubservice_sait.class));
    }
}
