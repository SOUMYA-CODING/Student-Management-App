package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class login_page extends AppCompatActivity {
    Button btn_signin, btn_reset_password, btn_signup_activity;
    EditText value_email, value_password;
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
        setContentView(R.layout.activity_login_page);

        //declearation
        btn_signin = findViewById(R.id.signin);
        btn_reset_password = findViewById(R.id.reset_password);
        btn_signup_activity = findViewById(R.id.signup);

        value_email = findViewById(R.id.email);
        value_password = findViewById(R.id.password);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);

        mAuth = FirebaseAuth.getInstance();

        //call the class
        email_validation();
        password_validation();

    }

    //email_validation
    public boolean email_validation() {
        String a = value_email.getText().toString().trim();

        if (TextUtils.isEmpty(a)) {
            value_email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(a).matches()) {
            value_email.setError("Please enter a valid password");
            return false;
        } else {
            value_email.setError(null);
            return true;
        }
    }//end email_validation

    //password_validation
    public boolean password_validation() {
        String b = value_password.getText().toString().trim();

        if (TextUtils.isEmpty(b)) {
            value_password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(b).matches()) {
            value_password.setError("Password is too weak");
            return false;
        } else {
            value_password.setError(null);
            return true;
        }
    }//end password_validation

    //info_activity
    public void info_activity(View view) {

        //call the validation
        if (!email_validation() | !password_validation()) {

            Toast.makeText(this, "Opps ! Something went wrong", Toast.LENGTH_SHORT).show();

        } else {

            //store in string
            String m = value_email.getText().toString().trim();
            String n = value_password.getText().toString().trim();

            progressBar.setVisibility(View.VISIBLE);

            //firebase
            mAuth.signInWithEmailAndPassword(m, n).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(login_page.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_page.this, menu_page.class);
                        startActivity(intent);
                        finish();
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(login_page.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }// end info_activity

    //signup_activity
    public void signup_activity(View view1) {
        Intent intent1 = new Intent(login_page.this, registration_page.class);
        startActivity(intent1);
    }//end signup_activity

    //reset_activity
    public void reset_activity(View v2) {
        EditText mail = new EditText(v2.getContext());
        AlertDialog.Builder pass = new AlertDialog.Builder(v2.getContext());
        pass.setTitle("Password Reset");
        pass.setMessage("Enter your e-mail id to send link");
        pass.setView(mail);

        //yes button
        pass.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m = value_email.getText().toString();
                mAuth.sendPasswordResetEmail(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(login_page.this, "Link has been send to your e-mial id", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login_page.this, "Please enter a valid e-mail id", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //no button
        pass.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        pass.create().show();

    }//end reset_activity

}
