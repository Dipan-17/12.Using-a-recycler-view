package com.example.viewbindingpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingpractice.databinding.RecyclerviewItemBinding

class MainAdapter(val taskList:List<Task>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(val itemBinding:RecyclerviewItemBinding):RecyclerView.ViewHolder(itemBinding.root){
        //where do we get data
        fun bindItem(task:Task){
            itemBinding.tvTitle.text=task.title
            itemBinding.tvTime.text=task.timestamp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task=taskList[position]
        holder.bindItem(task)
    }
}