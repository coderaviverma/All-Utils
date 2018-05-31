package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.jobs.firebase.MyJobService;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobsActivity extends AppCompatActivity {

    private static final String TAG = "Job1";
    @BindView(R.id.bt_evernote_jobs)
    Button btEvernoteJobs;
    @BindView(R.id.bt_firebase_jobs)
    Button btFirebaseJobs;

    private boolean FIREBASE_JOB_STARTED;

    private Context context;

    //Evernote Jobs
//    private JobManager mJobManager;
    private int mLastJobId;

    public static void scheduleJob(Context context) {
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
        Job job = createJob(dispatcher);
        dispatcher.schedule(job);

    }

    public static Job createJob(FirebaseJobDispatcher dispatcher) {
        Job job = dispatcher.newJobBuilder()
                // persist the task across boots
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                // Call this service when the criteria are met.
                .setService(MyJobService.class)
                // unique id of the task
                .setTag("OneTimeJob")
                // We are mentioning that the job is not periodic.
                .setRecurring(false)
                // Run between 30 - 60 seconds from now.
                .setTrigger(Trigger.executionWindow(0, 5))
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
//                .setTrigger(Trigger.NOW)
                //Run this job only when the network is avaiable.
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .build();
        return job;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        ButterKnife.bind(this);
        context = this;

        Log.d(TAG, "onCreate: ");
// Create a new dispatcher using the Google Play driver.
//        mJobManager = JobManager.instance();

    }

    @OnClick({R.id.bt_evernote_jobs, R.id.bt_firebase_jobs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_evernote_jobs:

                testSimple();
                break;
            case R.id.bt_firebase_jobs:


//                startBasicFirebaseJobs(new FirebaseJobDispatcher(new GooglePlayDriver(this)));
//                startAdvanceFirebaseJob(new FirebaseJobDispatcher(new GooglePlayDriver(this)));
//                if (!FIREBASE_JOB_STARTED) {
//                    FIREBASE_JOB_STARTED = true;
//                    Job job = dispatcher.newJobBuilder()
//                            .setService(MyJobService.class)
//                            .setTag(TAG)
//                            .build();
//
//                    dispatcher.schedule(job);
//                } else {
//                    FIREBASE_JOB_STARTED = false;
//                    dispatcher.cancel(TAG);
//                }

//                startAdvanceFirebaseJob(dispatcher);


                scheduleJob(this);
                break;
        }
    }

    private void startAdvanceFirebaseJob(FirebaseJobDispatcher dispatcher) {
        Bundle myExtrasBundle = new Bundle();
        myExtrasBundle.putString("some_key", "some_value");

        Job myJob = dispatcher.newJobBuilder()
                // the JobService that will be called
                .setService(MyJobService.class)
                // uniquely identifies the job
                .setTag(TAG)
                // one-off job
                .setRecurring(true)
                // don't persist past a device reboot
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                // start between 0 and 60 seconds from now
                .setTrigger(Trigger.executionWindow(0, 15))
                // don't overwrite an existing job with the same tag
                .setReplaceCurrent(true)
                // retry with exponential backoff
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                // constraints that need to be satisfied for the job to run
                .setConstraints(
                        // only run on an unmetered network
                        Constraint.ON_UNMETERED_NETWORK,
                        // only run when the device is charging
                        Constraint.ON_ANY_NETWORK
                )
                .setExtras(myExtrasBundle)
                .build();

        dispatcher.mustSchedule(myJob);
//        dispatcher.schedule(myJob);
    }

    private void startBasicFirebaseJobs(FirebaseJobDispatcher dispatcher) {
        Job job = dispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag(TAG)
                .build();

        dispatcher.schedule(job);
    }

    private void testSimple() {
        PersistableBundleCompat extras = new PersistableBundleCompat();
        extras.putString("key", "Hello world");

        mLastJobId = new JobRequest.Builder(TAG)
                .setExecutionWindow(3_000L, 4_000L)
                .setBackoffCriteria(5_000L, JobRequest.BackoffPolicy.LINEAR)
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .setRequiredNetworkType(JobRequest.NetworkType.ANY)
                .setExtras(extras)
                .setRequirementsEnforced(true)
                .build()
                .schedule();
    }
}
