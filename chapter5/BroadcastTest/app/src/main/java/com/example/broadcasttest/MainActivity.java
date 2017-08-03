package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    //5.3
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver, intentFilter);
//
//        //5.3.1
////        Button button = (Button) findViewById(R.id.button);
////        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
////                sendBroadcast(intent);
////            }
////        });
//
//        //5.3.2
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
//                sendOrderedBroadcast(intent, null);
//            }
//        });
//    }

    //5.4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);    //获取实例
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);    //发送本地广播
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);    //注册本地广播监听器
    }

    //5.3
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//    }

    //5.4
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //5.2.1
//            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();

//            5.2.1(2)
            ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }

    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
