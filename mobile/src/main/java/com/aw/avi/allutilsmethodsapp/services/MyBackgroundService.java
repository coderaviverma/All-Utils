package com.aw.avi.allutilsmethodsapp.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.MainActivity;


public class MyBackgroundService extends Service {

    private Context mContext;

    public MyBackgroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    @Override
    public void onCreate() {
        super.onCreate();
        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, "mynotification")
                .setSmallIcon(R.mipmap.notification_icon)
                .setContentTitle("My Background Service")
                .setContentText("Background running...")
                .setContentIntent(pendingIntent).build();

        startForeground(1337, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mContext = this;
        Log.d("WatsonBackgroundService", "Running");


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }
}
