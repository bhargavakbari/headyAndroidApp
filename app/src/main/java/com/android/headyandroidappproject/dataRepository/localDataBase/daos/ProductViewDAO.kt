package com.android.headyandroidappproject.dataRepository.localDataBase.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductViewEntity

@Dao
interface ProductViewDAO {

    @Query("SELECT * FROM ProductView")
    fun getAllRankingProduct(): LiveData<List<ProductViewEntity>>

    @Insert
    fun insertAllRankingProduct(products: List<ProductViewEntity>)

    @Query("DELETE FROM ProductView")
    fun nukeTable()
}