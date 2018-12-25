package com.android.headyandroidappproject.viewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.android.headyandroidappproject.dataRepository.networkDataRepository.dataProviders.ShoppingApiDataModel
import com.android.headyandroidappproject.pojo.Category
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class MainActivityViewModel : ViewModel {

    private val TAG = "MainActivityViewModel"
    private var compositeDisposable: CompositeDisposable
    private var mShoppingApiDataModel: ShoppingApiDataModel;
    private var shoppingDataList: MutableLiveData<List<Category>> = MutableLiveData();

    constructor() {
        mShoppingApiDataModel = ShoppingApiDataModel()
        compositeDisposable = CompositeDisposable()
    }

    fun getShoppingDataList() {
        val disposable = mShoppingApiDataModel.getAllShoppingDataList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(object : DisposableObserver<List<Category>>() {
                    override fun onComplete() {

                    }

                    override fun onNext(shoppingDataResponse: List<Category>) {
                        Log.d(TAG, "onNext() \n ${shoppingDataResponse}")
                        shoppingDataList.value = shoppingDataResponse
                    }

                    override fun onError(error: Throwable) {
                        Log.e(TAG, error.toString())
                    }
                })
        compositeDisposable.add(disposable);
    }

    fun getShoppingLiveDataList(): MutableLiveData<List<Category>> {
        return shoppingDataList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}