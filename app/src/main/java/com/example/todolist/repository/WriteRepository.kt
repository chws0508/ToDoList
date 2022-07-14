package com.example.todolist.repository

import com.example.todolist.model.ToDoList
import com.example.todolist.persistence.ToDoListDao
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class WriteRepository @Inject constructor(
    private val toDoListDao: ToDoListDao,
    private val ioDispatcher: CoroutineDispatcher
):Repository {

    suspend fun insertToDoList(toDoList_:ToDoList){
        toDoListDao.insertToDoList(toDoList_)
    }

}