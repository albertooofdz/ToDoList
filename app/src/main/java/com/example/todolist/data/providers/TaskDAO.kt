package com.example.todolist.data.providers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import com.example.todolist.data.Task
import com.example.todolist.utils.DatabaseHelper

class TaskDAO(val context: Context) {

    private var databaseManager: DatabaseHelper = DatabaseHelper(context)

    fun insert(task: Task){
        val db = databaseManager.writableDatabase
        //db.execSQL("INSERT INTO Task (task, done) VALUES ('Comprar leche', false)")

        var values = ContentValues()
        values.put(Task.COLUMN_NAME_TASK, task.task)
        values.put(Task.COLUMN_NAME_DONE, task.done)
        values.put(Task.COLUMN_NAME_DAY,task.day)

        var newRowId = db.insert(Task.TABLE_NAME, null, values)
        Log.i("DATABASE", "New record id: $newRowId")

        db.close()
    }


    fun update(task: Task) {
        val db = databaseManager.writableDatabase
        //db.execSQL("UPDATE Task SET task = 'Comprar leche', done = true WHERE id = 1")

        var values = ContentValues()
        values.put(Task.COLUMN_NAME_TASK, task.task)
        values.put(Task.COLUMN_NAME_DONE, task.done)
        values.put(Task.COLUMN_NAME_DAY,task.day)

        var updatedRows = db.update(Task.TABLE_NAME, values, "id =${task.id}", null)
        Log.i("DATABASE", "Updated records: $updatedRows")

        db.close()
    }

    fun delete() {
        val db = databaseManager.writableDatabase
        //db.execSQL("DELETE FROM Task WHERE id = 1")

        val deletedRows = db.delete(Task.TABLE_NAME, "id = 1", null)
        Log.i("DATABASE", "Deleted rows: $deletedRows")

        db.close()

    }

    @SuppressLint("Range")
    fun find(id:Int): Task? {


        val db = databaseManager.readableDatabase

        val cursor = db.query(
            Task.TABLE_NAME,                 // The table to query
            Task.COLUMN_NAMES,     // The array of columns to return (pass null to get all)
            "id=$id",                // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        var task:Task? = null


        if (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val taskName = cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_TASK))
            val day=cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_DAY))
            val done = cursor.getInt(cursor.getColumnIndex(Task.COLUMN_NAME_DONE)) == 1
            Log.i("DATABASE", "$id -> Task: $taskName, Done: $done")



            task=Task(id,day,taskName,done)
        }
        cursor.close()
        db.close()

        return task


    }

    @SuppressLint("Range")
    fun findAll(): List<Task> {

        val db = databaseManager.readableDatabase

        val cursor = db.query(
            Task.TABLE_NAME,                 // The table to query
            Task.COLUMN_NAMES,    // The array of columns to return (pass null to get all)
            null,                // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        var list: MutableList<Task> = mutableListOf()


        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val day=cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_DAY))
            val taskName = cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_TASK))
            val done = cursor.getInt(cursor.getColumnIndex(Task.COLUMN_NAME_DONE)) == 1
            Log.i("DATABASE", "$id -> Task: $taskName, Done: $done")

            val task: Task =Task(id,day ,taskName, done)

            list.add(task)
        }
        cursor.close()
        db.close()

        return list
    }

    @SuppressLint("Range")
    fun findAllByDay(day: String): List<Task> {

        val db = databaseManager.readableDatabase

        val cursor = db.query(
            Task.TABLE_NAME,                 // The table to query
            Task.COLUMN_NAMES,    // The array of columns to return (pass null to get all)
            "${Task.COLUMN_NAME_DAY} = '$day'",                // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        var list: MutableList<Task> = mutableListOf()


        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val day=cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_DAY))
            val taskName = cursor.getString(cursor.getColumnIndex(Task.COLUMN_NAME_TASK))
            val done = cursor.getInt(cursor.getColumnIndex(Task.COLUMN_NAME_DONE)) == 1
            Log.i("DATABASE", "$id -> Task: $taskName, Done: $done")

            val task: Task =Task(id,day ,taskName, done)

            list.add(task)
        }
        cursor.close()
        db.close()

        return list
    }

}
