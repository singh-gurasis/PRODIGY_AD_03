package com.example.stopwatch

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var atg: Animation
    private lateinit var btgone: Animation
    private lateinit var btgtwo: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone)
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo)

        binding.ivSplash.startAnimation(atg)
        binding.tvSplash.startAnimation(btgone)
        binding.tvSubSplash.startAnimation(btgone)
        binding.btnget.startAnimation(btgtwo)

        binding.btnget.setOnClickListener {
            onClick()
        }
    }
    private fun onClick(){
        var a = Intent(this, StopWatchActivity::class.java)
        a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(a)
    }
}