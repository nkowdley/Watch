package com.example.kent.myapplication;

import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by Kent on 11/8/2014.
 */
public class PhoneService extends WearableListenerService {

    private static final String HELLO_WORLD_WEAR_PATH = "/hello-world-wear";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        /*
         * Receive the message from wear
         */
        if (messageEvent.getPath().equals(HELLO_WORLD_WEAR_PATH)) {

            Intent mIntent = new Intent(Intent.ACTION_CALL);
            mIntent.setData(Uri.parse("tel:412-818-3855"));
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mIntent);
        }

    }

}