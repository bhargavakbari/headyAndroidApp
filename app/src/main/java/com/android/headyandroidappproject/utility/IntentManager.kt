package com.android.headyandroidappproject.utility

import android.content.Context
import android.content.Intent
import com.android.headyandroidappproject.ui.activities.CategoryListingActivity
import com.android.headyandroidappproject.ui.activities.ProductListingActivity
import com.android.headyandroidappproject.ui.activities.VariantsActivity
import com.android.headyandroidappproject.utility.Constants.IntentParameter.Companion.CAT_ID
import com.android.headyandroidappproject.utility.Constants.IntentParameter.Companion.PRODUCT_ID

class IntentManager {
    companion object {

        fun openCategoryListingActivity(mContext: Context) {
            var categoryListingActivityIntent = Intent(mContext, CategoryListingActivity::class.java)
            mContext.startActivity(categoryListingActivityIntent)
        }


        fun openProductListingActivity(mContext: Context, catId: Int) {
            var productListingActivityIntent = Intent(mContext, ProductListingActivity::class.java)
            productListingActivityIntent.putExtra(CAT_ID, catId)
            mContext.startActivity(productListingActivityIntent)
        }


        fun openVariantListingActivity(mContext: Context, catId: Int) {
            var variantListingActivityIntent = Intent(mContext, VariantsActivity::class.java)
            variantListingActivityIntent.putExtra(PRODUCT_ID, catId)
            mContext.startActivity(variantListingActivityIntent)
        }
    }
}