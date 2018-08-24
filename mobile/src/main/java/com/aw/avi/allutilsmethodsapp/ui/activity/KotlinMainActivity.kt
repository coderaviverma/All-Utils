package com.aw.avi.allutilsmethodsapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aw.avi.allutilsmethodsapp.R
import com.aw.avi.allutilsmethodsapp.kotlin.ui.AdsInKotlinActivity
import com.aw.avi.allutilsmethodsapp.kotlin.ui.KotlinBasicActivity
import kotlinx.android.synthetic.main.activity_kotlin_main.*

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

        bt_kotlin_first.setOnClickListener {
            startActivity(Intent(this, KotlinBasicActivity::class.java))
        }

        bt_kotlin_logics.setOnClickListener {
            startActivity(Intent(this, KotlinBasicActivity::class.java))
        }

        bt_ads_in_kotlin.setOnClickListener {
            startActivity(Intent(this, AdsInKotlinActivity::class.java))
        }




    }

//    @OnClick(R.id.bt_kotlin_first, R.id.bt_kotlin_logics)
//    fun onViewClicked(view: View) {
//        when (view.id) {
//            R.id.bt_kotlin_first -> startActivity(Intent(this, KotlinBasicActivity::class.java))
//            R.id.bt_kotlin_logics -> {
//            }
//        }
//    }
}
