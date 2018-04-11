package com.example.itlab.clubbulletin;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Acses_update_cs extends AppCompatActivity {
    EditText title, time, room_no, date;
    String title_1, time_1, room_1, date_1;
    String formattedDate;
    SimpleDateFormat df ;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar c = Calendar.getInstance();
         df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = df.format(c.getTime());
        setContentView(R.layout.activity_acses_update_cs);
        title = (EditText)findViewById(R.id.acses_cs_title);
        room_no = (EditText)findViewById(R.id.acses_cs_room);
        time = (EditText)findViewById(R.id.acses_cs_time);
        date = (EditText)findViewById(R.id.acses_cs_date);
    }
    public void update(View v){

        String name = "acses";
        String title_1 = title.getText().toString();
        String room_1 = room_no.getText().toString();
        String date_1 = date.getText().toString();
        String time_1 = time.getText().toString();

        Cs_update update = new Cs_update(this);
        update.execute("acses ",title_1, date_1, time_1, room_1);

        startActivity(new Intent(this, Clubservice_acses.class));
    }
}
