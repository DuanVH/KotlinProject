package com.example.gem.firstapp.base

import android.content.Context
import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<E, V : BaseViewHolder<E>> : RecyclerView.Adapter<V> {

    private var mContext: Context? = null
    var mItems: MutableList<E>? = null

    constructor(context: Context) {
        mContext = context
        mItems = mutableListOf()
    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }

    fun addItem(items: MutableList<E>) {
        var previousSize: Int = mItems!!.size
        mItems = items
        notifyItemRangeInserted(previousSize, items.size)
    }

    fun refreshList(items: MutableList<E>) {
        mItems!!.clear()
        mItems!!.addAll(items)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): E {
        return mItems!!.get(position)
    }

    fun getItems(): MutableList<E> {
        return mItems!!
    }

    protected fun getContext(): Context {
        return mContext!!
    }
}