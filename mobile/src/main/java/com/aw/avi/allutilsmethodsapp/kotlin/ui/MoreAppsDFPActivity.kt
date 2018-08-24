package com.aw.avi.allutilsmethodsapp.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.aw.avi.allutilsmethodsapp.R
import com.aw.avi.allutilsmethodsapp.kotlin.adapters.AppsListRecyclerAdapter
import kotlinx.android.synthetic.main.activity_more_apps_dfp.*

class MoreAppsDFPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_apps_dfp)

        rcv_moreapps.adapter = AppsListRecyclerAdapter(this);
        rcv_moreapps.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}
