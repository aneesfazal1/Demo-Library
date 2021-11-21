package com.example.demoapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.demoapplication.model.CurrentResponse

class MainActivity : AppCompatActivity() {

    private var context=Application()
    private var currentTimeZone:String = ""

    private var myViewModel = MyViewModel(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTimeZone()
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



















