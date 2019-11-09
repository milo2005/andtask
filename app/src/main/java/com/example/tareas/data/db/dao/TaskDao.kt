package com.example.tareas.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tareas.data.db.model.Task

@Dao
interface TaskDao{

    @Insert
    suspend fun insert(task: Task)

    @Insert
    suspend fun insertMany(tasks:List<Task>)

    @Update
    suspend fun update(task:Task)

    @Delete
    suspend fun delete(task:Task)

    @Query("SELECT * FROM task WHERE id = :id")
    suspend fun byId(id:Long):Task

    @Query("SELECT * FROM task ORDER BY date DESC")
    fun all(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE title LIKE :title")
    fun allByTitle(title:String):LiveData<List<Task>>

}