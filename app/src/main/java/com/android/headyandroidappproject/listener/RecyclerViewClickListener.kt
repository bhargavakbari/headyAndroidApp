package com.android.headyandroidappproject.listener;

import android.view.View

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, position: Int, any: Any);
}
