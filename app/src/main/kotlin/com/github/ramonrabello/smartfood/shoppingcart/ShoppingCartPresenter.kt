package com.github.ramonrabello.smartfood.shoppingcart

import com.github.ramonrabello.smartfood.shared.model.Item
import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Presenter responsible to manage shopping cart features.
 */
class ShoppingCartPresenter(private val view: ShoppingCartContract.View) : ShoppingCartContract.Presenter {

    lateinit var disposable: Disposable

    override fun loadAllItems() {
        Api.get().currentOrder().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ currentItems ->
                    if (currentItems.isNotEmpty()) {
                        view.showItems(currentItems)
                    } else {
                        view.showEmptyShoppingCart()
                    }
                })
    }

    override fun addItem(item: Item) {
        Api.get().addItem(item.id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ currentItems ->
                    if (currentItems.isNotEmpty()) {
                        view.updateTotalPrice(currentItems)
                    } else {
                        view.showEmptyShoppingCart()
                    }
                })
    }

    override fun removeItem(item: Item) {}
    override fun dispose() {
        disposable.dispose()
    }
}