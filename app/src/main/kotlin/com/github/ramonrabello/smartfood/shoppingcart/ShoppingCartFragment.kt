package com.github.ramonrabello.smartfood.shoppingcart

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.shared.model.Item
import com.github.ramonrabello.smartfood.snacks.SnacksContract

/**
 * Created by ramonrabello on 20/08/17.
 */
class ShoppingCartFragment : Fragment(), ShoppingCartContract.View {

    private lateinit var presenter: ShoppingCartContract.Presenter

    companion object {
        fun newInstance(): ShoppingCartFragment = ShoppingCartFragment()
    }

    override fun onResume() {
        super.onResume()
        //presenter = Shop
        presenter.loadAllItems()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = // Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_shopping_cart, container, false)

    override fun showItems(items: List<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyShoppingCart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyLoadingError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        super.onStop()
        presenter.dispose()
    }
}