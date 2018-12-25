package com.android.headyandroidappproject.dataRepository.networkDataRepository.dataProviders

import com.android.headyandroidappproject.AppController
import com.android.headyandroidappproject.dataRepository.networkDataRepository.apiProviders.ShoppingAPI
import com.android.headyandroidappproject.pojo.Category
import io.reactivex.Observable

class ShoppingApiDataModel {

    fun getAllShoppingDataList(): Observable<List<Category>> {
        val retrofit = AppController.getApplicationInstance().getRetrofitClient()
        val shoppingApi = retrofit.create(ShoppingAPI::class.java)
        return shoppingApi.getShoppingDataList()
    }
}