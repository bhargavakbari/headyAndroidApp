package com.android.headyandroidappproject.dataRepository.localDataBase.Repository

import android.os.AsyncTask
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.VariantsEntity
import java.util.ArrayList

class VariantRepo {

    companion object {

        fun insertCategoryList(mDb: AppDataBase?, variantList: ArrayList<VariantsEntity>) {
            val task = PopulateDbAsync(mDb, variantList)
            task.execute()
        }
    }

    private class PopulateDbAsync internal constructor(val mDb: AppDataBase?,
                                                       val variantList: ArrayList<VariantsEntity>) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            mDb?.getVariantDao()?.nukeTable()
            mDb?.getVariantDao()?.insertAllVariants(variantList)
            return null
        }

    }
}