package com.appproteam.sangha.checkinternet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        if(!checkConnected(context))
            Toast.makeText(context, "Mat ket noi mang!!!!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Ket noi mang!!", Toast.LENGTH_SHORT).show();

    }
    private boolean checkConnected(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected() && networkInfo.isAvailable() && isInternetAvailable())
            return true;
        else return false;

    }
    private boolean isInternetAvailable()
    {
        try
        {
            return (Runtime.getRuntime().exec ("ping -c 1 google.com").waitFor() == 0);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
