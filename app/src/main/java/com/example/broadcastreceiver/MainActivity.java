package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Context _mContext;
    BroadcastReceiver br = null;
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        br = new NetworkChangeReceiver();
        filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        _mContext = getApplicationContext();
        _mContext.registerReceiver(br, filter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        br = new NetworkChangeReceiver();
        filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        _mContext = getApplicationContext();
        _mContext.registerReceiver(br, filter);
    }
}