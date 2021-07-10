package com.project.mycamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin_Activity extends AppCompatActivity {
    EditText username, password;
    DBHelper DB;
    Button signin;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        signin = (Button) findViewById(R.id.btnregister);
        signup = (TextView) findViewById(R.id.textView3);
        DB = new DBHelper(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Signin_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(Signin_Activity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), Dashboard_Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Signin_Activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        getSupportActionBar().setTitle("Sign In");
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Signin_Activity.this, "Loging in", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Signin_Activity.this, Dashboard_Activity.class);
                startActivity(intent);
            }
        });

    }
}