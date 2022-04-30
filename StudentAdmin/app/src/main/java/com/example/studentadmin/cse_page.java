package com.example.studentadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

public class cse_page extends AppCompatActivity {
    Button btn_calculate, btn_submit;
    EditText value_sub1, value_sub2, value_sub3, value_sub4, value_sub5;
    EditText value_internal1, value_internal2, value_internal3, value_internal4, value_internal5;
    EditText value_pro1, value_pro2, value_pro3;
    EditText value_sessional;
    EditText value_total_mark;
    EditText show_branch, value_name, value_roll_number;
    Spinner spinner_semester;


    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_page);

        //declearation
        btn_calculate = findViewById(R.id.add);
        btn_submit = findViewById(R.id.submit);

        value_sub1 = findViewById(R.id.sub1);
        value_sub2 = findViewById(R.id.sub2);
        value_sub3 = findViewById(R.id.sub3);
        value_sub4 = findViewById(R.id.sub4);
        value_sub5 = findViewById(R.id.sub5);

        value_internal1 = findViewById(R.id.internal1);
        value_internal2 = findViewById(R.id.internal2);
        value_internal3 = findViewById(R.id.internal3);
        value_internal4 = findViewById(R.id.internal4);
        value_internal5 = findViewById(R.id.internal5);

        value_pro1 = findViewById(R.id.pro1);
        value_pro2 = findViewById(R.id.pro2);
        value_pro3 = findViewById(R.id.pro3);

        value_sessional = findViewById(R.id.sessional);
        value_total_mark = findViewById(R.id.total_mark);

        spinner_semester = findViewById(R.id.semester);

        show_branch = findViewById(R.id.branch);
        value_name = findViewById(R.id.name);
        value_roll_number = findViewById(R.id.roll_number);

        //set enable = false
        show_branch.setEnabled(false);
        value_total_mark.setEnabled(false);

        //set branch
        show_branch.setText(getIntent().getStringExtra("department"));

        //call the clear_text function
        clear_text();

    }

    //calculate_mark

    @SuppressLint("SetTextI18n")
    public void calculate_mark(View view) {

        //store the value in string
        int a = Integer.parseInt(value_sub1.getText().toString());
        int b = Integer.parseInt(value_sub2.getText().toString());
        int c = Integer.parseInt(value_sub3.getText().toString());
        int d = Integer.parseInt(value_sub4.getText().toString());
        int e = Integer.parseInt(value_sub5.getText().toString());

        int f = Integer.parseInt(value_internal1.getText().toString());
        int g = Integer.parseInt(value_internal2.getText().toString());
        int h = Integer.parseInt(value_internal3.getText().toString());
        int i = Integer.parseInt(value_internal4.getText().toString());
        int j = Integer.parseInt(value_internal5.getText().toString());

        int k = Integer.parseInt(value_pro1.getText().toString());
        int l = Integer.parseInt(value_pro2.getText().toString());
        int m = Integer.parseInt(value_pro3.getText().toString());

        int n = Integer.parseInt(value_sessional.getText().toString());

        //calculate the marks
        int z = a + b + c + d + e + f + g + h + i + j + k + l + m + n;

        value_total_mark.setText(Integer.toString(z));

    }//end calculate_mark

    //submit_marks
    public void submit_marks(View view1) {

        //get all the data
        final String a = show_branch.getText().toString().trim();
        String b = value_name.getText().toString().trim();
        final String c = value_roll_number.getText().toString().trim();
        final String d = spinner_semester.getSelectedItem().toString().trim();

        String aa = value_sub1.getText().toString().trim();
        String bb = value_sub2.getText().toString().trim();
        String cc = value_sub3.getText().toString().trim();
        String dd = value_sub4.getText().toString().trim();
        String ee = value_sub5.getText().toString().trim();

        String ff = value_internal1.getText().toString().trim();
        String gg = value_internal2.getText().toString().trim();
        String hh = value_internal3.getText().toString().trim();
        String ii = value_internal4.getText().toString().trim();
        String jj = value_internal5.getText().toString().trim();

        String kk = value_pro1.getText().toString().trim();
        String ll = value_pro2.getText().toString().trim();
        String mm = value_pro3.getText().toString().trim();

        String nn = value_sessional.getText().toString().trim();

        String oo = value_total_mark.getText().toString().trim();

        //firebase reference
        rootNode = FirebaseDatabase.getInstance();

        //database helper
        final Database_helper_mark database_helper_mark = new Database_helper_mark(

                a,
                b,
                c,
                d,
                aa,
                ff,
                bb,
                gg,
                cc,
                hh,
                dd,
                ii,
                ee,
                jj,
                kk,
                ll,
                mm,
                nn,
                oo

        );

        //visible to selected semester
        switch (d) {
            case "1st Semester":

                reference = rootNode.getReference(a).child(c).child("first_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 1st Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("first_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            case "2nd Semester":

                reference = rootNode.getReference(a).child(c).child("second_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 2nd Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("second_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            case "3rd Semester":

                reference = rootNode.getReference(a).child(c).child("third_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 3rd Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("third_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            case "4th Semester":

                reference = rootNode.getReference(a).child(c).child("fourth_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 4th Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("fourth_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            case "5th Semester":

                reference = rootNode.getReference(a).child(c).child("fifth_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 5th Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("fifth_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            case "6th Semester":

                //store the data for 6th Semester
                reference = rootNode.getReference(a);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Toast.makeText(cse_page.this, d + " Exists", Toast.LENGTH_SHORT).show();
                        } else {
                            //store the data for 6th Semester
                            reference = rootNode.getReference(a);
                            reference.child(c).child("sixth_semester").setValue(database_helper_mark);
                            Toast.makeText(cse_page.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            clear_text();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;

            default:
                Toast.makeText(this, "Select Semester", Toast.LENGTH_SHORT).show();
                break;

        }

    }//end submit_marks

    //clear_text
    public void clear_text() {

        value_sub1.setText(null);
        value_sub2.setText(null);
        value_sub3.setText(null);
        value_sub4.setText(null);
        value_sub5.setText(null);

        value_internal1.setText(null);
        value_internal2.setText(null);
        value_internal3.setText(null);
        value_internal4.setText(null);
        value_internal5.setText(null);

        value_pro1.setText(null);
        value_pro2.setText(null);
        value_pro3.setText(null);

        value_sessional.setText(null);
        value_total_mark.setText(null);

        value_name.setText(null);
        value_roll_number.setText(null);

    }//end clear_text

}
