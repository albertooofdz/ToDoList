package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todolist.R
import com.example.todolist.data.Task
import com.example.todolist.data.providers.TaskDAO
import com.example.todolist.utils.DatabaseHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task: Task =Task (-1,"Comprar pan",false)



        val taskDAO=TaskDAO(this)
        taskDAO.insert(task)

        val taskList=taskDAO.findAll()

        for (task in taskList){
            Log.i("DATABASE",task.toString())
        }

        var task2:Task? = taskDAO.find(2)!!

        if (task2 !=null) {

            Log.i("DATABASE",task2.toString())
        }



    }
}

