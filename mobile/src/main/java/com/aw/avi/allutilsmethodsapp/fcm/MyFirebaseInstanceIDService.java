package com.aw.avi.allutilsmethodsapp.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import timber.log.Timber;

/**
 * Created by avinash.verma on 8/24/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Timber.i("Refreshed token: " + refreshedToken);
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        if (refreshedToken != null) {
            sendRegistrationToServer(refreshedToken);
        }
    }

    private void sendRegistrationToServer(String token) {
//        MyPreferences.getInstance(this).saveString(Constants.FCM_TOKEN_KEY, token);
    }
}