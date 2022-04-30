package com.example.studentadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_page extends AppCompatActivity {
Button btn_student, btn_department_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        //declearation
        btn_student = findViewById(R.id.student);
        btn_department_menu = findViewById(R.id.department_menu);

    }

    //add_student_activity
    public void add_student_activity(View view)
    {

        Intent intent = new Intent(menu_page.this, student_page.class);
        startActivity(intent);

    }//end add_student_activity

    //department_activity
    public void department_activity(View view1)
    {

        Intent intent1 = new Intent(menu_page.this, department_menu_activity.class);
        startActivity(intent1);

    }//end department_activity

}
