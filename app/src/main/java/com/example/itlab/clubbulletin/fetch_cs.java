package com.example.itlab.clubbulletin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itlab.clubbulletin.ACSES;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


class fetch_cs extends AsyncTask<String,Void,String>
{
    String Json_String;
    AlertDialog alertDialog;
    String add_Login_url;
    String json_data;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String title, date, time, room;
    String res;
    blabla t1;
    TextView tv1, tv2,tv3,tv4;
    @Override
    protected void onPreExecute()
    {
        //alertDialog=new AlertDialog.Builder(getApplicationContext()).create();
        //alertDialog.setTitle("Login information...");
        //add_Login_url="https://collegedata.000webhostapp.com/login.php";
        add_Login_url="http://clubbulletin.000webhostapp.com/fetch_cs.php";
    }

    @Override
    protected String doInBackground(String... args) {

        //String unm,pass;
        String club=args[0];
        Log.d("asynctask","backgroundactivity started");
        try
        {
            URL url=new URL(add_Login_url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream= httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

            String data_string = URLEncoder.encode("club","UTF-8")+"="+URLEncoder.encode(club,"UTF-8");

            bufferedWriter.write(data_string);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String response="",line="";

            StringBuilder stringBuilder=new StringBuilder();
            int flg=0;
            while ((Json_String = bufferedReader.readLine())!=null)
            {
                flg=1;
                Log.e("json string",""+Json_String);
                stringBuilder.append(Json_String+"\n");
            }
            Log.d("Json string after loop","json string "+Json_String);
            //if (response.equals("success"))
            if(flg==1)
            {
                /*    Log.d("hello","flg= 1");
                    UserDBHelper userDBHelper=new UserDBHelper(getApplicationContext());
                    SQLiteDatabase db=userDBHelper.getWritableDatabase();
                    try {
                        getApplicationContext().deleteDatabase("User_Login.db");
                        userDBHelper = new UserDBHelper(getApplicationContext());
                        db = userDBHelper.getWritableDatabase();
                    }
                    catch (Exception e)
                    {
                        Log.e("Error","Error in deleting database");
                    }
                    //userDBHelper.onUpgrade(db,0,1);
                    userDBHelper.createLogin(db,unm,pass,);
                    Log.d("IN database ","Login detail "+userDBHelper.getLogin(db));
                    userDBHelper.close();*/
            }
            else
            {
                Log.d("Login","Login failed string = "+response);
                return  "fail";
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            res = stringBuilder.toString().trim();

            json_data = res;
            if (res.equals("fail")) {
                Log.d("Fail", "in onpostexecute");

            }
            else {
                try {
                    jsonObject = new JSONObject(json_data);
                    jsonArray = jsonObject.getJSONArray("login-info");

                    JSONObject jo = jsonArray.getJSONObject(0);
                    Log.d("Login result ", json_data);


                    title = jo.getString("title");
                    date = jo.getString("date");
                    time = jo.getString("time");
                    room = jo.getString("room");
                    Log.e("21", title);

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
            return res;
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.e("doinbackground","Error here>>>>>>");
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String res) {

    }
    protected void work(){

    }
    public String getTitle()  {

        try {
            t1.sleep(500);
        }
        catch (Exception e){}
        return title;
    }

    public String getDate() {

        return date;
    }

    public String getTime() {


        return time;
    }

    public String getRoom()  {


        return room;
    }

    public class blabla extends Thread{
        public void run(){

        }
    }
}
