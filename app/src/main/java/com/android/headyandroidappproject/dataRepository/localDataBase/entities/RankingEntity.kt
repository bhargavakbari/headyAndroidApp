package com.android.headyandroidappproject.dataRepository.localDataBase.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Rankings")
class RankingEntity(val rankingName: String, val productIds: String) {
    @PrimaryKey(autoGenerate = true)
    var key: Int = 0
}