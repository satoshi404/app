package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(food: Food) {
        itemView.findViewById<TextView>(R.id.title).text = food.name
        itemView.findViewById<TextView>(R.id.artist).text = food.chef
    }
}


class FoodAdapter(private val foods: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}