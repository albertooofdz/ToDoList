package com.example.todolist.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.toDoAdapter
import com.example.todolist.data.Task
import com.example.todolist.data.providers.TaskDAO
import com.example.todolist.utils.DatabaseHelper

class MainActivity : AppCompatActivity() {
    lateinit var lunes : LinearLayout
    lateinit var lunesPendingTask : TextView
    lateinit var martes : LinearLayout
    lateinit var martesPendingTask : TextView
    lateinit var miercoles : LinearLayout
    lateinit var miercolesPendingTask : TextView
    lateinit var jueves : LinearLayout
    lateinit var juevesPendingTask : TextView
    lateinit var viernes : LinearLayout
    lateinit var viernesPendingTask : TextView
    lateinit var sabado : LinearLayout
    lateinit var sabadoPendingTask : TextView
    lateinit var domingo : LinearLayout
    lateinit var domingoPendingTask : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    override fun onResume() {
        super.onResume()
        lunesPendingTask.text = TaskDAO(this).countByDayAndDone("Lunes").toString()
        martesPendingTask.text = TaskDAO(this).countByDayAndDone("Martes").toString()
        miercolesPendingTask.text = TaskDAO(this).countByDayAndDone("Miercoles").toString()
        juevesPendingTask.text = TaskDAO(this).countByDayAndDone("Jueves").toString()
        viernesPendingTask.text = TaskDAO(this).countByDayAndDone("Viernes").toString()
        sabadoPendingTask.text = TaskDAO(this).countByDayAndDone("Sabado").toString()
        domingoPendingTask.text = TaskDAO(this).countByDayAndDone("Domingo").toString()

    }

    fun initView(){

        lunes=findViewById(R.id.lunesBtn)
        lunesPendingTask=findViewById(R.id.lunesTextView)
        martesPendingTask=findViewById(R.id.martesTextView)
        miercolesPendingTask=findViewById(R.id.miercolesTextView)
        juevesPendingTask=findViewById(R.id.juevesTextView)
        viernesPendingTask=findViewById(R.id.viernesTextView)
        sabadoPendingTask=findViewById(R.id.sabadoTextView)
        domingoPendingTask=findViewById(R.id.domingoTextView)
        martes=findViewById(R.id.martesBtn)
        miercoles=findViewById(R.id.miercolesBtn)
        jueves=findViewById(R.id.juevesBtn)
        viernes=findViewById(R.id.viernesBtn)
        sabado=findViewById(R.id.sabadoBtn)
        domingo=findViewById(R.id.domingoBtn)

        lunes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Lunes")

            startActivity(intent)

        }
        martes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Martes")

            startActivity(intent)

        }
        miercoles.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Miercoles")

            startActivity(intent)

        }
        jueves.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Jueves")

            startActivity(intent)

        }
        viernes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Viernes")

            startActivity(intent)

        }
        sabado.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Sabado")

            startActivity(intent)

        }
        domingo.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "Domingo")

            startActivity(intent)

        }


    }
}



