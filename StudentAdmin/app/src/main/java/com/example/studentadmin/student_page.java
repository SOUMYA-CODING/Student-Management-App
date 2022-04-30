package com.example.studentadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class student_page extends AppCompatActivity {
    EditText value_roll_number, value_reg_number, value_name, value_year, value_address, value_phone_number;
    Button btn_submit;
    Spinner spinner_department;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

        //declearation
        value_roll_number = findViewById(R.id.roll_number);
        value_reg_number = findViewById(R.id.registration_number);
        value_name = findViewById(R.id.name);
        value_year = findViewById(R.id.year);
        value_address = findViewById(R.id.address);
        value_phone_number = findViewById(R.id.phone_number);
        btn_submit = findViewById(R.id.submit);
        spinner_department = findViewById(R.id.department);

        //call the clear_text function
        clear_text();

    }

    //submit_details
    public void submit_details(View view) {

        //store all the value in string
        final String a = value_roll_number.getText().toString().trim();
        String b = value_reg_number.getText().toString().trim();
        String c = value_name.getText().toString().trim();
        String d = value_year.getText().toString().trim();
        String e = value_address.getText().toString().trim();
        String f = value_phone_number.getText().toString().trim();

        String g = spinner_department.getSelectedItem().toString().trim();

        //firebase
        rootNode = FirebaseDatabase.getInstance();
        final Database_helper_student database_helper_student = new Database_helper_student(g, a, b, c, d, e, f);

        //validation
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(c) || TextUtils.isEmpty(d) || TextUtils.isEmpty(e) || TextUtils.isEmpty(f)) {
            value_roll_number.setError("Field can't be empty");
            value_reg_number.setError("Field can't be empty");
            value_name.setError("Field can't be empty");
            value_year.setError("Field can't be empty");
            value_address.setError("Field can't be empty");
            value_phone_number.setError("Field can't be empty");
        } else {

            switch (g) {
                case "CSE":

                    reference = rootNode.getReference("CSE_Students").child(a);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(student_page.this, a + " Already exits.", Toast.LENGTH_SHORT).show();
                            } else {
                                reference = rootNode.getReference("CSE_Students");
                                reference.child(a).setValue(database_helper_student);
                                Toast.makeText(student_page.this, a + " successfully added", Toast.LENGTH_SHORT).show();
                                clear_text();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });

                    break;

                case "ETC":

                    reference = rootNode.getReference("ETC_Students").child(a);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(student_page.this, a + " Already exits.", Toast.LENGTH_SHORT).show();
                            } else {
                                //store the data for ETC
                                reference = rootNode.getReference("ETC_Students");
                                reference.child(a).setValue(database_helper_student);
                                Toast.makeText(student_page.this, a + " successfully added", Toast.LENGTH_SHORT).show();
                                clear_text();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                case "CIVIL":

                    reference = rootNode.getReference("CIVIL_Students").child(a);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(student_page.this, a + " Already exits.", Toast.LENGTH_SHORT).show();
                            } else {
                                //store the data for CIVIL
                                reference = rootNode.getReference("CIVIL_Students");
                                reference.child(a).setValue(database_helper_student);
                                Toast.makeText(student_page.this, a + " successfully added", Toast.LENGTH_SHORT).show();
                                clear_text();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                case "ME":

                    reference = rootNode.getReference("ME_Students").child(a);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(student_page.this, a + " Already exits.", Toast.LENGTH_SHORT).show();
                            } else {
                                //store the data for ME
                                reference = rootNode.getReference("ME_Students");
                                reference.child(a).setValue(database_helper_student);
                                Toast.makeText(student_page.this, a + " successfully added", Toast.LENGTH_SHORT).show();
                                clear_text();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                case "EEE":

                    reference = rootNode.getReference("EEE_Students").child(a);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(student_page.this, a + " Already exits.", Toast.LENGTH_SHORT).show();
                            } else {
                                reference = rootNode.getReference("EEE_Students");
                                reference.child(a).setValue(database_helper_student);
                                Toast.makeText(student_page.this, a + " successfully added", Toast.LENGTH_SHORT).show();
                                clear_text();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

                default:
                    Toast.makeText(this, "Select Branch", Toast.LENGTH_SHORT).show();
                    break;

            }
        }

    }//end submit_details

    //clear_text
    public void clear_text() {

        value_roll_number.setText(null);
        value_reg_number.setText(null);
        value_name.setText(null);
        value_year.setText(null);
        value_address.setText(null);
        value_phone_number.setText(null);
        btn_submit.setText(null);

    }//end clear_text

}
