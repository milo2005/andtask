package com.example.tareas.data.db.dao

import androidx.room.*
import com.example.tareas.data.db.model.Task

@Dao
interface TaskDao{

    @Insert
    fun insert(task: Task)

    @Insert
    fun insertMany(tasks:List<Task>)

    @Update
    fun update(task:Task)

    @Delete
    fun delete(task:Task)

    @Query("SELECT * FROM task WHERE id = :id")
    fun byId(id:Long):Task

    @Query("SELECT * FROM task ORDER BY date DESC")
    fun all():List<Task>

    @Query("SELECT * FROM task WHERE title LIKE :title")
    fun allByTitle(title:String)

}