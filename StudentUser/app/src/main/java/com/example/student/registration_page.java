package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class registration_page extends AppCompatActivity {
    Button btn_signup;
    EditText value_roll_number, value_email, value_password, value_confirm_password;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    //password validation syntax
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        //declearation
        btn_signup = findViewById(R.id.signup);

        value_email = findViewById(R.id.email);
        value_password = findViewById(R.id.password);
        value_confirm_password = findViewById(R.id.confirm_password);
        value_roll_number = findViewById(R.id.roll_number);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

        //call the class
        email_validation();
        password_validation();

    }

    //email_validation
    public boolean email_validation() {
        String c = value_email.getText().toString().trim();

        if (TextUtils.isEmpty(c)) {
            value_email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(c).matches()) {
            value_email.setError("Please enter a valid password");
            return false;
        } else {
            value_email.setError(null);
            return true;
        }
    }//end email_validation

    //password_validation
    public boolean password_validation() {
        String d = value_password.getText().toString().trim();
        String e = value_confirm_password.getText().toString().trim();

        if (TextUtils.isEmpty(d)) {
            value_password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(d).matches()) {
            value_password.setError("Password is too weak");
            return false;
        } else if (!d.equals(e)) {
            value_confirm_password.setError("Password does not match");
            return false;
        } else {
            value_password.setError(null);
            value_confirm_password.setError(null);
            return true;
        }
    }//end password_validation

    //new_user_registration
    public void new_user_registration(View v) {

        //validation
        if (!email_validation() | !password_validation()) {

            Toast.makeText(this, "Opps ! Something went wrong", Toast.LENGTH_SHORT).show();

        } else {

            //store in string
            final String f = value_roll_number.getText().toString();
            final String g = value_email.getText().toString();
            final String h = value_confirm_password.getText().toString();

            progressBar.setVisibility(View.VISIBLE);

            //sign in email and passsword also store the data in realtime database
            mAuth.createUserWithEmailAndPassword(g, h).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        DataHelperClass dataHelperClass = new DataHelperClass(f, g);

                        FirebaseDatabase.getInstance().getReference("Registered_Users")
                                .child(f).setValue(dataHelperClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Toast.makeText(registration_page.this, "Registred Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registration_page.this, login_page.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(registration_page.this, "Account already exists !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }//end new_user_registration

}