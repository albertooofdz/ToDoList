package com.example.todolist.data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.todolist.utils.DatabaseHelper

class Task(var id: Int, var task:String, var done: Boolean) {

    override fun toString(): String {
        return "$id -> Task: $task - $done"
    }
}

