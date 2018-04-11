package com.example.itlab.clubbulletin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ACSES extends AppCompatActivity {
    TextView tv1, tv2,tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acses);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.acses,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_acses = (RelativeLayout) findViewById(R.id.main_acses);
        if(item.getItemId()==android.R.id.home)
            finish();
        switch (item.getItemId()) {
            case R.id.menu_events:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i = new Intent(this, Events_acses.class);
                startActivity(i);
                return true;

            case R.id.menu_clubservice:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i1 = new Intent(this, Clubservice_acses.class);
                startActivity(i1);
                return true;

            case R.id.menu_abtus:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i2 = new Intent(this, Aboutus_acses.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void acses_event(View v){
        startActivity(new Intent(this, Events_acses.class));
    }
    public void acses_cs(View v){
        startActivity(new Intent(this, Clubservice_acses.class));
    }
    public void acses_au(View v){
        startActivity(new Intent(this, Aboutus_acses.class));
    }
}
