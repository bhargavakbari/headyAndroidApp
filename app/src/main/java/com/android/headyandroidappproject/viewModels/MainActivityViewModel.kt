package com.android.headyandroidappproject.viewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.android.headyandroidappproject.dataRepository.networkDataRepository.dataProviders.ShoppingApiDataModel
import com.android.headyandroidappproject.pojo.ShoppingData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class MainActivityViewModel : ViewModel {

    private val TAG = "MainActivityViewModel"
    private var compositeDisposable: CompositeDisposable
    private var mShoppingApiDataModel: ShoppingApiDataModel;
    private var shoppingData: MutableLiveData<ShoppingData> = MutableLiveData();

    constructor() {
        mShoppingApiDataModel = ShoppingApiDataModel()
        compositeDisposable = CompositeDisposable()
    }

    fun getShoppingDataList() {
        val disposable = mShoppingApiDataModel.getAllShoppingDataList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(object : DisposableObserver<ShoppingData>() {
                    override fun onComplete() {

                    }

                    override fun onNext(shoppingDataResponse: ShoppingData) {
                        Log.d(TAG, "onNext() \n ${shoppingDataResponse}")
                        shoppingData.value = shoppingDataResponse
                    }

                    override fun onError(error: Throwable) {
                        Log.e(TAG, error.toString())
                        shoppingData.value = null
                    }
                })
        compositeDisposable.add(disposable);
    }

    fun getShoppingLiveDataList(): MutableLiveData<ShoppingData> {
        return shoppingData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}