package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by IT lab on 4/14/2017.
 */

public class Activity_call extends AppCompatActivity {
    public Activity_call(){
        startActivity(new Intent(this,MainActivity.class));
    }
}
