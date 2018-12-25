package com.android.headyandroidappproject.dataRepository.localDataBase.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category")
    fun getAllCategory(): LiveData<List<CategoryEntity>>

    @Insert
    fun insert(category: List<CategoryEntity>)

    @Query("DELETE FROM Category")
    fun nukeTable()

}