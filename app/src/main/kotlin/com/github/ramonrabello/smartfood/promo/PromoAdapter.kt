package com.github.ramonrabello.smartfood.promo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.shared.BaseViewHolder
import kotlinx.android.synthetic.main.promo_view_holder.view.*

/**
 * Adapter to load snacks available.
 */
class PromoAdapter(private val promotions:List<Promotion>): RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    override fun getItemCount() = promotions.size

    override fun onBindViewHolder(holder: PromoViewHolder?, position: Int) {
        val promotion = promotions[position]
        holder?.bind(promotion)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PromoViewHolder =
            PromoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.promo_view_holder, parent, false))

    class PromoViewHolder(itemView: View) : BaseViewHolder<Promotion>(itemView) {
        override fun bind(model: Promotion) {
            itemView.promoName.text = model.name
            itemView.promoDescription.text = model.description
        }
    }
}