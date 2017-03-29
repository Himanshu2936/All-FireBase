package com.hagames.allfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;
import java.util.TreeMap;

public class Database_Retrieve extends AppCompatActivity {

    Firebase mref;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database__retrieve);
        mref=new Firebase("https://allfirebase-faffb.firebaseio.com/");
        t=(TextView)findViewById(R.id.textView);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(Database_Retrieve.this,"Some ...",Toast.LENGTH_LONG).show();
                TreeMap<String,String> map = dataSnapshot.getValue(TreeMap.class);
                String s;
                s=map.get(map.firstKey());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(Database_Retrieve.this,"Some Problem Occured...",Toast.LENGTH_LONG).show();
            }
        });
    }
}
