package com.github.ramonrabello.smartfood.promo

import com.github.ramonrabello.smartfood.shared.presentation.BasePresenter
import com.github.ramonrabello.smartfood.shared.presentation.BaseView

/**
 * MVP contract for promos.
 */
interface PromoContract {

    /**
     *
     */
    interface Presenter : BasePresenter {
        fun loadPromos()
    }

    /**
     *
     */
    interface View : BaseView {
        fun showPromos(promos:List<Promotion>)
        fun showEmptyPromos()
    }
}