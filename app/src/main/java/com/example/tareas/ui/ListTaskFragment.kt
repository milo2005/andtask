package com.example.tareas.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.tareas.R
import com.example.tareas.ui.adapter.TaskAdapter
import com.example.tareas.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_list_task.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ListTaskFragment : Fragment() {

    val vm: TaskViewModel by sharedViewModel()
    val adapter: TaskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_task, container, false)
    }

    override fun onResume() {
        super.onResume()

        list.adapter = adapter

        adapter.onRemoveTask = { vm.remove(it) }

        btnAdd.setOnClickListener {
            val action = ListTaskFragmentDirections
                .actionListTaskFragmentToAddTaskFragment()
            findNavController().navigate(action)
        }

        vm.data.observe(this, Observer { adapter.data = it })

    }


}
