package com.example.itlab.clubbulletin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.onClick;
import static android.R.attr.start;

public class Register extends AppCompatActivity {

   Button bregister;
    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS,ET_USER_EMAIL,ET_USER_PRN;
    String name,user_name,user_pass,user_email,user_prn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ET_NAME=(EditText)findViewById(R.id.name);
        ET_USER_NAME=(EditText)findViewById(R.id.user_name);
        ET_USER_PASS=(EditText)findViewById(R.id.user_pass);
        ET_USER_EMAIL=(EditText)findViewById(R.id.user_email);
        ET_USER_PRN=(EditText)findViewById(R.id.user_prn);


    }
    public void onClick(View v)
    {
        /*switch(v.getId())
        {
            case R.id.bregister:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }*/
        name = ET_NAME .getText().toString();
        user_name = ET_USER_NAME .getText().toString();
        user_pass = ET_USER_PASS .getText().toString();
        user_email = ET_USER_EMAIL .getText().toString();
        user_prn = ET_USER_PRN .getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_name,user_pass,user_email,user_prn);
        String a = Integer.toString(backgroundTask.call());
        Log.e(a+"a", "messgae");
        if(a.contains("1")){
            Log.e(a+"a", "messgaesasasas");
            startActivity(new Intent(this, Register.class));
        }
        finish();

    }
}
