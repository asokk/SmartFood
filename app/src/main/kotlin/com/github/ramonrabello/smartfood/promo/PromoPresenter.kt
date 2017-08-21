package com.github.ramonrabello.smartfood.promo

import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * SnacksPresenter responsible to load all promo features from REST API calls.
 */
class PromoPresenter(private val view: PromoContract.View) : PromoContract.Presenter {

    lateinit var disposable:Disposable

    override fun loadPromos() {
        disposable = Api.get().promotions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { promotions ->
                    if (!promotions.isEmpty()) {
                        view.showPromos(promotions)
                    } else {
                        view.showEmptyPromos()
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