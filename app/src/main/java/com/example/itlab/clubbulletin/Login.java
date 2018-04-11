package com.example.itlab.clubbulletin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    //Context ctx;
    Button bLogin;
    EditText ET_PRN,ET_PASS;
    String login_prn,login_pass;
    TextView registerlink,forgotpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ET_PRN=(EditText)findViewById(R.id.user_prn);
        ET_PASS=(EditText)findViewById(R.id.user_pass);
        bLogin=(Button)findViewById(R.id.bLogin);
        registerlink=(TextView)findViewById(R.id.registerlink);
        forgotpass=(TextView)findViewById(R.id.forgotpass);

    }
   public void onClick(View v)
    {
        login_prn = ET_PRN.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_prn,login_pass);
        String a = Integer.toString(backgroundTask.call());
        //Log.e(a, a + " message");


       /* android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this.ctx).create();
        alertDialog.setMessage("Procesing");
        */ // timepass(a);
        //Log.e(a, a + " message");
    }
    public void timepass(String a) {
        if (a.contains("2")) {
            Log.d(a, a + "my ame");
            startActivity(new Intent(this, MainActivity.class));
        }
        else {
            startActivity(new Intent(this, Login.class));
        }
    }
    public void register(View v)
    {
        startActivity(new Intent(this,Register.class));

    }


}
