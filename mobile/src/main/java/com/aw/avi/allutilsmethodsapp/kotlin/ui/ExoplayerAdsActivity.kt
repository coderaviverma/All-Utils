package com.aw.avi.allutilsmethodsapp.kotlin.ui

import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Surface
import com.aw.avi.allutilsmethodsapp.R
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.decoder.DecoderCounters
import com.google.android.exoplayer2.ext.rtmp.RtmpDataSourceFactory
import com.google.android.exoplayer2.metadata.Metadata
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.video.VideoRendererEventListener
import kotlinx.android.synthetic.main.activity_exoplayer_ads.*
import java.io.IOException
import java.lang.Exception

class ExoplayerAdsActivity : AppCompatActivity() {

//    val RTMPurl = "rtmp://stream1.livestreamingservices.com:1935/tvmlive/tvmlive"
    val RTMPurl = "rtmp://111.93.21.44/live/nvs25"
//    val RTMPurl = "rtmp://bomtv.5centscdn.com:1935/ddstrtmp://111.93.21.44/live/nvs25ream/66f66fd8a578846d952c0dcaba0a90f8.sdp"
//    val RTMPurl = "http://d1vfuy3zwrxiut.cloudfront.net/live….ca.m3u8"
//    val RTMPurl="rtmp://a.rtmp.youtube.com/live2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exoplayer_ads)


        //initiate Player
//Create a default TrackSelector
        val bandwidthMeter = DefaultBandwidthMeter();
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

//Create the player
        val player = ExoPlayerFactory.newSimpleInstance(this, trackSelector!!)
//        val playerView = findViewById(R.id.exoplayer);
        exoplayer.setPlayer(player)
//        exoplayer.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener{
//            override fun onViewAttachedToWindow(v: View?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onViewDetachedFromWindow(v: View?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        })

        val rtmpDataSourceFactory = RtmpDataSourceFactory()
// This is the MediaSource representing the media to be played.
        val videoSource = ExtractorMediaSource.Factory(rtmpDataSourceFactory)
                .createMediaSource(Uri.parse(RTMPurl))

        player.addVideoDebugListener(object : VideoRendererEventListener {
            override fun onDroppedFrames(count: Int, elapsedMs: Long) {
                Log.d("addVideoDebugListener", "onDroppedFrames")
            }

            override fun onVideoEnabled(counters: DecoderCounters?) {
                Log.d("addVideoDebugListener", "onVideoEnabled")
            }

            override fun onVideoSizeChanged(width: Int, height: Int, unappliedRotationDegrees: Int, pixelWidthHeightRatio: Float) {
                Log.d("addVideoDebugListener", "onVideoSizeChanged")
            }

            override fun onVideoDisabled(counters: DecoderCounters?) {
                Log.d("addVideoDebugListener", "onVideoDisabled")
            }

            override fun onVideoDecoderInitialized(decoderName: String?, initializedTimestampMs: Long, initializationDurationMs: Long) {
                Log.d("addVideoDebugListener", "onVideoDecoderInitialized")
            }

            override fun onVideoInputFormatChanged(format: Format?) {
                Log.d("addVideoDebugListener", "onVideoInputFormatChanged")
            }

            override fun onRenderedFirstFrame(surface: Surface?) {
                Log.d("addVideoDebugListener", "onRenderedFirstFrame")
            }
        })


