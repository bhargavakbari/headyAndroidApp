package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class VariantsItem(@SerializedName("color") val color: String = "",
                        @SerializedName("size") val size: Int,
                        @SerializedName("price") val price: Double,
                        @SerializedName("id") val id: Int)