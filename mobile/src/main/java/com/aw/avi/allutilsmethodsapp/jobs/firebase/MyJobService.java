package com.aw.avi.allutilsmethodsapp.jobs.firebase;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

/**
 * Created by avinash.verma on 12/27/2017.
 */

public class MyJobService extends JobService {
    private static final String TAG = MyJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters job) {


        Log.d(TAG, "onStartJob: ");

        Toast.makeText(this, "onStartJob: ", Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                completeJob(job);
            }
        }).start();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {

        Toast.makeText(this, "My Job service Stoped", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStopJob: ");
        return false;
    }


    public void completeJob(final JobParameters parameters) {
        try {
            //This task takes 2 seconds to complete.
            Thread.sleep(2000);
            Log.d(TAG, "completeJob: ");

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MyJobService.this, "completeJob: ", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Tell the framework that the job has completed and doesnot needs to be reschedule
            jobFinished(parameters, true);
        }
    }
}
