package com.websmithing.gpstracker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import java.util.Calendar;

// make sure we use a WakefulBroadcastReceiver so that we acquire a partial wakelock
public class GpsTrackerAlarmReceiver extends WakefulBroadcastReceiver {
    private static final String TAG = "GpsTrackerAlarmReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);
        if(currentHour >= 8 && currentHour < 20)
             context.startService(new Intent(context, LocationService.class));
        else
            Toast.makeText(context,"Time is not between 8AM and 8PM",Toast.LENGTH_SHORT).show();
    }
}
