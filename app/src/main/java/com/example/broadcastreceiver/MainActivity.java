package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;
import static com.example.broadcastreceiver.standerdBroadCast.RegisterRecevir;

public class MainActivity extends AppCompatActivity {


    BroadcastReceiver br;
    IntentFilter filter;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init views
        btn = findViewById(R.id.button);
        br = new NetworkChangeReceiver();
        filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);


        // Go to second activity
        btn.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, SecondActivity.class)));
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Check internet connection
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        this.registerReceiver(br, filter);
        RegisterRecevir(this, br, filter);

    }


    @Override
    protected void onPause() {
        super.onPause();
        // Unregister broad cast receiver to avoid memory leaks
        standerdBroadCast.unregisterReceiver(this, br);
    }
}