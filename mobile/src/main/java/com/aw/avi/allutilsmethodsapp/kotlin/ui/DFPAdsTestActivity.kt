package com.aw.avi.allutilsmethodsapp.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.aw.avi.allutilsmethodsapp.R
import com.google.ads.interactivemedia.v3.api.*
import com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener


class DFPAdsTestActivity : AppCompatActivity(), AdErrorEvent.AdErrorListener, AdEvent.AdEventListener {
    override fun onAdEvent(p0: AdEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAdError(p0: AdErrorEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var mSdkFactory: ImaSdkFactory
    lateinit var mAdsLoader: AdsLoader
    lateinit var mAdsManager: AdsManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dfpads_test)


        // Create an AdsLoader.
        mSdkFactory = ImaSdkFactory.getInstance()
        mAdsLoader = mSdkFactory.createAdsLoader(this)
        // Add listeners for when ads are loaded and for errors.
        mAdsLoader.addAdErrorListener(this)
        mAdsLoader.addAdsLoadedListener(AdsLoadedListener { adsManagerLoadedEvent ->
            // Ads were successfully loaded, so get the AdsManager instance. AdsManager has
            // events for ad playback and errors.
            mAdsManager = adsManagerLoadedEvent.adsManager

            // Attach event and error event listeners.
            mAdsManager.addAdErrorListener(this)
            mAdsManager.addAdEventListener(this)
            mAdsManager.init()
        })


//        // Add listener for when the content video finishes.
//        mVideoPlayer.addVideoCompletedListener(object : OnVideoCompletedListener() {
//            fun onVideoCompleted() {
//                // Handle completed event for playing post-rolls.
//                if (mAdsLoader != null) {
//                    mAdsLoader.contentComplete()
//                }
//            }
//        })
//
//        // When Play is clicked, request ads and hide the button.
//        mPlayButton.setOnClickListener(View.OnClickListener { view ->
//            mVideoPlayer.setVideoPath(getString(R.string.content_url))
//            requestAds(getString(R.string.ad_tag_url))
//            view.visibility = View.GONE
//        })

    }
}
