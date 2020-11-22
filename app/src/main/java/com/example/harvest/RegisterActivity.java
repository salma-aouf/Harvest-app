package com.example.harvest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText Email, Passcode;
    private Button Register;
    private FirebaseAuth Authenticator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Authenticator=FirebaseAuth.getInstance();

        // connects the Username variable to the etUsername in the xml
        Email=(EditText) findViewById(R.id.etEmail);
        Passcode=(EditText) findViewById(R.id.etPasscode);
        Register=(Button) findViewById(R.id.btnRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                    Authenticator.createUserWithEmailAndPassword(email_used, password_used).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        //startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                        sendToHomeActivity();
                                    } else {
                                        String errorMessage=task.getException().getMessage();

                                        Toast.makeText(RegisterActivity.this, errorMessage,
                                                Toast.LENGTH_SHORT).show();;
                                    }
                                }
                    });
                }

                else {Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }


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
        Intent LogIn= new Intent (RegisterActivity.this,HomeActivity.class);
        startActivity(LogIn);
        finish();
    }

}
