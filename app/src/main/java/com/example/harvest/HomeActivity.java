package com.example.harvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button SignOut;
    private FirebaseAuth Authenticator;

    private FloatingActionButton addPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Authenticator=FirebaseAuth.getInstance();

        SignOut=(Button)findViewById(R.id.Logout);

        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Authenticator.signOut();
                sendToLogin();

            }
        });

        addPost=(FloatingActionButton) findViewById(R.id.btnPost);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GO TO CREATE POST ACTIVITY
            }
        });

    }

    private void sendToLogin() {
        Intent signout=new Intent(HomeActivity.this,WelcomeActivity.class);
        startActivity(signout);
        finish();
    }
}
