package com.example.todolist.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.toDoAdapter
import com.example.todolist.data.Task
import com.example.todolist.data.providers.TaskDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {

    lateinit var taskList:  MutableList<Task>
    lateinit var adapter: toDoAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var taskDAO:TaskDAO
    lateinit var addTaskBtn:FloatingActionButton


    lateinit var day: String

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        day = intent.getStringExtra("DAY")!!

        taskDAO=TaskDAO(this)

        //taskDAO.insert(Task(-1, "Lunes", "Comprar leche", false))


        taskList = taskDAO.findAllByDay(day).toMutableList()

        Log.i("DetailActivity", "El dia que ha seleccionado es $day ")
        checkDay()

    }

    fun checkDay(){
        recyclerView=findViewById(R.id.recyclerView)
        //doneCB=findViewById(R.id.doneCB)
        //taskTV=findViewById(R.id.taskTV)
        addTaskBtn=findViewById(R.id.addTaskBtn)

        adapter = toDoAdapter(taskList, {
            onItemClickListener(it)
        }, {
            onRemoveListener(it)
        })
        addTaskBtn.setOnClickListener {

            onCreateDialog()


        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter=adapter
}



    private fun onItemClickListener(position:Int) {
        val task: Task = taskList[position]


        startActivity(intent)
        //Toast.makeText(this, getString(horoscope.name), Toast.LENGTH_LONG).show()
    }
   private fun onCreateDialog() {
       val builder = AlertDialog.Builder(this)

       // Inflate and set the layout for the dialog.
       // Pass null as the parent view because it's going in the dialog
       builder.setTitle("Nueva tarea")
       // layout.
       builder.setView(R.layout.add_task)
       // Add action buttons.
       builder.setPositiveButton("Crear") { dialog, id ->
           val taskName = (dialog as AlertDialog).findViewById<EditText>(R.id.taskEditText)?.text.toString()
           taskDAO.insert(Task(-1, day, taskName,false))
           taskList = taskDAO.findAllByDay(day).toMutableList()
           adapter.updateData(taskList)

           dialog.cancel()
       }
       builder.setNegativeButton("Cancel") { dialog, id ->
           dialog.cancel()
       }
       val alertDialog = builder.create()
       alertDialog.show()
    }

    private fun onRemoveListener(position:Int){
        val task:Task = taskList[position]
        taskDAO.delete(task)
        taskList.removeAt(position)
        adapter.notifyDataSetChanged()
    }


}