package com.example.tareas.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.android.material.textfield.TextInputLayout

fun <T, R>MutableLiveData<T>.switchMap(func:(data:T)->LiveData<R>) =
    Transformations
    .map(this, func)

fun TextInputLayout.text():String = editText?.text.toString()