package com.example.todolist.persistence

import androidx.room.*
import com.example.todolist.model.ToDoList

@Dao
interface ToDoListDao {
    @Insert
    suspend fun insertToDoList(toDoList: ToDoList)

    @Query("SELECT * FROM  todolist")
    suspend fun getAllToDoList():List<ToDoList>

    @Query("DELETE FROM todolist")
    suspend fun deleteAll()

    @Query("DELETE FROM todolist WHERE complete = 1 ")
    suspend fun deleteCompletedLists()

    @Update
    suspend fun updateToDo(toDoList: ToDoList)
}