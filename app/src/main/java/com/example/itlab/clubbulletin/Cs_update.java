package com.example.itlab.clubbulletin;

import android.os.AsyncTask;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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

/**
 * Created by IT lab on 17-Apr-17.
 */

public class Cs_update extends AsyncTask<String,Void,String> {

    Context ctx;

    Cs_update(Context ctx)
    {
        this.ctx=ctx;
    }
    protected void onPreExecute()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Update Club service");
    }
    @Override
    protected String doInBackground(String... params) {
        Log.e("aaaaaaa","aaaaaaaawwwww");
        String clubservice_url= "http://clubbulletin.000webhostapp.com/club_services.php";
        try {
            Log.e("aaVVVVVVVVVVVVVVaaaaa","aaaaaaaawwwww");

            String user_club = params[0];
            String user_title = params[1];
            String user_date = params[2];
            String user_time = params[3];
            String user_room = params[4];
            Log.e("aaaaaaa","aaaaaaaawwwRRRRRRRRRRRRww");

            URL url = new URL(clubservice_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            Log.e("aaaaaaa","aaaaaQQQQQQQQQQQQQQQQQQQaaawwwww");

            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            Log.e("bla", "bhosda");
            String data = URLEncoder.encode("club", "UTF-8") + "=" + URLEncoder.encode(user_club, "UTF-8") + "&" +
                    URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(user_title, "UTF-8") + "&" +
                    URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(user_date, "UTF-8") + "&" +
                    URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(user_time, "UTF-8") + "&" +
                    URLEncoder.encode("room", "UTF-8") + "=" + URLEncoder.encode(user_room, "UTF-8");
            Log.e("gand mar", "madar");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            Log.e("name", user_club);
            InputStream IS = httpURLConnection.getInputStream();
            IS.close();
            return "Update successful";
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
        else{
            Toast.makeText(ctx, "Unable to update", Toast.LENGTH_LONG).show();
        }
    }
}
