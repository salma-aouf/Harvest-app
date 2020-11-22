package com.example.harvest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Email, Passcode;
    private Button Login;
    private int Counter=2;
    private TextView Register;
    private FirebaseAuth Authenticator;


    private FirebaseAuth.AuthStateListener AuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connects the Username variable to the etUsername in the xml
        Email=(EditText) findViewById(R.id.etUserName);
        Passcode=(EditText) findViewById(R.id.etPassword);
        Login=(Button) findViewById(R.id.btnLogin);
        Register=(TextView) findViewById(R.id.tvRegister);


        Authenticator=FirebaseAuth.getInstance();

//        AuthListener= new FirebaseAuth.AuthStateListener() {
//
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser curr_user=Authenticator.getCurrentUser();
//                if (curr_user!=null){
//                    Toast.makeText(MainActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(MainActivity.this,HomeActivity.class);
//                    startActivity(i);
//                }
//
//                else{
//                    Toast.makeText(MainActivity.this,"Try again",Toast.LENGTH_SHORT).show();
//
//
//                }
//
//
//            }
//        };


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ValidatePassword(Username.getText().toString(),Password.getText().toString());

                String email_used = Email.getText().toString();
                String password_used = Passcode.getText().toString();

                if (email_used.isEmpty()) {
                    Email.setError("Enter email address");
                    Email.requestFocus();

                } else if (password_used.isEmpty()) {
                    Passcode.setError("Enter a password");
                    Passcode.requestFocus();

                }


                else if (!email_used.isEmpty() && !password_used.isEmpty()) {

                    Authenticator.signInWithEmailAndPassword(email_used,password_used).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                String errorMessage=task.getException().getMessage();
                                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                Counter--;
                                if (Counter==0){
                                    Login.setEnabled(false);}

                            }
                            else{
                                sendToHomeActivity();
                            }

                        }
                    });
                }

                else {Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }




            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser CurrentUser=Authenticator.getCurrentUser();
        if (CurrentUser != null) {
            sendToHomeActivity();
        }
    }

    private void sendToHomeActivity() {
        Intent LogIn= new Intent (MainActivity.this,HomeActivity.class);
        startActivity(LogIn);
        finish();
    }


//    private void ValidatePassword(String EnteredUsername, String EnteredPassword){
//        if ((EnteredUsername.equals("1"))&& (EnteredPassword.equals("1"))){
//            Intent intent=new Intent (MainActivity.this, HomeActivity.class);
//            startActivity(intent);
//
//        }
//        else {
//            Counter--;
//            if (Counter==0){
//                Login.setEnabled(false);
//
//            }
//        }
//    }
}
