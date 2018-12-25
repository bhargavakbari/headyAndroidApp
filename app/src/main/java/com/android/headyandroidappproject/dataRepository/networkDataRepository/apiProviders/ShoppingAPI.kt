package com.android.headyandroidappproject.dataRepository.networkDataRepository.apiProviders

import com.android.headyandroidappproject.pojo.Category
import io.reactivex.Observable
import retrofit2.http.GET

interface ShoppingAPI {

    @GET("https://stark-spire-93433.herokuapp.com/json")
    fun getShoppingDataList(): Observable<List<Category>>

}