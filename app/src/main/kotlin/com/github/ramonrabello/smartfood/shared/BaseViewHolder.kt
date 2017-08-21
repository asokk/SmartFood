package com.github.ramonrabello.smartfood.shared

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Base view holder.
 */
abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * base bind method to be implemented by subclasses.
     */
    abstract fun bind(model: T)
}