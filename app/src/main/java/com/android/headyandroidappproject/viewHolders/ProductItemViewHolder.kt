package com.android.headyandroidappproject.viewHolders

import android.content.Context
import android.view.View
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.ProductEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import kotlinx.android.synthetic.main.item_product.view.*
import java.util.*

class ProductItemViewHolder(view: View, val mContext: Context) : BaseViewHolder(view, mContext) {

    var clickListener: RecyclerViewClickListener? = null
    var tvProductName = view.tvProductName
    var viewVariantsBtn = view.viewVariantsBtn
    var productNameCardView = view.productNameCardView
    var productNameList = ArrayList<ProductEntity>()

    override fun initView() {
        productNameCardView.setOnClickListener { clickListener!!.onItemClicked(productNameCardView, adapterPosition, productNameList!![adapterPosition].productId) }
        viewVariantsBtn.setOnClickListener { clickListener!!.onItemClicked(productNameCardView, adapterPosition, productNameList!![adapterPosition].productId) }
    }

    override fun initDataForRecyclerView(items: List<Any>) {
        productNameList = items as ArrayList<ProductEntity>
    }

    override fun itemClickListenerCallBack(clickListener: RecyclerViewClickListener?) {
        this.clickListener = clickListener
    }

    override fun currentItemPosition(position: Int) {
        super.currentItemPosition(position)
        tvProductName.text = productNameList!![adapterPosition].productName
    }
}