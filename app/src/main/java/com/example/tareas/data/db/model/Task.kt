package com.example.tareas.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Task (
    @PrimaryKey(autoGenerate = true) var id:Long?,
    val title:String,
    val description:String,
    val date: Date,
    var tags:List<String>
    )