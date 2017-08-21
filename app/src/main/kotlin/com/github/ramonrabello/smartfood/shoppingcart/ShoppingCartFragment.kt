package com.github.ramonrabello.smartfood.shoppingcart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ramonrabello.smartfood.R
import kotlinx.android.synthetic.main.fragment_my_order.*

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
        presenter = ShoppingCartPresenter(this)
        presenter.loadAllItems()
    }

    override fun showItems(items: List<ExtraResponse>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTotalPrice(items: List<ExtraResponse>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = // Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_shopping_cart, container, false)

    override fun showEmptyShoppingCart() {

    }

    override fun notifyLoadingError() {

    }

    override fun onStop() {
        super.onStop()
        presenter.dispose()
    }
}