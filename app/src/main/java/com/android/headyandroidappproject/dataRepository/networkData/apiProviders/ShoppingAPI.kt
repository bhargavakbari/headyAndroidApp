package com.android.headyandroidappproject.dataRepository.networkData.apiProviders

import com.android.headyandroidappproject.pojo.ShoppingData
import io.reactivex.Observable
import retrofit2.http.GET

interface ShoppingAPI {

    @GET("/json")
    fun getShoppingDataList(): Observable<ShoppingData>

}