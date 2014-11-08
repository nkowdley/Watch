package com.example.kent.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TempActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, ButtonService.class));
        finish();
    }


    /**
     * Send message to mobile handheld
     */
}
