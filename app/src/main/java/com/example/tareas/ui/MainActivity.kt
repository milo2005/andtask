package com.example.tareas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tareas.R
import com.example.tareas.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val vm:TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = findNavController(R.id.navHost)
        val config = AppBarConfiguration(controller.graph)
        setupActionBarWithNavController(controller, config)
    }


    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.navHost)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }

}
