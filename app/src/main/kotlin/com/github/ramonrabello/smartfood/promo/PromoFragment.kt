package com.github.ramonrabello.smartfood.promo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.snacks.SnackAdapter
import com.github.ramonrabello.smartfood.snacks.SnacksContract
import com.github.ramonrabello.smartfood.snacks.SnacksFragment
import kotlinx.android.synthetic.main.fragment_promo.*

/**
 * Created by ramonrabello on 20/08/17.
 */


/**
 * A [Fragment] to show promos.
 */
class PromoFragment : Fragment(), PromoContract.View {

    private lateinit var presenter: PromoContract.Presenter

    companion object {
        fun newInstance(): PromoFragment = PromoFragment()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter = PromoPresenter(this)
        presenter.loadPromos()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = // Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_promo, container, false)

    override fun showPromos(promos: List<Promotion>) {
        progressBar.visibility = View.GONE
        recyclerView.apply {
            adapter = PromoAdapter(promos)
            layoutManager = LinearLayoutManager(context)
            visibility = View.VISIBLE
        }
    }

    override fun showEmptyPromos() {
        Snackbar.make(recyclerView, "There are no promos", Snackbar.LENGTH_LONG)
    }

    override fun notifyLoadingError() {
        progressBar.visibility = View.GONE
        Snackbar.make(recyclerView, "Error while loading promos", Snackbar.LENGTH_LONG)
    }

    override fun onStop() {
        super.onStop()
        presenter.dispose()
    }
}