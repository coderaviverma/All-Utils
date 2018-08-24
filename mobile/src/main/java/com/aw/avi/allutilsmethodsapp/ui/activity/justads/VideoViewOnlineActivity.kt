package com.aw.avi.allutilsmethodsapp.ui.activity.justads

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import com.aw.avi.allutilsmethodsapp.R
import com.aw.avi.allutilsmethodsapp.kotlin.Utils
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.FileDataSource
import java.io.File




class VideoViewOnlineActivity : AppCompatActivity() {
    var VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"
    var videoview: VideoView? = null

    val path = "/WhatsApp/Media/.Statuses"
    val pathToWatch = android.os.Environment.getExternalStorageDirectory().toString() + path


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view_online)



        videoview = findViewById(R.id.videoview);


        val directory = File(pathToWatch)
        val files = directory.listFiles()
        Log.d("Files", "Size: " + files.size)
        for (i in files.indices) {
            Log.d("Files", "FileName:" + files[i].getName())
            val fileType: String? = Utils.getMimeType(this, Uri.fromFile(files.get(i)))

            if (fileType!!.contains("video")) {

                val mediaController = MediaController(this)
                mediaController.setAnchorView(videoview)
                mediaController.setMediaPlayer(videoview)
//        val video = Uri.parse(VideoURL)
                val video = Uri.fromFile(files.get(i))

                videoview!!.setMediaController(mediaController)
                videoview!!.setVideoURI(video)
                videoview!!.requestFocus()
                videoview!!.start()

//                videoview!!.setOnPreparedListener {
//                    videoview!!.start()
//                }
                Log.d("Files","Played")

//                val mc = MediaController(this)
//                mc.setAnchorView(videoView)
//                mc.setMediaPlayer(videoView)
//                videoView.setMediaController(mc)
//
//                videoView.setVideoPath(path)
//
//
//                videoView.requestFocus()
//                videoView.start()

//Type 2
//                val player = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
//                videoPlayer.requestFocus()
//                videoPlayer.setPlayer(player)
//                val videoSource = buildMediaSource(video)
//            player.prepare(videoSource)
                break
            }
        }

    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        val extractorsFactory = DefaultExtractorsFactory()

//        val mediaDataSourceFactory=DefaultHttpDataSourceFactory("ua")
        val mediaDataSourceFactory=DefaultHttpDataSourceFactory("ua")

//        val mediaSource = ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"),
//                mediaDataSourceFactory, extractorsFactory, null, null)


        val dataSpec = DataSpec(uri)
        val fileDataSource = FileDataSource()
        try {
            fileDataSource.open(dataSpec)
        } catch (e: FileDataSource.FileDataSourceException) {
            e.printStackTrace()
        }


        val factory = object : DataSource.Factory {
            override fun createDataSource(): DataSource {
                return fileDataSource
            }
        }
        val mediaSource = ExtractorMediaSource(fileDataSource.getUri(),
                factory, DefaultExtractorsFactory(), null, null)


//        return ExtractorMediaSource(uri,
//                DefaultHttpDataSourceFactory("ua"),
//                DefaultExtractorsFactory(), null, null)

        return mediaSource
    }

//    private fun playExoPlayer(){
//        val player = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
//        videoPlayer.setPlayer(player)
//
//        val rawResourceDataSource = RawResourceDataSource(this)
//        val dataSpec = DataSpec(RawResourceDataSource.buildRawResourceUri(R.raw.presentation))
//        try {
//            rawResourceDataSource.open(dataSpec)
//
//            val factory = object : DataSource.Factory() {
//                fun createDataSource(): DataSource {
//                    return rawResourceDataSource
//                }
//            }
//            val videoSource = ExtractorMediaSource.Factory(factory).createMediaSource(rawResourceDataSource.getUri())
//            player.prepare(videoSource)
//
//        } catch (e: RawResourceDataSource.RawResourceDataSourceException) {
//            e.printStackTrace()
//        }
//
//    }
}
