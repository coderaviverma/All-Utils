package com.aw.avi.allutilsmethodsapp.kotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.aw.avi.allutilsmethodsapp.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.NativeAppInstallAd
import com.google.android.gms.ads.formats.NativeAppInstallAdView
import com.google.android.gms.ads.formats.NativeContentAd

class AppsListRecyclerAdapter : RecyclerView.Adapter<AppsListRecyclerAdapter.MyViewHolder> {


    private var mContext: Context


    constructor(mContext: Context) : super() {
        this.mContext = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.ad_app_install, parent,
                false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        loadNativeAds(holder.itemView as NativeAppInstallAdView)
    }


    fun loadNativeAds(adView: NativeAppInstallAdView) {
        val adLoader = AdLoader.Builder(mContext, "/6499/example/native")
                .forAppInstallAd { ad: NativeAppInstallAd ->
                    // Show the app install ad.

                    populateAppInstallAdView(ad, adView)
                }
                .forContentAd { ad: NativeContentAd ->
                    // Show the content ad.
                }
                .withAdListener(object : AdListener() {
                    override fun onAdFailedToLoad(errorCode: Int) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build()

        adLoader.loadAd(PublisherAdRequest.Builder().build())

    }


    fun populateAppInstallAdView(nativeAppInstallAd: NativeAppInstallAd, adView: NativeAppInstallAdView) {
        adView.headlineView = adView.findViewById(R.id.appinstall_headline)
        adView.imageView = adView.findViewById(R.id.appinstall_image)
        adView.bodyView = adView.findViewById(R.id.appinstall_body)
        adView.callToActionView = adView.findViewById(R.id.appinstall_call_to_action)
        adView.iconView = adView.findViewById(R.id.appinstall_app_icon)
        adView.priceView = adView.findViewById(R.id.appinstall_price)
        adView.starRatingView = adView.findViewById(R.id.appinstall_stars)
        adView.storeView = adView.findViewById(R.id.appinstall_store)

        // Some assets are guaranteed to be in every NativeAppInstallAd.

        (adView.bodyView as TextView).text = nativeAppInstallAd.body
        (adView.callToActionView as Button).text = nativeAppInstallAd.callToAction
        (adView.iconView as ImageView).setImageDrawable(nativeAppInstallAd.icon
                .drawable)


        if (nativeAppInstallAd.headline.length <= 30) {
            (adView.headlineView as TextView).text = nativeAppInstallAd.headline
        } else {
            (adView.headlineView as TextView).text = nativeAppInstallAd.headline.subSequence(0, 30).toString() + "..."
        }

        /*List<NativeAd.Image> images = nativeAppInstallAd.getImages();

        if (images.size() > 0) {
            ((ImageView) adView.getImageView()).setImageDrawable(images.get(0).getDrawable());
        }*/
        adView.imageView.visibility = View.GONE
        // Some aren't guaranteed, however, and should be checked.
        /*if (nativeAppInstallAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAppInstallAd.getPrice());
        }*/
        adView.priceView.visibility = View.GONE
        adView.storeView.visibility = View.GONE
        /*if (nativeAppInstallAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAppInstallAd.getStore());
        }*/

        if (nativeAppInstallAd.starRating == null) {
            adView.starRatingView.visibility = View.INVISIBLE
        } else {
            (adView.starRatingView as RatingBar).rating = nativeAppInstallAd.starRating!!.toFloat()
            adView.starRatingView.visibility = View.VISIBLE
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAppInstallAd)
    }

    override fun getItemCount(): Int {
        return 10
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}

