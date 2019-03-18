package com.example.gem.firstapp.base

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife

abstract class BaseViewHolder<E> : RecyclerView.ViewHolder {

    constructor(itemView: View) : super(itemView) {
        ButterKnife.bind(this, itemView)
    }

    abstract fun bindView(item: E, position: Int)
}