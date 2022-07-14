package com.example.todolist.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.model.ToDoList

@Database(entities = [ToDoList::class], version = 3)
abstract class AppDataBase : RoomDatabase() {
    abstract fun toDoListDao() : ToDoListDao

}