package com.example.tareas.data.db.dao

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
    suspend fun all():List<Task>

    @Query("SELECT * FROM task WHERE title LIKE :title")
    suspend fun allByTitle(title:String)

}