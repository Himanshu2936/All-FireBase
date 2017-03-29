package com.hagames.allfirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.firebase.client.Firebase;

public class LogIn extends AppCompatActivity {

    Button signIn;
    EditText Email,Password;
    FirebaseAuth mAuth;
    ProgressDialog register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        signIn=(Button)findViewById(R.id.sign_in);
        Email= (EditText) findViewById(R.id.email);
        Password= (EditText) findViewById(R.id.password);
        register=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }
    public void SignIn() {
        final String email = Email.getText().toString();
        final String password = Password.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            makeToast("Email or password is empty");
        } else {
            register.setMessage("Registering/Logging in User...");
            register.show();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        register.dismiss();
                        makeToast("Registered Successfully");
                        finish();
                        startActivity(new Intent(LogIn.this,MainActivity.class));
                    }
                    else{
                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    register.dismiss();
                                    makeToast("logged in successfully");
                                    finish();
                                    startActivity(new Intent(LogIn.this,MainActivity.class));
                                }
                                else{
                                    register.dismiss();
                                    makeToast("Something went wrong! Try agian...");
                                }
                            }
                        });
                    }
                }
            });
        }
    }
    void makeToast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
