package com.android.headyandroidappproject.dataRepository.localDataBase.Repository

import android.os.AsyncTask
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductEntity
import java.util.ArrayList

class ProductRepo {

    companion object {
        fun insertProductList(mDb: AppDataBase?, productList: ArrayList<ProductEntity>) {
            val task = PopulateDbAsync(mDb, productList)
            task.execute()
        }
    }

    private class PopulateDbAsync internal constructor(val mDb: AppDataBase?,
                                                       val productList: ArrayList<ProductEntity>) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            mDb?.getProductDao()?.nukeTable()
            mDb?.getProductDao()?.insertAllProduct(productList)
            return null
        }

    }
}