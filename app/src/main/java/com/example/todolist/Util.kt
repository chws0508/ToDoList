package com.example.todolist

import java.text.SimpleDateFormat
import java.util.*

object Util {
    fun getToday_YearMonthDay():String{
        val format_yyyyMMdd = "yyyy년 MM월 dd일"
        var format: SimpleDateFormat = SimpleDateFormat(format_yyyyMMdd, Locale.getDefault())
        val now: Long = System.currentTimeMillis()
        val date: Date =  Date(now)
        return format.format(date)
    }
}