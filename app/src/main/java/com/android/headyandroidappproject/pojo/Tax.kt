package com.android.headyandroidappproject.pojo

import com.google.gson.annotations.SerializedName

data class Tax(@SerializedName("name")
               val name: String,
               @SerializedName("value")
               val value: Double = 0.0)