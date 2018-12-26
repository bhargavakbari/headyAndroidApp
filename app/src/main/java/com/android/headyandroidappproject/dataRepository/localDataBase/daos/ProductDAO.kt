package com.android.headyandroidappproject.dataRepository.localDataBase.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductEntity

@Dao
interface ProductDAO {

    @Query("SELECT * FROM Product")
    fun getAllProduct(): LiveData<List<ProductEntity>>

    @Insert
    fun insertAllProduct(products: List<ProductEntity>)

    @Query("DELETE FROM Product")
    fun nukeTable()

}