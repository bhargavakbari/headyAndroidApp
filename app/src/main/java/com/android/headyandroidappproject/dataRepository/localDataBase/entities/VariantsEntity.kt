package com.android.headyandroidappproject.dataRepository.localDataBase.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Variants")
data class VariantsEntity(@PrimaryKey @ColumnInfo(name = "variant_id") val variantId: Int,
                    val productId: Int,
                    val color: String,
                    val size: Int?,
                    val price: Double)