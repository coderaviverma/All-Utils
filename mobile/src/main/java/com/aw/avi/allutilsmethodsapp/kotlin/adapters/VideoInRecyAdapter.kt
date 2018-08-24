package com.aw.avi.allutilsmethodsapp.kotlin.adapters

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.aw.avi.allutilsmethodsapp.R
import com.aw.avi.allutilsmethodsapp.kotlin.Utils
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import java.io.File

class VideoInRecyAdapter : RecyclerView.Adapter<VideoInRecyAdapter.VideoViewHolder> {

    private var dataList: Array<File>
    private var mContext: Context
    //initiate Player
//Create a default TrackSelector
    val bandwidthMeter = DefaultBandwidthMeter();
    val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter);
    val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory);

    //Create the player
//    var player: SimpleExoPlayer? = null

    constructor(mContext: Context, dataList: Array<File>) : super() {
        this.mContext = mContext
        this.dataList = dataList
//        player = ExoPlayerFactory.newSimpleInstance(mContext, trackSelector)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VideoViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_status_recycler, parent,
                false)

        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val filepath: File = dataList.get(position)

        val fileType: String? = Utils.getMimeType(this.mContext, Uri.fromFile(filepath))
        if (fileType != null) {
            if (fileType.contains("image")) {
                holder.iv_preview.visibility = View.VISIBLE
                holder.exoplayer.visibility = View.GONE
                Glide.with(mContext).load(dataList.get(position)).into(holder.iv_preview)
            } else {
                holder.iv_preview.visibility = View.GONE
                holder.exoplayer.visibility = View.VISIBLE


                val video = Uri.fromFile(filepath)

//                //initiate Player
////Create a default TrackSelector
//                val bandwidthMeter = DefaultBandwidthMeter();
//                val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter);
//                val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory);
//
////Create the player
//                player=null
//                player = ExoPlayerFactory.newSimpleInstance(mContext, trackSelector)
//
//                holder.exoplayer.setPlayer(player);
//
//                val rtmpDataSourceFactory = DefaultDataSourceFactory(mContext, "ua");
//                // This is the MediaSource representing the media to be played.
//                val videoSource = ExtractorMediaSource.Factory(rtmpDataSourceFactory)
//                        .createMediaSource(video);
//
//                // Prepare the player with the source.
//                player!!.prepare(videoSource);
//                //auto start playing
//                player!!.setPlayWhenReady(true);

                ExoPlayerVideoHandler.getInstance()
                ExoPlayerVideoHandler.getInstance().prepareExoPlayerForUri(mContext,video,holder.exoplayer)

            }
        }

    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?) {
        super.onDetachedFromRecyclerView(recyclerView)

        Log.d("VideoInRecyAdapter","onDetachedFromRecyclerView")
    }


    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var iv_preview: ImageView
        internal var exoplayer: PlayerView

        init {
            iv_preview = itemView.findViewById(R.id.iv_preview)
            exoplayer = itemView.findViewById(R.id.exoplayer)

        }
    }
}