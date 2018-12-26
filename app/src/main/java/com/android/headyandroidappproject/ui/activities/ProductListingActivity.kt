package com.android.headyandroidappproject.ui.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.android.headyandroidappproject.R
import com.android.headyandroidappproject.adapters.GenericAdapter
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import com.android.headyandroidappproject.utility.Constants.IntentParameter.Companion.CAT_ID
import com.android.headyandroidappproject.utility.SpacesItemDecoration
import com.android.headyandroidappproject.viewHolders.ProductItemViewHolder
import kotlinx.android.synthetic.main.activity_product_listing.*
import kotlinx.android.synthetic.main.progress_layout.*

class ProductListingActivity : AppCompatActivity(), RecyclerViewClickListener {

    val TAG = "ProductListingActivity"
    val SPACE = 10
    var mDb: AppDataBase? = null
    var catId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_listing)
        configRecyclerView()
        readIntentData()
        mDb = AppDataBase.getInstance(this)
        getAllCatDataFromLocalDB()
    }

    private fun readIntentData() {
        catId = intent.getIntExtra(CAT_ID, 0)
    }

    private fun getAllCatDataFromLocalDB() {
        showProgressBar()
        val productDataListObserver = Observer<List<ProductEntity>> { productDataList ->
            hideProgressBar()
            setAdapter(productDataList)
            Log.e(TAG, "all cat --->  " + productDataList?.size);
        }
        mDb?.getProductDao()?.getAllProductForParticularCategory(catId)?.observe(this, productDataListObserver)
    }

    private fun setAdapter(categoryDataList: List<ProductEntity>?) {
        productListingRecyclerView?.let {
            var adapter = GenericAdapter(categoryDataList as List<Any>, this, R.layout.item_product
                    , ProductItemViewHolder::class.java.canonicalName, this)
            productListingRecyclerView?.adapter = adapter
        }
    }


    private fun configRecyclerView() {
        productListingRecyclerView.addItemDecoration(SpacesItemDecoration(SpacesItemDecoration.CAT_TAG, SPACE))
        productListingRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
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