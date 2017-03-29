package com.hagames.allfirebase;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by honey on 3/14/2017.
 */

public class AllFireBase extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
