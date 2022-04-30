package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class information_page extends AppCompatActivity {
    Button btn_submit;
    EditText value_rn;
    TextView value_roll_number, value_reg_number, value_name, value_branch, value_year, value_address, value_phone_number;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        //declaeration
        btn_submit = findViewById(R.id.submit);

        value_rn = findViewById(R.id.rn);

        value_roll_number = findViewById(R.id.roll_number);
        value_reg_number = findViewById(R.id.reg_number);
        value_name = findViewById(R.id.name);
        value_branch = findViewById(R.id.branch);
        value_year = findViewById(R.id.year);
        value_address = findViewById(R.id.address);
        value_phone_number = findViewById(R.id.phone_number);

    }

    //get_info_data
    public void get_info_data(View view) {

        //get the branch name
        String a = getIntent().getStringExtra("department");
        String b = value_rn.getText().toString().trim();

        //validation
        if (TextUtils.isEmpty(b)) {
            value_rn.setError("Field can't be empty");
        } else {

            Toast.makeText(information_page.this, "Loading................", Toast.LENGTH_SHORT).show();

            rootNode = FirebaseDatabase.getInstance();
            assert a != null;
            reference = rootNode.getReference(a).child(b);
            reference.addValueEventListener(new ValueEventListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists())
                    {
                        //get the value
                        String c = Objects.requireNonNull(dataSnapshot.child("roll_number").getValue()).toString().trim();
                        String d = Objects.requireNonNull(dataSnapshot.child("registration_number").getValue()).toString().trim();
                        String e = Objects.requireNonNull(dataSnapshot.child("name").getValue()).toString().trim();
                        String f = Objects.requireNonNull(dataSnapshot.child("branch").getValue()).toString().trim();
                        String g = Objects.requireNonNull(dataSnapshot.child("year").getValue()).toString().trim();
                        String h = Objects.requireNonNull(dataSnapshot.child("address").getValue()).toString().trim();
                        String i = Objects.requireNonNull(dataSnapshot.child("phone_number").getValue()).toString().trim();

                        //show the value
                        value_roll_number.setText("Roll Number : " + c);
                        value_reg_number.setText("Registration Number : " + d);
                        value_name.setText("Name : " + e);
                        value_branch.setText("Branch : " + f);
                        value_year.setText("Year : " + g);
                        value_address.setText("Address : " + h);
                        value_phone_number.setText("Phone Number : " + i);
                    }
                    else
                    {
                        Toast.makeText(information_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                        //clear the text if exist before
                        value_roll_number.setText("");
                        value_reg_number.setText("");
                        value_name.setText("");
                        value_branch.setText("");
                        value_year.setText("");
                        value_address.setText("");
                        value_phone_number.setText("");

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //Toast.makeText(information_page.this, "Not found", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }//end get_info_data

}
