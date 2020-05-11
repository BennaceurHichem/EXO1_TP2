package com.example.exo1tp2


import android.media.MediaPlayer
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.view.View.VISIBLE
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable: Runnable
    private var handler: Handler = Handler()
    private var pause: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)




        val word = getIntent().getStringExtra("word").toString()

        word_text.text = word

        start.setOnClickListener {
            if (pause) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            } else {
                //still adding voices to the raw folder

                when (word) {
                    "Apple" ->  {

                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.apple)

                    }
                    "Beard" ->{

                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.beard)
                        frameLayout.visibility = VISIBLE
                        text.visibility = VISIBLE

                        val videoView: VideoView = findViewById(R.id.video_view)
                        val videoPath = "android.resource://" + packageName + "/" + R.raw.beardvid
                        val uri: Uri = Uri.parse(videoPath)
                        videoView.setVideoURI(uri)
                        val mediaController = MediaController(this)
                        videoView.setMediaController(mediaController)
                        mediaController.setAnchorView(videoView)

                    }
                    "Car" ->mediaPlayer = MediaPlayer.create(applicationContext, R.raw.car)

                    "Donkey" ->mediaPlayer = MediaPlayer.create(applicationContext, R.raw.donkey)
                    "Eye" ->mediaPlayer = MediaPlayer.create(applicationContext, R.raw.eye)

                    else -> { // Note the block
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.problem)
                    }
                }
                mediaPlayer.start()
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()

            }
        }




    }


}



