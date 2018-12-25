package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class ShoppingData(@SerializedName("categories") val categories: List<Category>?,
                        @SerializedName("rankings") val rankings: List<Ranking>?)