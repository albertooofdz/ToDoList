package com.example.todolist.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.toDoAdapter
import com.example.todolist.data.Task
import com.example.todolist.data.providers.TaskDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {
    lateinit var doneCB: CheckBox
    lateinit var taskTV:TextView
    lateinit var taskList: List<Task>
    lateinit var adapter: toDoAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var taskDAO:TaskDAO
    lateinit var addTaskBtn:FloatingActionButton

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var day = intent.getStringExtra("DAY")!!

        taskDAO=TaskDAO(this)

        //taskDAO.insert(Task(-1, "Lunes", "Comprar leche", false))


        taskList = taskDAO.findAllByDay(day)

        Log.i("DetailActivity", "El dia que ha seleccionado es $day ")
        checkDay(day)

    }

    fun checkDay(day:String){
        recyclerView=findViewById(R.id.recyclerView)
        //doneCB=findViewById(R.id.doneCB)
        //taskTV=findViewById(R.id.taskTV)
        addTaskBtn=findViewById(R.id.addTaskBtn)

        adapter = toDoAdapter(taskList) {
            onItemClickListener(it)
        }
        addTaskBtn.setOnClickListener{
            taskDAO.insert(Task(-1, day,"dasdas",false))
            taskList = taskDAO.findAllByDay(day)
            adapter.updateData(taskList)
        }


        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter=adapter
}
    private fun onItemClickListener(position:Int) {
        val task: Task = taskList[position]


        startActivity(intent)
        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()
    }




}