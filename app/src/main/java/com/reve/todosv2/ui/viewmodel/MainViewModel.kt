package com.reve.todosv2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reve.todosv2.data.entity.ToDos
import com.reve.todosv2.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDosRepository: ToDosRepository) : ViewModel() {

    var toDosList = MutableLiveData<List<ToDos>>()

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.delete(id)
        }
    }

    fun loadToDos() {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.loadToDos()
        }
    }

    fun search(searchText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.search(searchText)
        }
    }
}