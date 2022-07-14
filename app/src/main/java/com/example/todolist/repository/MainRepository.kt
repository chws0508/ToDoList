package com.example.todolist.repository

import androidx.annotation.WorkerThread
import com.example.todolist.model.ToDoList
import com.example.todolist.persistence.ToDoListDao
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val toDoListDao: ToDoListDao
):Repository {


    suspend fun getAllToDoList():List<ToDoList>{
        return toDoListDao.getAllToDoList()
    }

    suspend fun deleteAllToDoList(){
        toDoListDao.deleteAll()
    }

    suspend fun deleteCompletedLists(){
        toDoListDao.deleteCompletedLists()
    }

    suspend fun updateToDo(toDoList: ToDoList){
        toDoListDao.updateToDo(toDoList)
    }

}