package com.android.headyandroidappproject.dataRepository.localDataBase.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Product")
data class ProductEntity(
        @PrimaryKey @ColumnInfo(name = "product_id") val productId: Int,
        val catId: Int,
        val dateAdded: String,
        var productName: String,
        var taxName: String,
        var taxValue: Double)