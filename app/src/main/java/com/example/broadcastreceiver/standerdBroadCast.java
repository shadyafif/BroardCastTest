package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class standerdBroadCast {


    Context context;

    public standerdBroadCast(Context context) {
        this.context = context;
    }

    public void RegisterRecevir(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
       context.unregisterReceiver(broadcastReceiver);
    }
}
