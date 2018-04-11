package com.example.itlab.clubbulletin;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by kauzi on 13/5/17.
 */

public class update_people_list extends AsyncTask<String,Void,String>{




    @Override
    protected String doInBackground(String... params) {

        String club_url = "http://clubbulletin.000webhostapp.com/people.php";

        try{
            String user_club = params[0];
            String user_prn = params[1];

            URL url = new URL(club_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            Log.e("aaaaaaa","aaaaaQQQQQQQQQQQQQQQQQQQaaawwwww");

            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            Log.e("bla", "bhosda");
            String data = URLEncoder.encode("club", "UTF-8") + "=" + URLEncoder.encode(user_club, "UTF-8") + "&" +
                    URLEncoder.encode("people", "UTF-8") + "=" + URLEncoder.encode(user_prn, "UTF-8");

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

        }
        else{

        }
    }
}
