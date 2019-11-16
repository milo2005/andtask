package com.example.tareas.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tareas.R
import com.example.tareas.data.db.model.Task
import com.example.tareas.databinding.TemplateTaskBinding
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter: RecyclerView.Adapter<TaskHolder>(){

    var data:List<Task> =  emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    var onRemoveTask:((task:Task)->Unit)? = null

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.template_task, parent, false)
        return TaskHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) =
        holder.bind(data[position],dateFormat, this)

    fun removeTask(task:Task){
        onRemoveTask?.invoke(task)
    }

}

class TaskHolder(view:View):RecyclerView.ViewHolder(view){

    private val binding:TemplateTaskBinding = TemplateTaskBinding.bind(view)

    fun bind(task: Task,format:SimpleDateFormat, handler:TaskAdapter ){
        binding.task = task
        binding.dateFormat = format
        binding.handler = handler
    }

}