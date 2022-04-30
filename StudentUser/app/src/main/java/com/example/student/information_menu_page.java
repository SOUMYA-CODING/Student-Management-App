package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class information_menu_page extends AppCompatActivity {
    Button btn_next;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu_page);

        //declearation
        btn_next = findViewById(R.id.next);
        spinner = findViewById(R.id.branch);

    }

    //next_activity
    public void next_activity(View view) {

        String sp = spinner.getSelectedItem().toString().trim();

        switch (sp) {
            case "CSE":
                String a = "CSE_Students";
                Intent intent = new Intent(information_menu_page.this, information_page.class);
                intent.putExtra("department", a);
                startActivity(intent);
                break;

            case "ETC":
                String b = "ETC_Students";
                Intent intent1 = new Intent(information_menu_page.this, information_page.class);
                intent1.putExtra("department", b);
                startActivity(intent1);
                break;

            case "CIVIL":
                String c = "CIVIL_Students";
                Intent intent2 = new Intent(information_menu_page.this, information_page.class);
                intent2.putExtra("department", c);
                startActivity(intent2);
                break;

            case "ME":
                String d = "ME_Students";
                Intent intent3 = new Intent(information_menu_page.this, information_page.class);
                intent3.putExtra("department", d);
                startActivity(intent3);
                break;

            case "EEE":
                String e = "EEE_Students";
                Intent intent4 = new Intent(information_menu_page.this, information_page.class);
                intent4.putExtra("department", e);
                startActivity(intent4);
                break;

            default:
                Toast.makeText(this, "Select Branch", Toast.LENGTH_SHORT).show();
                break;

        }

    }//end next_activity

}