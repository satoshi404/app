package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class root : AppCompatActivity() {
    private val foodList = listOf (
        Food("Ana", "Nothing"),
        Food("Ana", "Nothing"),
        Food("Ana", "Nothing")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_root)
        val recyclerView: RecyclerView = findViewById(R.id.recycler);
        recyclerView.layoutManager = LinearLayoutManager(this);
        val adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter
    }
}