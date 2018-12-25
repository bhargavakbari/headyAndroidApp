package com.android.headyandroidappproject.dataRepository.localDataBaseRepository.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBaseRepository.entities.CategoryEntity

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getAllRepos(): List<CategoryEntity>

    @Insert
    fun insert(vararg category: CategoryEntity)

}