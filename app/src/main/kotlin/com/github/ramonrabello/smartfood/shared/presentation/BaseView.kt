package com.github.ramonrabello.smartfood.shared.presentation

/**
 * Created by ramonrabello on 21/08/17.
 */
interface BaseView {
    fun showProgress()
    fun hideProgress()
    fun notifyLoadingError()
}