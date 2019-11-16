package com.example.tareas.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.tareas.R
import com.example.tareas.data.db.model.Task
import com.example.tareas.util.text
import com.example.tareas.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_add_task.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddTaskFragment : Fragment() {

    val vm: TaskViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onResume() {
        super.onResume()

        btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
        btnAdd.setOnClickListener {
            vm.add(
                Task(
                    null,
                    inputTitle.text(),
                    inputDescription.text(),
                    Date(),
                    emptyList()
                )
            )
            findNavController().popBackStack()
        }
    }


}
