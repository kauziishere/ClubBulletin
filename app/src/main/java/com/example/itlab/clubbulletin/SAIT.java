package com.example.itlab.clubbulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;

public class SAIT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sait);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.sait,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_sait = (RelativeLayout) findViewById(R.id.main_sait);
        if(item.getItemId()==android.R.id.home)
            finish();
        switch (item.getItemId()) {
            case R.id.menu_events:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i = new Intent(this, Events_sait.class);
                startActivity(i);
                return true;

            case R.id.menu_clubservice:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i1 = new Intent(this, Clubservice_sait.class);
                startActivity(i1);
                return true;

            case R.id.menu_abtus:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i2 = new Intent(this, Aboutus_sait.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void sait_event(View v){
        startActivity(new Intent(this, Events_sait.class));
    }
    public void sait_cs(View v){
        startActivity(new Intent(this, Clubservice_sait.class));
    }
    public void sait_au(View v){
        startActivity(new Intent(this, Aboutus_sait.class));
    }
}


