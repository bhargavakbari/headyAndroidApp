package com.android.headyandroidappproject.dataRepository.localDataBase.Repository

import android.os.AsyncTask
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.RankingEntity
import java.util.*

class RankingRepo {

    companion object {
        fun insertProductList(mDb: AppDataBase?, rankingList: ArrayList<RankingEntity>) {
            val task = PopulateDbAsync(mDb, rankingList)
            task.execute()
        }
    }

    private class PopulateDbAsync internal constructor(val mDb: AppDataBase?,
                                                       val rankingList: ArrayList<RankingEntity>) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void): Void? {
            mDb?.getRankingsDao()?.nukeTable()
            mDb?.getRankingsDao()?.insertAllRankingItems(rankingList)
            return null
        }

    }
}