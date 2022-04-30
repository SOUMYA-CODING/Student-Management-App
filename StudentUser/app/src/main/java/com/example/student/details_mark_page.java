package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class details_mark_page extends AppCompatActivity {
TextView show_sub1, show_sub2, show_sub3, show_sub4, show_sub5, show_internal1, show_internal2, show_internal3, show_internal4, show_internal5, show_project1, show_project2, show_project3, show_sessional, show_total_mark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_mark_page);

        //declearation
        show_sub1 = findViewById(R.id.sub1);
        show_sub2 = findViewById(R.id.sub2);
        show_sub3 = findViewById(R.id.sub3);
        show_sub4 = findViewById(R.id.sub4);
        show_sub5 = findViewById(R.id.sub5);

        show_internal1 = findViewById(R.id.internal1);
        show_internal2 = findViewById(R.id.internal2);
        show_internal3 = findViewById(R.id.internal3);
        show_internal4 = findViewById(R.id.internal4);
        show_internal5 = findViewById(R.id.internal5);

        show_project1 = findViewById(R.id.project1);
        show_project2 = findViewById(R.id.project2);
        show_project3 = findViewById(R.id.project3);

        show_sessional = findViewById(R.id.sessional);

        show_total_mark = findViewById(R.id.total_mark);

        //call the function
        show_data();

    }

    //show_data
    @SuppressLint("SetTextI18n")
    public void show_data()
    {

        //show the data
        show_sub1.setText(getIntent().getStringExtra("subject1"));
        show_sub2.setText(getIntent().getStringExtra("subject2"));
        show_sub3.setText(getIntent().getStringExtra("subject3"));
        show_sub4.setText(getIntent().getStringExtra("subject4"));
        show_sub5.setText(getIntent().getStringExtra("subject5"));

        show_internal1.setText(getIntent().getStringExtra("internal1")+"A");
        show_internal2.setText(getIntent().getStringExtra("internal2")+"A");
        show_internal3.setText(getIntent().getStringExtra("internal3")+"A");
        show_internal4.setText(getIntent().getStringExtra("internal4")+"A");
        show_internal5.setText(getIntent().getStringExtra("internal5")+"A");

        show_project1.setText(getIntent().getStringExtra("project1"));
        show_project2.setText(getIntent().getStringExtra("project2"));
        show_project3.setText(getIntent().getStringExtra("project3"));

        show_sessional.setText(getIntent().getStringExtra("sessional"));

        show_total_mark.setText(getIntent().getStringExtra("total_mark"));

    }//end show_data

}
