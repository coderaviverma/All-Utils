package com.aw.avi.allutilsmethodsapp.fcm;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.MainActivity;

public class BuildNotification {


    private static BuildNotification buildNotification;

    private BuildNotification() {
    }

    public static BuildNotification getInstance() {

        if (buildNotification == null) {
            buildNotification = new BuildNotification();
        }

        return buildNotification;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void buildNotification(Context mContext) {


        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        final String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new
                    NotificationChannel
                    (NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager
                            .IMPORTANCE_MAX);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager
                .TYPE_NOTIFICATION);


        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),
                R.mipmap.ic_launcher);


        Intent intent = null;
        intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (intent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext, /*notification
            id*/1, intent, PendingIntent.FLAG_ONE_SHOT);


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mContext,
                    NOTIFICATION_CHANNEL_ID);

            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setLargeIcon(bitmap)
                    .setSound(defaultSoundUri)
                    .setShowWhen(true)
                    .setWhen(SystemClock.currentThreadTimeMillis())
//                    .setStyle(new Notification.BigPictureStyle().bigPicture(drawbleToBitmap(mContext,R.drawable.ic_rss_feed)))
//                    .setStyle(new NotificationCompat.BigTextStyle().bigText("asbas asasja avsjasvlkasj h"))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setTicker("whatsapp")
                    .setPriority(Notification.PRIORITY_MAX)
                    .setContentTitle("Default")
                    .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
//                    .setContentInfo("Info")
                    .setContentIntent(pendingIntent);

            notificationManager.notify(/*notification id*/1, notificationBuilder.build());

        }

    }

    private Bitmap drawbleToBitmap(Context context, @DrawableRes int res) {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), res);
        return icon;
    }
}
