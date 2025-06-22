package com.reve.todosv2.data.datasource

import com.reve.todosv2.data.entity.ToDos
import com.reve.todosv2.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {
    suspend fun save(name: String) {
        val todos = ToDos(0, name)
        toDosDao.save(todos)
    }

    suspend fun update(id: Int, name: String) = toDosDao.update(id, name)

    suspend fun delete(id: Int) {
        val todo = ToDos(id, "")
        toDosDao.delete(todo)
    }

    suspend fun loadToDos(): List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.loadToDos()
    }

    suspend fun search(searchText: String): List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.search(searchText)
    }

}