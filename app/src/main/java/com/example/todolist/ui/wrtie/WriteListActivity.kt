package com.example.todolist.ui.wrtie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.todolist.R
import com.example.todolist.databinding.ActivityWriteListBinding
import androidx.activity.viewModels
import com.example.todolist.Util
import com.example.todolist.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteListActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityWriteListBinding
    private val viewModel: WriteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_list)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.floatingActionButton.setOnClickListener(){
            if (TextUtils.isEmpty(binding.titleEditText.text.toString())
                or TextUtils.isEmpty(binding.contentEditText.text.toString())
            )
                Toast.makeText(this, "내용이나 이름을 입력해주세요", Toast.LENGTH_LONG)
            else
            {
                viewModel.title = binding.titleEditText.text.toString()
                viewModel.content= binding.contentEditText.text.toString()
                viewModel.date= Util.getToday_YearMonthDay()
                viewModel.insertToDoList(viewModel.makeToDoListInstance(viewModel.date,viewModel.title,viewModel.content))
                intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }

    }
}