        player.addAnalyticsListener(object : AnalyticsListener {
            override fun onSeekProcessed(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onSeekProcessed")
            }

            override fun onPlaybackParametersChanged(eventTime: AnalyticsListener.EventTime?, playbackParameters: PlaybackParameters?) {
                Log.d("addAnalyticsListener", "onPlaybackParametersChanged")
            }

            override fun onPlayerError(eventTime: AnalyticsListener.EventTime?, error: ExoPlaybackException?) {
                Log.d("addAnalyticsListener", "onPlayerError")
            }

            override fun onSeekStarted(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onSeekStarted")
            }

            override fun onLoadingChanged(eventTime: AnalyticsListener.EventTime?, isLoading: Boolean) {
                Log.d("addAnalyticsListener", "onLoadingChanged")
            }

            override fun onDownstreamFormatChanged(eventTime: AnalyticsListener.EventTime?, mediaLoadData: MediaSourceEventListener.MediaLoadData?) {
                Log.d("addAnalyticsListener", "onDownstreamFormatChanged")
            }

            override fun onDrmKeysLoaded(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onDrmKeysLoaded")
            }

            override fun onMediaPeriodCreated(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onMediaPeriodCreated")
            }

            override fun onRenderedFirstFrame(eventTime: AnalyticsListener.EventTime?, surface: Surface?) {
                Log.d("addAnalyticsListener", "onRenderedFirstFrame")
            }

            override fun onReadingStarted(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onReadingStarted")
            }

            override fun onBandwidthEstimate(eventTime: AnalyticsListener.EventTime?, totalLoadTimeMs: Int, totalBytesLoaded: Long, bitrateEstimate: Long) {
                Log.d("addAnalyticsListener", "onBandwidthEstimate")
            }

            override fun onNetworkTypeChanged(eventTime: AnalyticsListener.EventTime?, networkInfo: NetworkInfo?) {
                Log.d("addAnalyticsListener", "onNetworkTypeChanged")
            }

            override fun onPlayerStateChanged(eventTime: AnalyticsListener.EventTime?, playWhenReady: Boolean, playbackState: Int) {
                Log.d("addAnalyticsListener", "onPlayerStateChanged")
            }

            override fun onViewportSizeChange(eventTime: AnalyticsListener.EventTime?, width: Int, height: Int) {
                Log.d("addAnalyticsListener", "onViewportSizeChange")
            }

            override fun onDrmKeysRestored(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onDrmKeysRestored")
            }

            override fun onDecoderDisabled(eventTime: AnalyticsListener.EventTime?, trackType: Int, decoderCounters: DecoderCounters?) {
                Log.d("addAnalyticsListener", "onDecoderDisabled")
            }

            override fun onShuffleModeChanged(eventTime: AnalyticsListener.EventTime?, shuffleModeEnabled: Boolean) {
                Log.d("addAnalyticsListener", "onShuffleModeChanged")
            }

            override fun onDecoderInputFormatChanged(eventTime: AnalyticsListener.EventTime?, trackType: Int, format: Format?) {
                Log.d("addAnalyticsListener", "onDecoderInputFormatChanged")
            }

            override fun onAudioSessionId(eventTime: AnalyticsListener.EventTime?, audioSessionId: Int) {
                Log.d("addAnalyticsListener", "onAudioSessionId")
            }

            override fun onDrmSessionManagerError(eventTime: AnalyticsListener.EventTime?, error: Exception?) {
                Log.d("addAnalyticsListener", "onDrmSessionManagerError")
            }

            override fun onLoadStarted(eventTime: AnalyticsListener.EventTime?, loadEventInfo: MediaSourceEventListener.LoadEventInfo?, mediaLoadData: MediaSourceEventListener.MediaLoadData?) {
                Log.d("addAnalyticsListener", "onLoadStarted")
            }

            override fun onTracksChanged(eventTime: AnalyticsListener.EventTime?, trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
                Log.d("addAnalyticsListener", "onTracksChanged")
            }

            override fun onPositionDiscontinuity(eventTime: AnalyticsListener.EventTime?, reason: Int) {
                Log.d("addAnalyticsListener", "onPositionDiscontinuity")
            }

            override fun onRepeatModeChanged(eventTime: AnalyticsListener.EventTime?, repeatMode: Int) {
                Log.d("addAnalyticsListener", "onRepeatModeChanged")
            }

            override fun onUpstreamDiscarded(eventTime: AnalyticsListener.EventTime?, mediaLoadData: MediaSourceEventListener.MediaLoadData?) {
                Log.d("addAnalyticsListener", "onUpstreamDiscarded")
            }

            override fun onLoadCanceled(eventTime: AnalyticsListener.EventTime?, loadEventInfo: MediaSourceEventListener.LoadEventInfo?, mediaLoadData: MediaSourceEventListener.MediaLoadData?) {
                Log.d("addAnalyticsListener", "onLoadCanceled")
            }

            override fun onMediaPeriodReleased(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onMediaPeriodReleased")
            }

            override fun onTimelineChanged(eventTime: AnalyticsListener.EventTime?, reason: Int) {
                Log.d("addAnalyticsListener", "onTimelineChanged")
            }

            override fun onDecoderInitialized(eventTime: AnalyticsListener.EventTime?, trackType: Int, decoderName: String?, initializationDurationMs: Long) {
                Log.d("addAnalyticsListener", "onDecoderInitialized")
            }

            override fun onDroppedVideoFrames(eventTime: AnalyticsListener.EventTime?, droppedFrames: Int, elapsedMs: Long) {
                Log.d("addAnalyticsListener", "onDroppedVideoFrames")
            }

            override fun onDecoderEnabled(eventTime: AnalyticsListener.EventTime?, trackType: Int, decoderCounters: DecoderCounters?) {
                Log.d("addAnalyticsListener", "onDecoderEnabled")
            }

            override fun onVideoSizeChanged(eventTime: AnalyticsListener.EventTime?, width: Int, height: Int, unappliedRotationDegrees: Int, pixelWidthHeightRatio: Float) {
                Log.d("addAnalyticsListener", "onVideoSizeChanged")
            }

            override fun onAudioUnderrun(eventTime: AnalyticsListener.EventTime?, bufferSize: Int, bufferSizeMs: Long, elapsedSinceLastFeedMs: Long) {
                Log.d("addAnalyticsListener", "onAudioUnderrun")
            }

            override fun onLoadCompleted(eventTime: AnalyticsListener.EventTime?, loadEventInfo: MediaSourceEventListener.LoadEventInfo?, mediaLoadData: MediaSourceEventListener.MediaLoadData?) {
                Log.d("addAnalyticsListener", "onLoadCompleted")
            }

            override fun onDrmKeysRemoved(eventTime: AnalyticsListener.EventTime?) {
                Log.d("addAnalyticsListener", "onDrmKeysRemoved")
            }

            override fun onLoadError(eventTime: AnalyticsListener.EventTime?, loadEventInfo: MediaSourceEventListener.LoadEventInfo?, mediaLoadData: MediaSourceEventListener.MediaLoadData?, error: IOException?, wasCanceled: Boolean) {
                Log.d("addAnalyticsListener", "onLoadError")
                Log.d("addAnalyticsListener", "onLoadError " + error + " eventTime " + eventTime)
                Log.d("addAnalyticsListener", "mediaLoadData " + mediaLoadData!!.dataType + " loadEventInfo " + loadEventInfo)
                Log.d("addAnalyticsListener", "mediaLoadData.dataType " + mediaLoadData!!.dataType )
            }

            override fun onMetadata(eventTime: AnalyticsListener.EventTime?, metadata: Metadata?) {
                Log.d("addAnalyticsListener", "onMetadata")
            }

        })
// Prepare the player with the source.
        player.prepare(videoSource)

//auto start playing
        player.setPlayWhenReady(true)
    }
}
