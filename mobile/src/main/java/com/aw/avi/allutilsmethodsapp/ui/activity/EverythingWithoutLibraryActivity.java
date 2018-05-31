package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.aw.avi.allutilsmethodsapp.R;

import java.net.URL;

public class EverythingWithoutLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everything_without_library);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ImageView imageView = findViewById(R.id.iv_image_view);

        String url = "https://upload.wikimedia" +
                ".org/wikipedia/commons/5/5f/Johnny_Depp_Alice_Through_the_Looking_Glass_premiere" +
                ".jpg";

        URL imageURL = null;
        try {
            imageURL = new URL(url);
            Bitmap imageBitmap = BitmapFactory.decodeStream(imageURL.openStream());
            imageView.setImageBitmap(imageBitmap);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
}
