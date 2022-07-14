package com.example.todolist.ui.wrtie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.ToDoList
import com.example.todolist.repository.MainRepository
import com.example.todolist.repository.WriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val writeRepository: WriteRepository
) : ViewModel() {

    lateinit var date: String
    lateinit var title: String
    lateinit var content: String



    fun makeToDoListInstance(date: String, title: String, content: String): ToDoList {
        return ToDoList(date, title, content,false)
    }

    fun insertToDoList(toDoList: ToDoList) {
        viewModelScope.launch(Dispatchers.IO) {
            writeRepository.insertToDoList(toDoList)
        }
    }


}