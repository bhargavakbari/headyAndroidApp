package com.android.headyandroidappproject.dataRepository.localDataBase.dataBase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.android.headyandroidappproject.dataRepository.localDataBase.daos.*
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.*


@Database(entities = [CategoryEntity::class, ProductEntity::class, ProductViewEntity::class,
    RankingEntity::class, VariantsEntity::class], version = 6, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {


    companion object {
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
            return Room.databaseBuilder(context, AppDataBase::class.java!!, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }


    abstract fun getCategoryDao(): CategoryDAO
    abstract fun getProductDao(): ProductDAO
    abstract fun getVariantDao(): VariantDAO
    abstract fun getRankingsDao(): RankingsDAO
    abstract fun getRankingProductDao(): ProductViewDAO

}