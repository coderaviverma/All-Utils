package com.aw.avi.allutilsmethodsapp.applications;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import com.aw.avi.allutilsmethodsapp.BuildConfig;
import com.aw.avi.allutilsmethodsapp.R;

import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by avinash.verma on 12/18/2017.
 */

public class MyApplication extends Application {

    private static Context instance;

    public static Context getApplicationContexts() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
        //Multidex
        MultiDex.install(this);

        //Initialize the Branch object
//        Branch.getAutoInstance(this);

        //Logging
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        //DI Font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/HelveticaNeue-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        //Evernote Jobs
//        JobManager.create(this).addJobCreator(new DemoJobCreator());


        //Thread Policy
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                builder.detectFileUriExposure();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
