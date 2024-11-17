package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        Timer().schedule(object : TimerTask() {
            override fun run() {
                finish()
                startActivity(Intent(this@MainActivity, root::class.java))
                //finish()

                Log.d(
                    "MainActivity:",
                    "onCreate: waiting 5 seconds for MainActivity... loading PrimaryActivity.class"
                )
            }
        }, 5000)


    }
}