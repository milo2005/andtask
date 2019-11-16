package com.example.tareas.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun <T, R>MutableLiveData<T>.switchMap(func:(data:T)->LiveData<R>) =
    Transformations
    .map(this, func)