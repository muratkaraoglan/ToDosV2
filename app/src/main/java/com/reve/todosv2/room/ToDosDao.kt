package com.reve.todosv2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.reve.todosv2.data.entity.ToDos

@Dao
interface ToDosDao {
    @Query("Select * from todos")
    suspend fun loadToDos(): List<ToDos>

    @Insert
    suspend fun save(toDos: ToDos)

    @Query("Update todos set name = :name where id = :id")
    suspend fun update(id: Int, name: String)

    @Delete
    suspend fun delete(toDos: ToDos)

    @Query("Select * from todos where name like '%' || :searchText|| '%'")
    suspend fun search(searchText: String): List<ToDos>
}