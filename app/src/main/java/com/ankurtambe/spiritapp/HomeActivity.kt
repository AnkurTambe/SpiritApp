package com.ankurtambe.spiritapp

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPreferences =
            getSharedPreferences("shared_preferences", MODE_PRIVATE)


        var counter = sharedPreferences.getInt("cnt", 0)
        tv_counter.text= counter.toString()

        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.jsr)

        btn_jsr.setOnClickListener {
            counter += 1;
            tv_counter.text= counter.toString()
            sharedPreferences.edit().putInt("cnt", counter).apply()
            mp.start()
        }

        btn_reset.setOnClickListener {
            counter = 0;
            tv_counter.text= counter.toString()
        }
    }
}