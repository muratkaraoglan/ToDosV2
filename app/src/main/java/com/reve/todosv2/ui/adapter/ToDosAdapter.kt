package com.reve.todosv2.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.reve.todosv2.data.entity.ToDos
import com.reve.todosv2.databinding.CardDesignBinding
import com.reve.todosv2.ui.screens.MainScreenDirections
import com.reve.todosv2.ui.viewmodel.MainViewModel

class ToDosAdapter(var mContext: Context, var todoList: List<ToDos>, var viewModel: MainViewModel) :
    RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val todo = todoList.get(position)
        val design = holder.binding

        design.textViewName.text = todo.name

        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "Do you want to delete ${todo.name}?", Snackbar.LENGTH_SHORT)
                .setAction("Yes") {
                    viewModel.delete(todo.id)
                }.show()
        }

        design.cardViewToDo.setOnClickListener {
            val toUpdateScreen = MainScreenDirections.toUpdateScreen(toDo =  todo)
            it.findNavController().navigate(toUpdateScreen)
        }
    }
}