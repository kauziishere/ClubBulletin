package com.example.itlab.clubbulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;
public class MESA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mesa,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_mes = (RelativeLayout) findViewById(R.id.main_mes);
        if(item.getItemId()==android.R.id.home)
            finish();
        switch (item.getItemId()) {
            case R.id.menu_events:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i = new Intent(this, Events_mesa.class);
                startActivity(i);
                return true;

            case R.id.menu_clubservice:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i1 = new Intent(this, Clubservice_mesa.class);
                startActivity(i1);
                return true;

            case R.id.menu_abtus:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i2 = new Intent(this, Aboutus_mesa.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void mesa_event(View v){
        startActivity(new Intent(this, Events_mesa.class));
    }
    public void mesa_cs(View v){
        startActivity(new Intent(this, Clubservice_mesa.class));
    }
    public void mesa_au(View v){
        startActivity(new Intent(this, Aboutus_mesa.class));
    }
}


