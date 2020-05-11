package com.example.exo1tp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*
class ExampleAdapter(private val exampleList: List<ExampleItem>,var clickListner: OnItemClickListner) :



    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)




        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.word.text = currentItem.word

        holder.initialize(exampleList.get(position),clickListner)
    }
    override fun getItemCount() = exampleList.size
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val word: TextView = itemView.word
        val detail_btn:Button = itemView.detail_btn


        fun initialize(item: ExampleItem, action:OnItemClickListner){

            word.text = item.word
            detail_btn.setOnClickListener(View.OnClickListener { v->
                if (action != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        action.btnClick(item,position)
                    }
                }})

            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }

        }
    }
}

interface OnItemClickListner{
    fun onItemClick(item: ExampleItem, position: Int)
    fun btnClick(item: ExampleItem,position: Int)

}