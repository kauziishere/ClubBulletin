package com.example.itlab.clubbulletin;

/**
 * Created by IT lab on 18-Apr-17.
 */
import android.os.AsyncTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class Event_update extends AsyncTask<String,Void,String>{

    Context ctx;

    public Event_update(Context ctx) {
        this.ctx = ctx;
    }

    protected void onPreExecute()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Update Events");
    }

    @Override
    protected String doInBackground(String... params) {
        String event_url = "";
        String club = params[3];
        event_url = "http://clubbulletin.000webhostapp.com/event_acses.php";

        try {
            Log.e("aaVVVVVVVVVVVVVVaaaaa","aaaaaaaawwwww");

            String name = params[0];
            String date_from = params[1];
            String date_to = params[2];
            Log.e("aaaaaaa","aaaaaaaawwwRRRRRRRRRRRRww");
            if(name.isEmpty() || date_from.isEmpty() || date_to.isEmpty()){return "isEmpty";}
            else {
                URL url = new URL(event_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                Log.e("aaaaaaa", "aaaaaQQQQQQQQQQQQQQQQQQQaaawwwww");

                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                Log.e("bla", "bhosda");
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("date_from", "UTF-8") + "=" + URLEncoder.encode(date_from, "UTF-8") + "&" +
                        URLEncoder.encode("date_to", "UTF-8") + "=" + URLEncoder.encode(date_to, "UTF-8") + "&" +
                        URLEncoder.encode("club", "UTF-8") + "=" + URLEncoder.encode(club, "UTF-8") ;
                Log.e("gand mar", "madar");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                Log.e("name", name);
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Update successful";
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(String result) {
        if(result.equals("Update successful")){
            Toast.makeText(ctx , result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("isEmpty")){
            Toast.makeText(ctx, "None of the fields can be empty", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ctx, "Unable to update", Toast.LENGTH_LONG).show();
        }
    }
}
