package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aw.avi.allutilsmethodsapp.R;
import com.aw.avi.allutilsmethodsapp.ui.activity.database.RoomExampleActivity;
import com.aw.avi.allutilsmethodsapp.ui.activity.maps.MapOptionsActivity;
import com.aw.avi.allutilsmethodsapp.ui.activity.recyclerviews.RecyclerViewMainActivity;
import com.aw.avi.allutilsmethodsapp.ui.activity.utilityui.UtilityMainActivity;
import com.aw.avi.allutilsmethodsapp.ui.activity.viewpagers.ViewpagerActivity;
import com.aw.avi.allutilsmethodsapp.ui.fragments.MyDialogFragment;
import com.aw.avi.allutilsmethodsapp.utils.Utilities;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_viewpager)
    Button btViewpager;
    @BindView(R.id.bt_recylerview)
    Button btRecylerview;
    @BindView(R.id.bt_tablayout)
    Button btTablayout;
    @BindView(R.id.bt_bottom_tablayout)
    Button btBottomTablayout;
    @BindView(R.id.bt_retrofitapi)
    Button btRetrofitapi;
    @BindView(R.id.bt_share_in_my_app)
    Button btShareInMyApp;


    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

//        Intent intent = new Intent(mContext, ChargingStickyBroadcast.class);
//        sendStickyBroadcast(intent);

    }


    @OnClick({R.id.bt_viewpager, R.id.bt_recylerview, R.id.bt_tablayout, R.id.bt_retrofitapi, R
            .id.bt_download_enqueue, R.id
            .bt_share_in_my_app, R.id.bt_dialog_fragment, R.id.bt_jobs, R.id.bt_maps, R.id
            .bt_sockets,
            R.id.bt_databases, R.id.bt_kotlin_demo, R.id.bt_alert_dialog, R.id.bt_life_cycle, R
            .id.bt_without_library, R.id.bt_launch_modes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_kotlin_demo:
                startActivity(new Intent(this, KotlinMainActivity.class));
                break;
            case R.id.bt_life_cycle:
                startActivity(new Intent(this, KotlinMainActivity.class));
                break;
            case R.id.bt_without_library:
                startActivity(new Intent(this, EverythingWithoutLibraryActivity.class));
                break;
            case R.id.bt_launch_modes:
                startActivity(new Intent(this, LaunchModeMainActivity.class));
                break;
            case R.id.bt_alert_dialog:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder
                        (getApplicationContext());
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                alertDialogBuilder.setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                break;
            case R.id.bt_dialog_fragment:
                Bundle bundle = new Bundle();
                bundle.putString("data", "data");
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                if (myDialogFragment != null && getSupportFragmentManager() != null) {
                    myDialogFragment.setArguments(bundle);
                    myDialogFragment.show(getSupportFragmentManager(), "my dialog fragment");
                }
                break;
            case R.id.bt_share_in_my_app:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This " +
                        "is the text that will be shared.</p>"));
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;
            case R.id.bt_viewpager:
                startActivity(new Intent(this, ViewpagerActivity.class));
                break;

            case R.id.bt_recylerview:
                startActivity(new Intent(this, RecyclerViewMainActivity.class));
                break;
            case R.id.bt_tablayout:
                startActivity(new Intent(this, TabLayoutMainActivity.class));
                break;
            case R.id.bt_retrofitapi:
                break;
            case R.id.bt_download_enqueue:
//                String url = "http://www.sample-videos.com/csv/Sample-Spreadsheet-10000-rows.csv";
                String url = "http://www.pdf995.com/samples/pdf.pdf";
                Utilities.downloadEnqueue(mContext, url);

//                Utilities.getFilename(url);

//                Toast.makeText(mContext, ""+ Utilities.getFilename(url), Toast.LENGTH_SHORT)
// .show();
                break;
            case R.id.bt_jobs:
                startActivity(new Intent(this, JobsActivity.class));
                break;
            case R.id.bt_maps:
                startActivity(new Intent(this, MapOptionsActivity.class));
                break;
            case R.id.bt_sockets:
                startActivity(new Intent(this, SocketProgrammingActivity.class));
                break;
            case R.id.bt_social_logins:
                startActivity(new Intent(this, SocialSignsActivity.class));
                break;
            case R.id.bt_databases:
                startActivity(new Intent(this, RoomExampleActivity.class));
                break;
            case R.id.bt_animations:
                startActivity(new Intent(this, AnimationMainActivity.class));
                break;

            case R.id.bt_ads:
                startActivity(new Intent(this, AdsMainActivity.class));
                break;
            case R.id.bt_utilities:
                startActivity(new Intent(this, UtilityMainActivity.class));
                break;
            case R.id.bt_deeplinking:
                startActivity(new Intent(this, DeepLinkingMainActivity.class));
                break;
        }
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
