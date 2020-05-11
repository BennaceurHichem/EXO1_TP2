  package com.example.exo1tp2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

  class MainActivity : AppCompatActivity(),OnItemClickListner  {

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val words = listOf( "Apple" , "Beard" , "Car", "Donkey","Eye")
        val exampleItem = ArrayList<ExampleItem>()
        for (w in words)   exampleItem.add(ExampleItem(w))

        recycler_view.adapter = ExampleAdapter(exampleItem,this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(item: ExampleItem, position: Int) {
      val intent =  Intent(this,DetailActivity::class.java)
      intent.putExtra("word", item.word.toString())
      startActivity(intent)


    }

    override fun btnClick(item: ExampleItem, position: Int) {
      val intent =  Intent(this,DetailActivity::class.java)
      intent.putExtra("word", item.word.toString())
      startActivity(intent)

    }
  }
