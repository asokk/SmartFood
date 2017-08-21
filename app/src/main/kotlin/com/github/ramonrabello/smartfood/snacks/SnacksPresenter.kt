package com.github.ramonrabello.smartfood.promo

import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import com.github.ramonrabello.smartfood.snacks.SnacksContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * SnacksPresenter responsible to load all snacks features from REST API calls.
 */
class SnacksPresenter(private val view: SnacksContract.View) : SnacksContract.Presenter {

    lateinit var disposable:Disposable

    override fun loadSnacks() {
        disposable = Api.get().snacks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { snacks ->
                    if (!snacks.isEmpty()) {
                        view.hideProgress()
                        view.showSnacks(snacks)
                    } else {
                        view.showEmptySnacks()
                    }
                },
                { _ ->
                    view.notifyLoadingError()
                })
    }

    override fun dispose() {
        disposable.dispose()
    }
}