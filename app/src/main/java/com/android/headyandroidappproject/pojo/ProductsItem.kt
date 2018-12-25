package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class ProductsItem(@SerializedName("date_added") val dateAdded: String,
                        @SerializedName("name") val name: String,
                        @SerializedName("tax") val tax: Tax,
                        @SerializedName("id") val id: Int = 0,
                        @SerializedName("variants") val variants: List<VariantsItem>?)