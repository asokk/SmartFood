package com.github.ramonrabello.smartfood.snacks

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ramonrabello.smartfood.R
import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.promo.SnacksPresenter
import kotlinx.android.synthetic.main.fragment_snacks.progressBar
import kotlinx.android.synthetic.main.fragment_snacks.recyclerView

/**
 * Fragment that shows available snacks.
 */
class SnacksFragment : Fragment(), SnacksContract.View {

    private lateinit var presenter:SnacksContract.Presenter

    companion object {
        fun newInstance(): SnacksFragment = SnacksFragment()
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
            inflater.inflate(R.layout.fragment_snacks, container, false)

    override fun onResume() {
        super.onResume()
        presenter = SnacksPresenter(this)
        presenter.loadSnacks()
    }

    override fun showSnacks(snacks: List<Snack>) {
        recyclerView.apply {
            adapter = SnackAdapter(snacks)
            layoutManager = LinearLayoutManager(context)
            visibility = View.VISIBLE
        }
    }

    override fun showEmptySnacks() {
        progressBar.visibility = View.GONE
        Snackbar.make(recyclerView, "There are no snacks", Snackbar.LENGTH_LONG).show()
    }

    override fun notifyLoadingError() {
        progressBar.visibility = View.GONE
        Snackbar.make(recyclerView, "Error while loading snacks", Snackbar.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        presenter.dispose()
    }
}