package com.android.headyandroidappproject.dataRepository.localDataBase.Repository

import android.os.AsyncTask
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductViewEntity
import java.util.*

class ProductViewRepo {

    companion object {

        fun insertProductList(mDb: AppDataBase?, productViewEntityList: ArrayList<ProductViewEntity>) {
            val task = PopulateDbAsync(mDb, productViewEntityList)
            task.execute()
        }
    }

    private class PopulateDbAsync internal constructor(val mDb: AppDataBase?,
                                                       val productViewEntityList: ArrayList<ProductViewEntity>) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            mDb?.getRankingProductDao()?.nukeTable()
            mDb?.getRankingProductDao()?.insertAllRankingProduct(productViewEntityList)
            return null
        }

    }
}