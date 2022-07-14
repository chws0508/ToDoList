package com.example.todolist.di

import android.app.Application
import androidx.room.Room
import com.example.todolist.persistence.AppDataBase
import com.example.todolist.persistence.ToDoListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDataBase {
        return Room
            .databaseBuilder(
                application,
                AppDataBase::class.java,
                "toDoListDB"
            ).fallbackToDestructiveMigration()//데이터베이스 고쳐도 오류 안나게하는거
            .build()
    }


    @Provides
    @Singleton
    fun provideToDoListDao(appDataBase: AppDataBase): ToDoListDao {
        return appDataBase.toDoListDao()
    }
}