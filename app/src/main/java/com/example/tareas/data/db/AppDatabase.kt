package com.example.tareas.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.tareas.data.db.dao.TaskDao
import com.example.tareas.data.db.model.Task
import java.util.*

class Converters{
    @TypeConverter
    fun dateToLong(date: Date) = date.time
    @TypeConverter
    fun longToDate(milis:Long) = Date(milis)

    @TypeConverter
    fun listToString(list:List<String>) = list.joinToString { "," }
    @TypeConverter
    fun stringToList(value:String) = value.split(",")
}

@Database(version = 1, entities = [Task::class])
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}