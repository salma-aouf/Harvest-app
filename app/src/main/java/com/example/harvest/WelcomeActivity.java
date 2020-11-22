package com.example.harvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button SignIn,SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SignIn=(Button)findViewById(R.id.btnSignIn);
        SignUp=(Button)findViewById(R.id.btnSignUp);


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignInPage=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(SignInPage);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUpPage=new Intent(WelcomeActivity.this,RegisterActivity.class);
                startActivity(SignUpPage);
            }
        });
    }
}
