package com.github.ramonrabello.smartfood.shoppingcart

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.snacks.Snack
import com.github.ramonrabello.smartfood.shared.BaseViewHolder
import com.github.ramonrabello.smartfood.shared.model.Item

/**
 * Adapter to load items on shopping cart.
 */
class ItemAdapter(private var items:List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder =
            ItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.snack_view_holder, parent, false))

    class ItemViewHolder(itemView: View) : BaseViewHolder<Item>(itemView) {
        override fun bind(model: Item) {
//            itemView.snackName.text = model.name
//            itemView.snackIngredients.text = model.ingredientIds.toString()
        }
    }
}