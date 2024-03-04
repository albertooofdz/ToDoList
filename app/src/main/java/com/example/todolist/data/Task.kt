package com.example.todolist.data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.todolist.utils.DatabaseHelper

class Task(var id: Int,var day:String, var task:String, var done: Boolean) {

    companion object{
        const val TABLE_NAME="Task"
        const val COLUMN_NAME_DAY="day"
        const val COLUMN_NAME_TASK="task"
        const val COLUMN_NAME_DONE ="done"
        val COLUMN_NAMES = arrayOf(
            DatabaseHelper.COLUMN_NAME_ID,
            COLUMN_NAME_TASK,
            COLUMN_NAME_DAY,
            COLUMN_NAME_DONE
        )
    }


    override fun toString(): String {
        return "$id -> Task: $task - $done"
    }
}

