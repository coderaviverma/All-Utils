package com.aw.avi.allutilsmethodsapp.ui.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.aw.avi.allutilsmethodsapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderActivity extends AppCompatActivity {

    public static final String URL = "";
    @BindView(R.id.iv_picasso)
    ImageView ivPicasso;
    @BindView(R.id.iv_glide)
    ImageView ivGlide;
    @BindView(R.id.iv_uil)
    ImageView ivUil;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ButterKnife.bind(this);
        mContext = this;


        Glide.with(mContext).load(URL).into(ivGlide);

    }


    private void glideMethods(String url) {

        Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {


            }
        });

//Glide Version 3.8
//        Glide.with(this).load(url).asBitmap().into(new
//                                                                 SimpleTarget<Bitmap>() {
//                                                                     @Override
//                                                                     public void onResourceReady(Bitmap resource,
//                                                                                                 GlideAnimation<? super
//                                                                                                         Bitmap>
//                                                                                                         glideAnimation) {
//                                                                         uploadvideothumbimagefile = Utility
//                                                                                 .convertBitmaptoFile(mContext, "videothumb",
//                                                                                         resource);
//                                                                     }
//                                                                 });

    }
}
