package com.hagames.allfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class Database extends AppCompatActivity {

    Button sendtofb;
    EditText value;
    EditText key;
    Firebase mRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databse);
        sendtofb=(Button)findViewById(R.id.sendtofb);
        value=(EditText) findViewById(R.id.value);
        key=(EditText)findViewById(R.id.key);
        mRootRef=new Firebase("https://allfirebase-faffb.firebaseio.com/");
        sendtofb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value=value.getText().toString();
                String Key=key.getText().toString();
                Firebase child=mRootRef.child(Key);
                child.setValue(Value);
            }
        });
    }
}
