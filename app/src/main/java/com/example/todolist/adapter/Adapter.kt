package com.example.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Task

class toDoAdapter(var items:List<Task> = listOf(), val onClickListener: (position:Int)-> Unit)
    : RecyclerView.Adapter<TaskViewHolder>() {

    fun updateData(list :List<Task>) {
        this.items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(items[position])
        holder.itemView.setOnClickListener{onClickListener(position)}


    }


}
class TaskViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val doneCB: CheckBox = view.findViewById(R.id.doneCB)
    val taskTV: TextView = view.findViewById(R.id.taskTV)
    fun render(task: Task) {
        val context: Context = itemView.context
        taskTV.text= task.task
        doneCB.isChecked=task.done


    }

}