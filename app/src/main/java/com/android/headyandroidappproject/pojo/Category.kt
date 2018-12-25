package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class Category(@SerializedName("name") val name: String = "",
                    @SerializedName("id") val id: Int,
                    @SerializedName("products") val products: List<ProductsItem>?)