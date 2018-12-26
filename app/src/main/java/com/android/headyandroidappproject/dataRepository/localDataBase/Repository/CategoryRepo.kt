package com.android.headyandroidappproject.dataRepository.localDataBase.Repository

import android.os.AsyncTask
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity
import java.util.*

class CategoryRepo() {

    companion object {
        fun insertCategoryList(mDb: AppDataBase?, categoryList: ArrayList<CategoryEntity>) {

            val task = PopulateDbAsync(mDb, categoryList)
            task.execute()
        }
    }

    private class PopulateDbAsync internal constructor(val mDb: AppDataBase?,
                                                       val categoryList: ArrayList<CategoryEntity>) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            mDb?.getCategoryDao()?.nukeTable()
            mDb?.getCategoryDao()?.insert(categoryList)
            return null
        }

    }
}