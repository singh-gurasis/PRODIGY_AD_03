package com.example.stopwatch

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.stopwatch.databinding.ActivityStopWatchBinding
import java.util.Date

class StopWatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStopWatchBinding

    private lateinit var round: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_stop_watch)

        round = AnimationUtils.loadAnimation(this, R.anim.round)

        binding.btnstop.setAlpha(0F)

        binding.btnstart.setOnClickListener {

            onClick()

        }
        binding.btnstop.setOnClickListener {
            onPauseClick()
        }
    }

    private fun onClick() {
        binding.icanchor.startAnimation(round)
        binding.btnstop.animate().alpha(1F).setDuration(300).start()
        binding.btnstart.animate().alpha(0F).setDuration(300).start()

        binding.timer.setBase(SystemClock.elapsedRealtime())
        binding.timer.start()
    }

    private fun onPauseClick(){

        binding.icanchor.clearAnimation()

        binding.btnstop.animate().alpha(0F).setDuration(300).start()
        binding.btnstart.animate().alpha(1F).setDuration(300).start()
        binding.timer.stop()

        val res = "Restart"
        binding.btnstart.text = res

    }

}

