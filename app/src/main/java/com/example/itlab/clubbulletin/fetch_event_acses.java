package com.example.itlab.clubbulletin;
/**
 * Created by IT lab on 18-Apr-17.
 */

import com.example.itlab.clubbulletin.Events_acses;

import android.app.Activity;
import android.content.Context;
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

import static com.example.itlab.clubbulletin.Events_acses.*;


public class fetch_event_acses extends AsyncTask<String,Void,String>{
    String Json_String;
    AlertDialog alertDialog;
    String add_Login_url;
    String json_data;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String name, date_from, date_to;
    String res;
    TextView t1, t2, t3, t4;
    int count ;
    Events_acses v1;
    Events_cesa v2;
    Events_eesa v3;
    Events_elesa v4;
    Events_mesa v5;
    Events_sait v6;
    String club;

    @Override
    protected void onPreExecute()
    {
        //alertDialog=new AlertDialog.Builder(getApplicationContext()).create();
        //alertDialog.setTitle("Login information...");
        //add_Login_url="https://collegedata.000webhostapp.com/login.php";

        add_Login_url="http://clubbulletin.000webhostapp.com/fetch_event_acses.php";

    }

    @Override
    protected String doInBackground(String... args) {

        //String unm,pass;
        club = args[0];
        Log.e("name of club: ",club);
        Log.d("asynctask","backgroundactivity started");
        try
        {
            URL url=new URL(add_Login_url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
            String data = URLEncoder.encode("club", "UTF-8") + "=" + URLEncoder.encode(club, "UTF-8");
            OutputStream outputStream= httpURLConnection.getOutputStream();

            Log.d("club",club);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            Log.e("name", club);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String response="";

            StringBuilder stringBuilder=new StringBuilder();
            int flg=0;
            Log.e("wokr>","asd");
            while((Json_String = bufferedReader.readLine())!=null)
            {
                flg=1;
                Log.e("json string","" + Json_String);
                stringBuilder.append(Json_String  + "\n");
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

        try {
            i = 0 ;
            v1 = new Events_acses();
            v2 = new Events_cesa();
            v3 = new Events_eesa();
            v4 = new Events_elesa();
            v5 = new Events_mesa();
            v6 = new Events_sait();
            jsonObject = new JSONObject(json_data);
            jsonArray = jsonObject.getJSONArray("login-info");
            Log.d("1231414141", ""+jsonArray.length());
            count = 0;
            while(count <= jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);
                Log.d("Login result ", json_data);


                name = jo.getString("name");
                date_from = jo.getString("date_from");
                date_to = jo.getString("date_to");
                Log.e("21", name);
                if(club.equals("acses")){
                    forAcses();
                }
                else if(club.equals("cesa")){
                    forCesa();
                }
                else if(club.equals("eesa")){
                    forEesa();
                }
                else if(club.equals("elesa")){
                    Log.e("did","this work");
                    forElesa();
                }
                else if(club.equals("mesa")){
                    forMesa();
                }
                else if(club.equals("sait")){
                    forSait();
                }
                count++;
            }
               // else if(i == 2){
            JSONObject jo1 = jsonArray.getJSONObject(1);
            Log.d("Login result ", json_data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void forAcses(){

        //if(count ==0){
            v1.setEvent1(name, date_from, date_to);
        /*}
        else if(count == 1){
            v1.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v1.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v1.setEvent4(name, date_from, date_to);
        }*/
    }
    public void forEesa(){
        //if(count == 0){
            v3.setEvent1(name, date_from, date_to);
        /*}
        else if(count == 1){
            Log.e("name + chicken",name);
            v3.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v3.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v3.setEvent4(name, date_from, date_to);
        }*/
    }

    public void forElesa(){
        //if(count == 0){
            v4.setEvent1(name, date_from, date_to);
        /*}
        else if(count == 1){
            Log.e("name + chicken",name);
            v4.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v4.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v4.setEvent4(name, date_from, date_to);
        }*/
    }
    public void forMesa(){
        //if(count == 0){
            v5.setEvent1(name, date_from, date_to);
        /*}
        else if(count == 1){
            Log.e("name + chicken",name);
            v5.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v5.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v5.setEvent4(name, date_from, date_to);
        }*/
    }

    public void forSait(){
        //if(count == 0){
            v6.setEvent1(name, date_from, date_to);
        /*}
        else if(count == 1){
            Log.e("name + chicken",name);
            v6.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v6.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v6.setEvent4(name, date_from, date_to);
        }*/
    }
    public void forCesa(){
        //if(count == 0){
            v2.setEvent1(name, date_from, date_to);
        //}
        /*
        else if(count == 1){
            Log.e("name + chicken",name);
            v2.setEvent2(name, date_from, date_to);
        }
        else if(count == 2){
            v2.setEvent3(name, date_from, date_to);
        }
        else if(count == 3){
            v2.setEvent4(name, date_from, date_to);
        }*/
    }
}
