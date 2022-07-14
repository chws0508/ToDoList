package com.example.todolist.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import com.example.todolist.R
import com.example.todolist.databinding.ItemDaycardBinding
import com.example.todolist.model.ToDoList
import com.example.todolist.ui.main.MainActivity
import com.example.todolist.ui.main.MainViewModel


class DayCardAdapter(
    private val viewModel: MainViewModel,
    private val context: Context
) : RecyclerView.Adapter<DayCardAdapter.DayCardViewHolder>() {

    lateinit var activity:MainActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemDaycardBinding>(
            layoutInflater,
            R.layout.item_daycard,
            parent,
            false
        )
        return DayCardViewHolder(binding)
    }

    //각 Item마다 bind가 호출되어 list의 position 번째에 있는 값을 보여준다.
    override fun onBindViewHolder(holder: DayCardViewHolder, position: Int) {
        viewModel.listToDoList.value?.get(position)?.let { holder.bind(it) }
        holder.binding.card.setOnClickListener{
            holder.binding.card.isChecked = !holder.binding.card.isChecked
            holder.binding.data?.complete=!holder.binding.data?.complete!!
            viewModel.updateToDo(holder.binding.data!!)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.listToDoList.value?.size!!
    }


    inner class DayCardViewHolder(val binding: ItemDaycardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ToDoList) {
            binding.data = data
            binding.executePendingBindings()
        }
    }


}
