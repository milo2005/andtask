package com.example.tareas.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tareas.data.db.AppDatabase
import com.example.tareas.data.repository.TaskRepository
import com.example.tareas.viewmodel.TaskViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single{
        Room.databaseBuilder(androidApplication(),
            AppDatabase::class.java,
            "tasks.db")
            .build()
    }

    single{ get<AppDatabase>().taskDao() }
    single { TaskRepository(get()) }
    viewModel { TaskViewModel(get()) }

}