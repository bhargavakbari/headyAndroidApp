package com.android.headyandroidappproject.dataRepository.localDataBase.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.VariantsEntity

@Dao
interface VariantDAO {

    @Query("SELECT * FROM Variants")
    fun getAllVariants(): LiveData<List<VariantsEntity>>

    @Query("SELECT * FROM Variants where productId = :prodId")
    fun getAllVariantsForParticularProduct(prodId: Int): LiveData<List<VariantsEntity>>

    @Insert
    fun insertAllVariants(variants: List<VariantsEntity>)

    @Query("DELETE FROM Variants")
    fun nukeTable()

}