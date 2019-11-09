package com.example.tareas.data.repository

import com.example.tareas.data.db.dao.TaskDao
import com.example.tareas.data.db.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(private val dao:TaskDao) {

    suspend fun insert(task: Task) = withContext(Dispatchers.IO){
        dao.insert(task)
    }

    suspend fun delete(task:Task) = withContext(Dispatchers.IO){
        dao.delete(task)
    }

    suspend fun all(name:String?) = withContext(Dispatchers.IO){
        if(name!=null && name!= "") dao.allByTitle(name)
        else dao.all()
    }
}