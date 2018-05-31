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
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by avinash.verma on 8/24/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String IS_UNREAD_MESSAGE = "message";
    private final String TAG = MyFirebaseMessagingService.class.getName();
    String title, message, userId, name, senderId;
    //    NotificationCompat.Builder notificationBuilder;


    private Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("remoteMessage", remoteMessage.toString());
        mContext = this;

        if (mContext != null) {
            // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
            Log.d(TAG, "From: " + remoteMessage.getFrom());

            // Check if message contains a data payload.
            if (remoteMessage.getData().size() > 0) {
                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            }

            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification()
                        .getBody());
            }

            buildNotification();

        }


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void buildNotification() {


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context
                .NOTIFICATION_SERVICE);
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


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);


        Intent intent = null;
        intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (intent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(mContext, /*notification
            id*/1, intent, PendingIntent.FLAG_ONE_SHOT);


            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,
                    NOTIFICATION_CHANNEL_ID);

            notificationBuilder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setLargeIcon(bitmap)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
//                    .setStyle(new Notification.BigPictureStyle().bigPicture(drawbleToBitmap(mContext,R.drawable.ic_rss_feed)))
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("asbas asasja avsjasvlkasj h"))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setTicker("Hearty365")
                    //     .setPriority(Notification.PRIORITY_MAX)
                    .setContentTitle("Default notification")
                    .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                    .setContentInfo("Info")
                    .setContentIntent(pendingIntent);

            notificationManager.notify(/*notification id*/1, notificationBuilder.build());

        }

    }

    private Bitmap drawbleToBitmap(Context context, @DrawableRes int res) {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), res);
        return icon;
    }
}