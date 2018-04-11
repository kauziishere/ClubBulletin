package com.example.itlab.clubbulletin;

import android.app.Activity;
import
        android.app.AlertDialog;
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
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by IT lab on 3/24/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    static int value ;
    String user_prn;

    @Override
    protected void onPreExecute()
    {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "https://clubbulletin.000webhostapp.com/register.php";
        String login_url = "https://clubbulletin.000webhostapp.com/login.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String name = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            String user_email = params[4];
            String user_prn = params[5];
            try
            {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                if(name.isEmpty() || user_name.isEmpty() || user_pass.isEmpty() || user_email.isEmpty() || user_prn.isEmpty()){

                    return "Regis Failed";
                }
                else {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                            URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                            URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8") + "&" +
                            URLEncoder.encode("user_email", "UTF-8") + "=" + URLEncoder.encode(user_email, "UTF-8") + "&" +
                            URLEncoder.encode("user_prn", "UTF-8") + "=" + URLEncoder.encode(user_prn, "UTF-8") +"&" +
                            URLEncoder.encode("privilege", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();
                    Log.e("name", user_name);
                    InputStream IS = httpURLConnection.getInputStream();
                    IS.close();
                    return "Registration Successfull";
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login")) {
            String response = "";
            String login_prn = params[1];
            String login_pass = params[2];
            user_prn = login_prn;
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_prn", "UTF-8") + "=" + URLEncoder.encode(login_prn, "UTF-8") + "&" +
                        URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));


                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;

                }
               /* value = 3;
                if(response.equals("Registration Successfull...")){
                    Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                }
                else{
                    if(response.contains("Success")){
                        Log.e("2","message");
                        value = 2;
                    }
                    else
                    {
                        value = 3;
                        alertDialog.setMessage("Failed Try agian");
                        alertDialog.show();
                    }
                }*/
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e(Integer.toString(value),"ACLAAAAAAAAAA");
        value = 3;
        if(result.equals("Registration Successfull"))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Regis Failed")){
            Toast.makeText(ctx, "Registration Failed, Try Again", Toast.LENGTH_LONG).show();
            value = 1;
            Log.e( Integer.toString(value) ,"failed?");
           // alertDialog.setMessage("No field can be empty");
        }
        else
        {
            if(result.contains("Success")) {
                value = 2;
                alertDialog.setMessage(result);
                alertDialog.show();
                try{
                    Intent i = new Intent(ctx, MainActivity.class);
                    ctx.startActivity(i);
                }catch(Exception e){}
                useer_prn prn = new useer_prn();
                prn.setUser_prn(user_prn);
            }
            else
            {
                value = 3;
                alertDialog.setMessage("Failed Try agian");
                alertDialog.show();
            }
        }
    }

    protected int call(){

        Integer number = value;
        Log.e(Integer.toString(number), Integer.toString(number) + " message");
        return number;
    }
}
