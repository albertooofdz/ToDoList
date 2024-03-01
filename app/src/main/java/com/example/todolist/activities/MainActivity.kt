package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import com.example.todolist.R
import com.example.todolist.data.Task
import com.example.todolist.data.providers.TaskDAO
import com.example.todolist.utils.DatabaseHelper

class MainActivity : AppCompatActivity() {

    lateinit var lunes : LinearLayout
    lateinit var martes : LinearLayout
    lateinit var miercoles : LinearLayout
    lateinit var jueves : LinearLayout
    lateinit var viernes : LinearLayout
    lateinit var sabado : LinearLayout
    lateinit var domingo : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    fun initView(){

        lunes=findViewById(R.id.lunesBtn)
        martes=findViewById(R.id.martesBtn)
        miercoles=findViewById(R.id.miercolesBtn)
        jueves=findViewById(R.id.juevesBtn)
        viernes=findViewById(R.id.viernesBtn)
        sabado=findViewById(R.id.sabadoBtn)
        domingo=findViewById(R.id.domingoBtn)

        lunes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "lunes")

            startActivity(intent)

        }
        martes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "martes")

            startActivity(intent)

        }
        miercoles.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "miercoles")

            startActivity(intent)

        }
        jueves.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "jueves")

            startActivity(intent)

        }
        viernes.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "viernes")

            startActivity(intent)

        }
        sabado.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "sabado")

            startActivity(intent)

        }
        domingo.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            intent.putExtra("DAY", "domingo")

            startActivity(intent)

        }


    }
}



