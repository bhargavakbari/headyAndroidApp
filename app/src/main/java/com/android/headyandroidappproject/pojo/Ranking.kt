package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class Ranking(@SerializedName("ranking") val ranking: String = "",
                   @SerializedName("products") val products: List<Product>?)