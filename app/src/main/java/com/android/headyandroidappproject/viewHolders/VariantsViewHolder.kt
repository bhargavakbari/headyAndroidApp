package com.android.headyandroidappproject.viewHolders

import android.content.Context
import android.view.View
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.VariantsEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import kotlinx.android.synthetic.main.item_variants.view.*
import java.util.*

class VariantsViewHolder(view: View, val mContext: Context) : BaseViewHolder(view, mContext) {

    var clickListener: RecyclerViewClickListener? = null
    var tvProductPrice = view.tvProductPrice
    var tvColor = view.tvColor
    var tvSize = view.tvSize
    var variantsCardView = view.variantsCardView
    var variantList = ArrayList<VariantsEntity>()

    override fun initView() {
        //variantsCardView.setOnClickListener { clickListener!!.onItemClicked(variantsCardView, adapterPosition, variantList!![adapterPosition].productId) }
    }

    override fun initDataForRecyclerView(items: List<Any>) {
        variantList = items as ArrayList<VariantsEntity>
    }

    override fun itemClickListenerCallBack(clickListener: RecyclerViewClickListener?) {
        this.clickListener = clickListener
    }

    override fun currentItemPosition(position: Int) {
        super.currentItemPosition(position)
        tvProductPrice.text = variantList!![adapterPosition].price.toString()
        tvColor.text = variantList!![adapterPosition].color
        tvSize.text = variantList!![adapterPosition].size.toString()
    }
}