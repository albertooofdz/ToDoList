package com.example.todolist.data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.todolist.utils.DatabaseHelper

class Task(var id: Int, var task:String, var done: Boolean) {

    companion object{
        const val TABLE_NAME="Task"
        const val COLUMN_NAME_TASK="task"
        const val COLUMN_NAME_DONE ="Done"
        val COLUMN_NAMES = arrayOf(
            DatabaseHelper.COLUMN_NAME_ID,
            COLUMN_NAME_TASK,
            TABLE_NAME
        )
    }


    override fun toString(): String {
        return "$id -> Task: $task - $done"
    }
}

