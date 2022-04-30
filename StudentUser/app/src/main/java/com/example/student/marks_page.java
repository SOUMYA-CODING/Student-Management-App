package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class marks_page extends AppCompatActivity {
    TextView value_mark, view_simple;
    Button btn_view_mark, btn_rn;
    EditText value_rn;
    Spinner spinner;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_page);

        //declearation
        value_rn = findViewById(R.id.roll_number);
        btn_rn = findViewById(R.id.submit_rn);

        value_mark = findViewById(R.id.view_total_mark);

        btn_view_mark = findViewById(R.id.view_mark);

        spinner = findViewById(R.id.semester);

        view_simple = findViewById(R.id.simple_view);

        //set visible = gone
        view_simple.setVisibility(View.GONE);
        value_mark.setVisibility(View.GONE);
        btn_view_mark.setVisibility(View.GONE);

    }

    //show_data
    public void show_data(View v) {

        //get branch
        String a = getIntent().getStringExtra("department1");

        //get roll number
        String b = value_rn.getText().toString().trim();

        //get spinner
        String c = spinner.getSelectedItem().toString().trim();

        //validation
        if (TextUtils.isEmpty(b)) {
            value_rn.setError("Field can't be empty");
        } else {

            Toast.makeText(this, "Loading................", Toast.LENGTH_SHORT).show();

            assert a != null;
            rootNode = FirebaseDatabase.getInstance();

            switch (c) {
                case "1st Semester":
                    reference = rootNode.getReference(a).child(b).child("first_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String d = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(d);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case "2nd Semester":
                    reference = rootNode.getReference(a).child(b).child("second_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String e = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(e);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case "3rd Semester":
                    reference = rootNode.getReference(a).child(b).child("third_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String f = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(f);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case "4th Semester":
                    reference = rootNode.getReference(a).child(b).child("fourth_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String g = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(g);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case "5th Semester":
                    reference = rootNode.getReference(a).child(b).child("fifth_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String h = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(h);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case "6th Semester":
                    reference = rootNode.getReference(a).child(b).child("sixth_semester");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                //get the value
                                String i = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();
                                value_mark.setText(i);

                                view_simple.setVisibility(View.VISIBLE);
                                value_mark.setVisibility(View.VISIBLE);
                                btn_view_mark.setVisibility(View.VISIBLE);

                            } else {
                                Toast.makeText(marks_page.this, "Not Found", Toast.LENGTH_SHORT).show();

                                //set visible
                                view_simple.setVisibility(View.GONE);
                                value_mark.setVisibility(View.GONE);
                                btn_view_mark.setVisibility(View.GONE);

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

        }
    }//end show_data

    //show_mark
    public void show_mark(View view) {

        //get branch
        String a = getIntent().getStringExtra("department1");

        //get roll number
        String b = value_rn.getText().toString().trim();

        //get spinner
        String c = spinner.getSelectedItem().toString().trim();

        assert a != null;
        rootNode = FirebaseDatabase.getInstance();

        switch (c) {
            case "1st Semester":
                reference = rootNode.getReference(a).child(b).child("first_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;

            case "2nd Semester":
                reference = rootNode.getReference(a).child(b).child("second_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;

            case "3rd Semester":
                reference = rootNode.getReference(a).child(b).child("third_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;

            case "4th Semester":
                reference = rootNode.getReference(a).child(b).child("fourth_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "5th Semester":
                reference = rootNode.getReference(a).child(b).child("fifth_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case "6th Semester":
                reference = rootNode.getReference(a).child(b).child("sixth_semester");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //get the value
                        String aa = Objects.requireNonNull(dataSnapshot.child("subject1").getValue()).toString().trim();
                        String bb = Objects.requireNonNull(dataSnapshot.child("subject2").getValue()).toString().trim();
                        String cc = Objects.requireNonNull(dataSnapshot.child("subject3").getValue()).toString().trim();
                        String dd = Objects.requireNonNull(dataSnapshot.child("subject4").getValue()).toString().trim();
                        String ee = Objects.requireNonNull(dataSnapshot.child("subject5").getValue()).toString().trim();
                        String ff = Objects.requireNonNull(dataSnapshot.child("internal1").getValue()).toString().trim();
                        String gg = Objects.requireNonNull(dataSnapshot.child("internal2").getValue()).toString().trim();
                        String hh = Objects.requireNonNull(dataSnapshot.child("internal3").getValue()).toString().trim();
                        String ii = Objects.requireNonNull(dataSnapshot.child("internal4").getValue()).toString().trim();
                        String jj = Objects.requireNonNull(dataSnapshot.child("internal5").getValue()).toString().trim();
                        String kk = Objects.requireNonNull(dataSnapshot.child("project1").getValue()).toString().trim();
                        String ll = Objects.requireNonNull(dataSnapshot.child("project2").getValue()).toString().trim();
                        String mm = Objects.requireNonNull(dataSnapshot.child("project3").getValue()).toString().trim();
                        String nn = Objects.requireNonNull(dataSnapshot.child("sessional").getValue()).toString().trim();
                        String oo = Objects.requireNonNull(dataSnapshot.child("total_mark").getValue()).toString().trim();

                        Intent intent = new Intent(marks_page.this, details_mark_page.class);

                        //send value
                        intent.putExtra("subject1", aa);
                        intent.putExtra("subject2", bb);
                        intent.putExtra("subject3", cc);
                        intent.putExtra("subject4", dd);
                        intent.putExtra("subject5", ee);
                        intent.putExtra("internal1", ff);
                        intent.putExtra("internal2", gg);
                        intent.putExtra("internal3", hh);
                        intent.putExtra("internal4", ii);
                        intent.putExtra("internal5", jj);
                        intent.putExtra("project1", kk);
                        intent.putExtra("project2", ll);
                        intent.putExtra("project3", mm);
                        intent.putExtra("sessional", nn);
                        intent.putExtra("total_mark", oo);

                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
        }


    }//end show_mark
}
