package com.github.ramonrabello.smartfood.snacks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.promo.Promotion
import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.shared.BaseViewHolder
import kotlinx.android.synthetic.main.snack_view_holder.view.*

/**
 * Adapter to load snacks available.
 */
class SnackAdapter(private var snacks:List<Snack>) : RecyclerView.Adapter<SnackAdapter.SnackViewHolder>() {

    override fun getItemCount() = snacks.size

    override fun onBindViewHolder(holder: SnackViewHolder?, position: Int) {
        val snack = snacks[position]
        holder?.bind(snack)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SnackViewHolder =
            SnackViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.snack_view_holder, parent, false))

    class SnackViewHolder(itemView: View) : BaseViewHolder<Snack>(itemView) {
        override fun bind(model: Snack) {
            itemView.snackName.text = model.name
            itemView.snackIngredients.text = model.ingredientIds.toString()
            Glide.with(itemView.context).load(model.image).into(itemView.snackImage)
        }
    }
}