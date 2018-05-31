package com.aw.avi.allutilsmethodsapp.jobs.evernote;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

/**
 * Created by avinash.verma on 12/26/2017.
 */

public class DemoSyncJob extends Job {

    public static final String TAG = "job_demo_tag";

    public static void scheduleJob() {
        new JobRequest.Builder(DemoSyncJob.TAG)
                .setExecutionWindow(30_000L, 40_000L)
                .build()
                .schedule();
    }

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Log.d(TAG, "onRunJob: ");

        Toast.makeText(getContext(), "onRunJob", Toast.LENGTH_SHORT).show();
        // run your job here
        return Result.SUCCESS;
    }
}
