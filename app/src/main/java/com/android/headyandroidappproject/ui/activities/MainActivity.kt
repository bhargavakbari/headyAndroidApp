package com.android.headyandroidappproject.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.android.headyandroidappproject.R
import com.android.headyandroidappproject.dataRepository.localDataBase.Repository.*
import com.android.headyandroidappproject.dataRepository.localDataBase.dataBase.AppDataBase
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.*
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

            writeDatabase(shoppingDataList)
            Log.d(TAG, shoppingDataList.toString());
        }
        mViewModel.getShoppingLiveDataList().observe(this, shoppingDataListObserver)
    }

    private fun writeDatabase(shoppingData: ShoppingData?) {

        var categoryList = ArrayList<CategoryEntity>()
        var productList = ArrayList<ProductEntity>()
        var variantList = ArrayList<VariantsEntity>()

        var rankingList = ArrayList<RankingEntity>()
        var productViewList = ArrayList<ProductViewEntity>()

        for (category in shoppingData?.categories!!) {
            var entity = CategoryEntity(category.id, category.name)
            categoryList.add(entity)
            for (product in category?.products!!) {
                var productEntity = ProductEntity(product.id, category.id, product.dateAdded,
                        product.name, product.tax.name, product.tax.value)
                productList.add(productEntity)
                for (variant in product?.variants!!) {
                    var variantsEntity = VariantsEntity(variant.id, product.id, variant.color, variant.size, variant.price)
                    variantList.add(variantsEntity)
                }
            }
        }

        for (ranking in shoppingData?.rankings!!) {

            var allProductIds = ""
            for (productView in ranking?.products!!) {
                var productEntityView = ProductViewEntity(productView.id, productView.viewCount,
                        productView.orderCount, productView.sharesCount)
                productViewList.add(productEntityView)
                allProductIds = productView.id.toString() + "," + allProductIds
            }
            var rankingEntity = RankingEntity(ranking.ranking, allProductIds)
            rankingList.add(rankingEntity)
        }


        var mDb = AppDataBase.getInstance(this)
        CategoryRepo.insertCategoryList(mDb, categoryList)
        ProductRepo.insertProductList(mDb, productList)
        VariantRepo.insertCategoryList(mDb, variantList)
        RankingRepo.insertProductList(mDb, rankingList)
        ProductViewRepo.insertProductList(mDb, productViewList)


        val shoppingDataListObserver = Observer<List<CategoryEntity>> { shoppingDataList ->
            Log.e(TAG, "all cat --->  " + shoppingDataList?.size);
        }
        mDb?.getCategoryDao()?.getAllCategory()?.observe(this, shoppingDataListObserver)

        val shoppingDataListObserver1 = Observer<List<ProductEntity>> { shoppingDataList ->
            Log.e(TAG, "all product --->  " + shoppingDataList?.size);
        }
        mDb?.getProductDao()?.getAllProduct()?.observe(this, shoppingDataListObserver1)

        val shoppingDataListObserver2 = Observer<List<VariantsEntity>> { shoppingDataList ->
            Log.e(TAG, "all variants --->  " + shoppingDataList?.size);
        }
        mDb?.getVariantDao()?.getAllVariants()?.observe(this, shoppingDataListObserver2)

        val shoppingDataListObserver3 = Observer<List<RankingEntity>> { shoppingDataList ->
            Log.e(TAG, "all ranking --->  " + shoppingDataList?.size);
        }
        mDb?.getRankingsDao()?.getAllRankingItems()?.observe(this, shoppingDataListObserver3)

        val shoppingDataListObserver4 = Observer<List<ProductViewEntity>> { shoppingDataList ->
            Log.e(TAG, "all ranking pro --->  " + shoppingDataList?.size);
        }
        mDb?.getRankingProductDao()?.getAllRankingProduct()?.observe(this, shoppingDataListObserver4)
    }

    private fun showProgressBar() {
        progressbarBaseLayout.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressbarBaseLayout.visibility = View.GONE
    }
}
