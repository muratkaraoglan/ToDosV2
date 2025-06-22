package com.reve.todosv2.di

import android.content.Context
import androidx.room.Room
import com.reve.todosv2.data.datasource.ToDosDataSource
import com.reve.todosv2.data.repo.ToDosRepository
import com.reve.todosv2.room.MyDatabase
import com.reve.todosv2.room.ToDosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesToDosRepository(toDosDataSource: ToDosDataSource): ToDosRepository {
        return ToDosRepository(toDosDataSource)
    }

    @Provides
    @Singleton
    fun providesToDosDataSource(toDosDao: ToDosDao) : ToDosDataSource {
        return ToDosDataSource(toDosDao)
    }

    @Provides
    @Singleton
    fun providesToDosDao(@ApplicationContext context: Context): ToDosDao {
        val db = Room.databaseBuilder(context,MyDatabase::class.java,"ToDo_DB.sqlite")
            .createFromAsset("ToDo_DB.sqlite")
            .build()
        return db.getToDosDao()
    }
}