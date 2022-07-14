package com.example.todolist.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.ToDoList
import com.example.todolist.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
private val mainRepository: MainRepository,
private val dispatcherIO: CoroutineDispatcher
):ViewModel(){
    var listToDoList = MutableLiveData<List<ToDoList>>()

    init{
        getAllToDoList()
    }

    fun getAllToDoList():MutableLiveData<List<ToDoList>>{
        viewModelScope.launch {
            withContext(dispatcherIO) {
                listToDoList.postValue(mainRepository.getAllToDoList())
                Log.d("하윙",mainRepository.getAllToDoList().toString())
            }
            Log.d("하윙",listToDoList.value.toString())
        }
        return listToDoList
    }

    fun deleteAllToDoList(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.deleteAllToDoList()
        }
        getAllToDoList()
    }

    fun updateToDo(toDoList: ToDoList){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.updateToDo(toDoList)
        }
    }

    fun makeToDoListInstance(date: String, title: String, content: String): ToDoList {
        return ToDoList(date, title, content,false)
    }

    fun deleteCompletedLists(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.deleteCompletedLists()
        }
        getAllToDoList()
    }



//    fun getAllTitle:MutableLiveData<String>




}
