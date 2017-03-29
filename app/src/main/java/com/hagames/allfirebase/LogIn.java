package com.hagames.allfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.firebase.client.Firebase;

public class LogIn extends AppCompatActivity {

    Button signIn;
    EditText Email,Password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signIn=(Button)findViewById(R.id.sign_in);
        Email= (EditText) findViewById(R.id.email);
        Password= (EditText) findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
    }
    public void SignIn(){
        String email=Email.getText().toString();
        String password=Password.getText().toString();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });
    }
}
