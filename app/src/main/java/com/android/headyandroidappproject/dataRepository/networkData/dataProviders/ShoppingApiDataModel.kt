package com.android.headyandroidappproject.dataRepository.networkData.dataProviders

import com.android.headyandroidappproject.AppController
import com.android.headyandroidappproject.dataRepository.networkData.apiProviders.ShoppingAPI
import com.android.headyandroidappproject.pojo.ShoppingData
import io.reactivex.Observable

class ShoppingApiDataModel {

    fun getAllShoppingDataList(): Observable<ShoppingData> {
        val retrofit = AppController.getApplicationInstance().getRetrofitClient()
        val shoppingApi = retrofit.create(ShoppingAPI::class.java)
        return shoppingApi.getShoppingDataList()
    }
}