package com.example.tareas.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:dateValue", "app:dateFormat")
fun dateToString(txt:TextView,date:Date, dateFormat:SimpleDateFormat){
    txt.text = dateFormat.format(date)
}

@BindingAdapter("app:imgRes")
fun imgFromResource(img:ImageView, res:Int){
    //
}