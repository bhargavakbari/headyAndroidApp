package com.android.headyandroidappproject.dataRepository.localDataBaseRepository.dataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.android.headyandroidappproject.dataRepository.localDataBaseRepository.daos.CategoryDAO
import com.android.headyandroidappproject.dataRepository.localDataBaseRepository.entities.CategoryEntity


@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    private val DB_NAME = "headyLocalDatabase.db"
    @Volatile
    private var instance: AppDataBase? = null

    @Synchronized
    fun getInstance(context: Context): AppDataBase? {
        if (instance == null) {
            instance = create(context)
        }
        return instance
    }

    private fun create(context: Context): AppDataBase {
        return Room.databaseBuilder(
                context,
                AppDataBase::class.java!!,
                DB_NAME).build()
    }

    abstract fun getCategoryDao(): CategoryDAO

}