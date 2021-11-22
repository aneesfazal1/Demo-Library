package com.example.demoapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
//import com.example.blinklibrary.BlinkEffect

import com.example.demoapplication.model.CurrentResponse

class MainActivity : AppCompatActivity() {

    private var context=Application()
    private var currentTimeZone:String = ""

    private var myViewModel = MyViewModel(context)
    private lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTimeZone()
        btn = findViewById(R.id.buttonView)
        btn.setOnClickListener {
            // use of blink-library
          //  BlinkEffect.blink(btn)
        }
    }

    private fun getTimeZone():String{
        myViewModel.loadData().observe(this, {current ->
            if (current != null) {
                currentTimeZone = current.first().timezone.toString()
                Toast.makeText(this@MainActivity, currentTimeZone, Toast.LENGTH_SHORT).show()
            }
        })
        return currentTimeZone
    }
}



















