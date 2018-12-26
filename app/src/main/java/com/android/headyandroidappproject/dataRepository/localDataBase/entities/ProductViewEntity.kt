package com.android.headyandroidappproject.dataRepository.localDataBase.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "ProductView")
class ProductViewEntity(var productViewId: Int, var viewCount: Int, var orderCount: Int, var sharesCount: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}