package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by ramonrabello on 21/08/17.
 */
class SnacksRemoteRepository : Repository<SnackWrapper> {

    lateinit var disposable: Disposable

    override fun add(item: SnackWrapper) {

    }

    override fun add(items: Iterable<SnackWrapper>) {

    }

    override fun update(item: SnackWrapper) {

    }

    override fun remove(item: SnackWrapper) {

    }

    override fun query(): Observable<SnackWrapper> {
        val allSnacks:MutableList<Snack> = ArrayList()
        Api.get().snacks().subscribeOn(Schedulers.io()).subscribe {
            snacks ->
            allSnacks.addAll(snacks)
        }
        return Observable.just(SnackWrapper(allSnacks))
    }

    override fun close() {
        disposable.dispose()
    }

}