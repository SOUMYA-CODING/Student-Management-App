package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class mark_menu_page extends AppCompatActivity {
    Button btn_next;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_menu_page);

        //declearation
        btn_next = findViewById(R.id.next);
        spinner = findViewById(R.id.branch);

    }

    //next_activity
    public void next_activity(View view) {

        String sp = spinner.getSelectedItem().toString().trim();

        switch (sp) {
            case "CSE":
                String a = "CSE";
                Intent intent = new Intent(mark_menu_page.this, marks_page.class);
                intent.putExtra("department1", a);
                startActivity(intent);
                break;

            case "ETC":
                String b = "ETC";
                Intent intent1 = new Intent(mark_menu_page.this, marks_page.class);
                intent1.putExtra("department1", b);
                startActivity(intent1);
                break;

            case "CIVIL":
                String c = "CIVIL";
                Intent intent2 = new Intent(mark_menu_page.this, marks_page.class);
                intent2.putExtra("department1", c);
                startActivity(intent2);
                break;

            case "ME":
                String d = "ME";
                Intent intent3 = new Intent(mark_menu_page.this, marks_page.class);
                intent3.putExtra("department1", d);
                startActivity(intent3);
                break;

            case "EEE":
                String e = "EEE";
                Intent intent4 = new Intent(mark_menu_page.this, marks_page.class);
                intent4.putExtra("department1", e);
                startActivity(intent4);
                break;

            default:
                Toast.makeText(this, "Select Branch", Toast.LENGTH_SHORT).show();
                break;

        }

    }//end next_activity

}