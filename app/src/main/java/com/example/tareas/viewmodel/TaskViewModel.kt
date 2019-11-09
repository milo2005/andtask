package com.example.tareas.viewmodel

import androidx.lifecycle.*
import com.example.tareas.data.db.model.Task
import com.example.tareas.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val repo: TaskRepository) : ViewModel() {

    private val filterControl: MutableLiveData<String> = MutableLiveData("")
    /*val data: LiveData<List<Task>> =
        Transformations.switchMap(filterControl) {name->
            liveData{
                val data = repo.all(name)
                emit(data)
            }
        }*/

    val data: LiveData<List<Task>> =
        Transformations.switchMap(filterControl) { repo.all(it)}

    fun add(task: Task) = viewModelScope.launch {
        repo.insert(task)
    }

    fun remove(task: Task) = viewModelScope.launch {
        repo.delete(task)
    }

    fun filter(name: String) {
        filterControl.value = name
    }

}