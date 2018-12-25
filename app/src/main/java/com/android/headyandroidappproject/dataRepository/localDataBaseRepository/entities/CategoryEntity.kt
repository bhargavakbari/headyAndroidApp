package com.android.headyandroidappproject.dataRepository.localDataBaseRepository.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Category")
data class CategoryEntity(
        @PrimaryKey @ColumnInfo(name = "cat_id") val CatId: Int,
        var categoryName: String) {

    override fun toString(): String {
        return "CategoryEntity(CatId=$CatId, categoryName='$categoryName')"
    }
}