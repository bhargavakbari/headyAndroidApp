package com.android.headyandroidappproject.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.android.headyandroidappproject.R
import com.android.headyandroidappproject.pojo.ShoppingData
import com.android.headyandroidappproject.viewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.progress_layout.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        observeShoppingListData()
    }

    private fun observeShoppingListData() {
        showProgressBar()
        mViewModel.getShoppingDataList()

        val shoppingDataListObserver = Observer<ShoppingData> { shoppingDataList ->
            hideProgressBar()
            Log.d(TAG, shoppingDataList.toString());
        }
        mViewModel.getShoppingLiveDataList().observe(this, shoppingDataListObserver)
    }

    private fun showProgressBar() {
        progressbarBaseLayout.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressbarBaseLayout.visibility = View.GONE
    }
}
