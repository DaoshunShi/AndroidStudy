package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //5.3.1
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        // TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
//    }

    //5.3.2
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
