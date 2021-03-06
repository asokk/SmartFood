package com.github.ramonrabello.smartfood.snacks
import com.github.ramonrabello.smartfood.snacks.Snack
import com.github.ramonrabello.smartfood.shared.presentation.BasePresenter
import com.github.ramonrabello.smartfood.shared.presentation.BaseView


/**
 * Created by ramonrabello on 20/08/17.
 */
interface SnacksContract {

    /**
     *
     */
    interface Presenter : BasePresenter{
        fun loadSnacks()
    }

    /**
     *
     */
    interface View : BaseView {
        fun showSnacks(snackList: List<SnackModel>)
        fun showEmptySnacks()
    }
}