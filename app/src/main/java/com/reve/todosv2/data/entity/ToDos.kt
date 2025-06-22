package com.reve.todosv2.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("todos")
data class ToDos(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") @NotNull var id: Int,
    @ColumnInfo("name") @NotNull var name: String

) : Serializable
