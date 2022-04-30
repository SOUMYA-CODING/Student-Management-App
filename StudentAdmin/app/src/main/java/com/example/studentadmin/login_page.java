package com.example.studentadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    EditText value_username, value_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //declearation
        value_username = findViewById(R.id.username);
        value_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.signin);

    }

    //info_activity
    public void info_activity(View view) {

        //store the value in string
        String a = value_username.getText().toString().trim();
        String b = value_password.getText().toString().trim();

        if (TextUtils.isEmpty(a)) {
            value_username.setError("Field can't be empty");
        } else if (TextUtils.isEmpty(b)) {
            value_username.setError("Field can't be empty");
        }
        else
        {
            //set both username and password as null (error)
            value_username.setError(null);
            value_password.setError(null);

            //login or condition
            if(a.equals("smc@2020") && b.equals("smc@2020"))
            {
                Intent intent = new Intent(login_page.this, menu_page.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(this, "Username or Password is incorrect !", Toast.LENGTH_SHORT).show();
            }

        }

    }//end info_activity

}
