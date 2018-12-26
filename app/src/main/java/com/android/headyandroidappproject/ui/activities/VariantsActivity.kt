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
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.VariantsEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import com.android.headyandroidappproject.utility.Constants
import com.android.headyandroidappproject.utility.SpacesItemDecoration
import com.android.headyandroidappproject.viewHolders.VariantsViewHolder
import kotlinx.android.synthetic.main.activity_variants.*
import kotlinx.android.synthetic.main.progress_layout.*

class VariantsActivity : AppCompatActivity(), RecyclerViewClickListener {

    val TAG = "ProductListingActivity"
    val SPACE = 10
    var mDb: AppDataBase? = null
    var productId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_variants)
        configRecyclerView()
        readIntentData()
        mDb = AppDataBase.getInstance(this)
        getAllCatDataFromLocalDB()
    }

    private fun readIntentData() {
        productId = intent.getIntExtra(Constants.IntentParameter.PRODUCT_ID, 0)
    }

    private fun getAllCatDataFromLocalDB() {
        showProgressBar()
        val productDataListObserver = Observer<List<VariantsEntity>> { variantDataList ->
            hideProgressBar()
            setAdapter(variantDataList)
            Log.e(TAG, "all cat --->  " + variantDataList?.size);
        }
        mDb?.getVariantDao()?.getAllVariantsForParticularProduct(productId)?.observe(this, productDataListObserver)
    }

    private fun setAdapter(variantDataList: List<VariantsEntity>?) {
        variantsListingRecyclerView?.let {
            var adapter = GenericAdapter(variantDataList as List<Any>, this, R.layout.item_variants
                    , VariantsViewHolder::class.java.canonicalName, this)
            variantsListingRecyclerView?.adapter = adapter
        }
    }


    private fun configRecyclerView() {
        variantsListingRecyclerView.addItemDecoration(SpacesItemDecoration(SpacesItemDecoration.CAT_TAG, SPACE))
        variantsListingRecyclerView.apply {
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