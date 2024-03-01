package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todolist.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    var day =intent.getStringExtra("DAY")

        Log.i("DetailActivity", "El dia que ha seleccionado es $day ")
        checkDay(day!!)

    }

    fun checkDay(day:String){
        if (day=="Lunes"){

        }


    }
}