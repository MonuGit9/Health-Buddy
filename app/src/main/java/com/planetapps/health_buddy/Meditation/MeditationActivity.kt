package com.planetapps.health_buddy.Meditation

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.planetapps.health_buddy.R
import com.planetapps.health_buddy.databinding.ActivityBmiBinding
import com.planetapps.health_buddy.databinding.ActivityMeditationBinding

class MeditationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMeditationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeditationBinding.inflate(layoutInflater)
        setContentView(binding.root)

       var mediaPlayer1  : MediaPlayer= MediaPlayer.create(this,R.raw.relax)
        binding.playbtn1.setOnClickListener{
            mediaPlayer1 = MediaPlayer.create(this,R.raw.relax)
            mediaPlayer1.start()}
        binding.stopbtn1.setOnClickListener{
            mediaPlayer1.stop()
        }

        }
    }