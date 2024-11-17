package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RootActivity : AppCompatActivity() {
    private val foodList = listOf (
        Food("Ana", "Nothing"),
        Food("Ana", "Nothing"),
        Food("Ana", "Nothing")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_root)
        val intent = Intent()
       intent.setClass(this@RootActivity, MainActivity::class.java)
        val a = intent.getStringExtra("sn");
        Log.i(TAG, "s" + a)
        val recyclerView: RecyclerView = findViewById(R.id.recycler);
        recyclerView.layoutManager = LinearLayoutManager(this);
        val adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter
    }
}