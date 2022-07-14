package com.example.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ToDoList(
    var date: String?,
    var title:String?,
    var content:String?,
    var complete:Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
