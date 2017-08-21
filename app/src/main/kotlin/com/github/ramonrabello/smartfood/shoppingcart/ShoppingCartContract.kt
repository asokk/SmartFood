package com.github.ramonrabello.smartfood.shoppingcart

import com.github.ramonrabello.smartfood.shared.model.Item
import com.github.ramonrabello.smartfood.shared.presentation.BasePresenter
import com.github.ramonrabello.smartfood.shared.presentation.BaseView

/**
 * Created by ramonrabello on 20/08/17.
 */
interface ShoppingCartContract {

    /**
     *
     */
    interface Presenter : BasePresenter {
        fun loadAllItems()
        fun addItem(item: Item)
        fun removeItem(item: Item)
    }

    /**
     *
     */
    interface View : BaseView{
        fun showItems(items: List<ExtraResponse>)
        fun updateTotalPrice(items: List<ExtraResponse>)
        fun showEmptyShoppingCart()
    }
}