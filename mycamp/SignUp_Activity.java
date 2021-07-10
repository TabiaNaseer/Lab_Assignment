package com.project.mycamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp_Activity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText phone;
    TextView signin;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        phone = (EditText) findViewById(R.id.editTextPhone);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (TextView) findViewById(R.id.textView3);
        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = phone.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(SignUp_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(SignUp_Activity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Signin_Activity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUp_Activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUp_Activity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp_Activity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        getSupportActionBar().setTitle("Signup");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp_Activity.this, "User Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp_Activity.this, Signin_Activity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp_Activity.class);
                startActivity(intent);
            }
        });
    }

}