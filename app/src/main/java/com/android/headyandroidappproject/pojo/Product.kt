package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class Product(@SerializedName("id") val id: Int,
                   @SerializedName("view_count") val viewCount: Int = 0,
                   @SerializedName("order_count") val orderCount: Int = 0,
                   @SerializedName("shares") val sharesCount: Int = 0)