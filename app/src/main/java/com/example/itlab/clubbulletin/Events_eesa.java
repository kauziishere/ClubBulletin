package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Events_eesa extends AppCompatActivity {

    ViewPager viewPager;
    Button b1;
    static  int i = 1;
    public static TextView t1, t2, t3, t4 ;
    ListView list;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_eesa);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ArrayAdapter adapter_2 = new ArrayAdapter<String>(this,
                R.layout.activity_events_eesa);
        b1 = (Button)findViewById(R.id.update_eesa) ;
        useer_prn prn = new useer_prn();
        if(!prn.check_eesa()){
            b1.setVisibility(View.GONE);
        }
        //viewPager = (ViewPager)findViewById(R.id.view_pager);
      //  adapter = new CustomSwipeAdapter8(this);
//        list.setAdapter(adapter_2);

        //viewPager.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        t1 = (TextView)findViewById(R.id.eesa_event_1);

        fetch_event_acses event = new fetch_event_acses();
        event.execute("eesa");
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }

    public void update_eesa_event(View v) {
        startActivity(new Intent(this, Event_update_eesa.class));
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Events_eesa Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    public void setEvent1(String name, String date_from, String date_to){
        if(i==1) {
            t1.setText("Name of the Event: " + name + "\nDate from: " + date_from + "\nDate to: " + date_to);
        }
        else {
            Log.e(t1.getText().toString(),"name");
            t1.setText(t1.getText() + "\n\nName of the Event: " + name + "\nDate from: " + date_from + "\nDate to: " + date_to);
        }
        i++;
    }
    /*
    public void setEvent2(String name, String date_from, String date_to){
        Log.e("Whatever", name);
        t2.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }
    public void setEvent3(String name, String date_from, String date_to){
        t3.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }
    public void setEvent4(String name, String date_from, String date_to){
        t4.setText("Name of the Event: " + name +"\nDate from: " + date_from + "\nDate to: " + date_to);
    }*/
}
