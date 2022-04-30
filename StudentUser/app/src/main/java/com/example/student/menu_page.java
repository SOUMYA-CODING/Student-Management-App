package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_page extends AppCompatActivity {
Button btn_info, btn_mark, btn_about_app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        //declearation
        btn_info = findViewById(R.id.info_activity);
        btn_mark = findViewById(R.id.mark_activity);
        btn_about_app = findViewById(R.id.about_app_activity);

    }

    //activity_info_page
    public void activity_info_page(View view1)
    {

        Intent intent = new Intent(menu_page.this,information_menu_page.class);
        startActivity(intent);

    }//end activity_info_page

    //activity_mark_page
    public void activity_mark_page(View view1)
    {

        Intent intent1 = new Intent(menu_page.this,mark_menu_page.class);
        startActivity(intent1);

    }//end activity_mark_page

    //activity_app_page
    public void activity_app_page(View view2)
    {

        Intent intent2 = new Intent(menu_page.this,about_page.class);
        startActivity(intent2);

    }//end activity_app_page

}
