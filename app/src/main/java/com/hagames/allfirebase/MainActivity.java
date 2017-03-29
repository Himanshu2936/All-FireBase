package com.hagames.allfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button sendtofb;
    EditText value;
    Firebase mRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendtofb=(Button)findViewById(R.id.sendtofb);
        value=(EditText) findViewById(R.id.value);
        mRootRef=new Firebase("https://allfirebase-faffb.firebaseio.com/");
    }
}
