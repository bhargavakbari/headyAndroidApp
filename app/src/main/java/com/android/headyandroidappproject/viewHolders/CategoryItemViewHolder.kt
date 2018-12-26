package com.android.headyandroidappproject.viewHolders

import android.content.Context
import android.view.View
import com.android.headyandroidappproject.dataRepository.localDataBase.entities.CategoryEntity
import com.android.headyandroidappproject.listener.RecyclerViewClickListener
import kotlinx.android.synthetic.main.item_category.view.*
import java.util.*

class CategoryItemViewHolder(view: View, val mContext: Context) : BaseViewHolder(view, mContext) {

    var clickListener: RecyclerViewClickListener? = null
    var tvCategoryName = view.tvCategoryName
    var categoryNameCardView = view.categoryNameCardView
    var categoryNameList = ArrayList<CategoryEntity>()

    override fun initView() {
        categoryNameCardView.setOnClickListener { clickListener!!.onItemClicked(categoryNameCardView, adapterPosition, categoryNameList!![adapterPosition].CatId) }
    }

    override fun initDataForRecyclerView(items: List<Any>) {
        categoryNameList = items as ArrayList<CategoryEntity>
    }

    override fun itemClickListenerCallBack(clickListener: RecyclerViewClickListener?) {
        this.clickListener = clickListener
    }

    override fun currentItemPosition(position: Int) {
        super.currentItemPosition(position)
        tvCategoryName.text = categoryNameList!![adapterPosition].categoryName
    }
}