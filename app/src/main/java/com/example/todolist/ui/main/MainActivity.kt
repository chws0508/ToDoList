package com.example.todolist.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.ui.adapter.DayCardAdapter
import com.example.todolist.ui.wrtie.WriteListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        viewModel.listToDoList.observe(this){
            initRecyclerView()
        }

        binding.floatingActionButton.setOnClickListener{
            intent=Intent(this, WriteListActivity::class.java)
            startActivity(intent)
        }
    }

    fun initRecyclerView(){
        binding.dayCardRecyclerView.adapter=DayCardAdapter(viewModel, this)
        binding.dayCardRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false )
    }

    fun deleteButtonClick(item: MenuItem) {
    viewModel.deleteAllToDoList()
    }
}