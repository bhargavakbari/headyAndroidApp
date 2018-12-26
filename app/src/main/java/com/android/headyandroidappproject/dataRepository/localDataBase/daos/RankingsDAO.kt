package com.android.headyandroidappproject.dataRepository.localDataBase.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.RankingEntity

@Dao
interface RankingsDAO {

    @Query("SELECT * FROM Rankings")
    fun getAllRankingItems(): LiveData<List<RankingEntity>>

    @Insert
    fun insertAllRankingItems(variants: List<RankingEntity>)

    @Query("DELETE FROM Rankings")
    fun nukeTable()

}