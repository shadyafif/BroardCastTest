package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import static android.content.ContentValues.TAG;



public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final ConnectivityManager cManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cManager != null;
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if (nInfo != null && nInfo.isConnected()) {
            Log.d(TAG, "onReceive: " + "Network good");

        } else {

            Log.d(TAG, "onReceive: " + "Network failed");

        }
    }
}

