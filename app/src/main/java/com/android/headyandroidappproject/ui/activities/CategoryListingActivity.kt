package com.android.headyandroidappproject.ui.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.android.headyandroidappproject.R
import com.android.headyandroidappproject.adapters.GenericAdapter
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import com.android.headyandroidappproject.utility.SpacesItemDecoration
import com.android.headyandroidappproject.utility.SpacesItemDecoration.CAT_TAG
import com.android.headyandroidappproject.viewHolders.CategoryItemViewHolder
import kotlinx.android.synthetic.main.activity_category_listing.*
import kotlinx.android.synthetic.main.progress_layout.*

class CategoryListingActivity : AppCompatActivity(), RecyclerViewClickListener {

    val TAG = "CategoryListingActivity"
    val SPACE = 10
    var mDb: AppDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_listing)
        configRecyclerView()
        mDb = AppDataBase.getInstance(this)
        getAllCatDataFromLocalDB()
    }

    private fun getAllCatDataFromLocalDB() {
        showProgressBar()
        val categoryDataListObserver = Observer<List<CategoryEntity>> { categoryDataList ->
            hideProgressBar()
            setAdapter(categoryDataList)
            Log.e(TAG, "all cat --->  " + categoryDataList?.size);
        }
        mDb?.getCategoryDao()?.getAllCategory()?.observe(this, categoryDataListObserver)
    }

    private fun setAdapter(categoryDataList: List<CategoryEntity>?) {
        categoryListingRecyclerView?.let {
            var adapter = GenericAdapter(categoryDataList as List<Any>, this, R.layout.item_category
                    , CategoryItemViewHolder::class.java.canonicalName, this)
            categoryListingRecyclerView?.adapter = adapter
        }
    }


    private fun configRecyclerView() {
        categoryListingRecyclerView.addItemDecoration(SpacesItemDecoration(CAT_TAG, SPACE))
        categoryListingRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        }
    }

    override fun onItemClicked(view: View, position: Int, any: Any) {

    }

    private fun showProgressBar() {
        progressbarBaseLayout.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressbarBaseLayout.visibility = View.GONE
    }
}