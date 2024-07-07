package com.example.conversions

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversions.ui.gallery.GalleryFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val videoView: VideoView = findViewById(R.id.okok)
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.vid)
        videoView.start()

        videoView.setOnCompletionListener {
            navigateToDistanceActivity()
        }

        // Optional: Ensure transition happens at 4.9 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            if (videoView.isPlaying) {
                videoView.stopPlayback()
            }
            navigateToDistanceActivity()
        }, 4900) // 4.9 seconds
    }

    private fun navigateToDistanceActivity() {
        val intent = Intent(this, GalleryFragment::class.java)
        startActivity(intent)
        finish() // Close SplashActivity
    }
}
