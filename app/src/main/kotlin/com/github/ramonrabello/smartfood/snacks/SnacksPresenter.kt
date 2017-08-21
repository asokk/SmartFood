package com.github.ramonrabello.smartfood.promo

import android.util.Log
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import com.github.ramonrabello.smartfood.snacks.SnackWrapper
import com.github.ramonrabello.smartfood.snacks.SnacksContract
import com.github.ramonrabello.smartfood.snacks.SnacksLocalRepository
import com.github.ramonrabello.smartfood.snacks.SnacksRemoteRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * SnacksPresenter responsible to load all snacks features from REST API calls.
 */
class SnacksPresenter(private val view: SnacksContract.View) : SnacksContract.Presenter {

    lateinit var concatObservable: Disposable
    var snacksLocalRepository: Repository<SnackWrapper> = SnacksLocalRepository()
    var snacksRemoteRepository: Repository<SnackWrapper> = SnacksRemoteRepository()

    override fun loadSnacks() {

        // try to load from local cache
        val localRepositoryObservable = snacksLocalRepository.query()
                .filter { snackWrapper -> snackWrapper.snacks.isNotEmpty() }
                .subscribeOn(Schedulers.computation())

        // load from remote repository and save data to local repository
        val remoteRepositoryObservable = snacksRemoteRepository.query()
                .map { snackWrapper ->
                    Observable.create<SnackWrapper> { subscriber ->
                        snacksLocalRepository.add(snackWrapper)
                        subscriber.onComplete()
                    }.subscribeOn(Schedulers.computation()).subscribe()
                }.subscribeOn(Schedulers.io())

        // concatenate observables from local and remote repository
        concatObservable = Observable.concat(localRepositoryObservable, remoteRepositoryObservable)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { snackWrapper ->
                    view.showSnacks(snackWrapper as SnackWrapper)
                },
                {
                    error ->
                    Log.e("SnacksPresenter", "error occurred: ${error.message}")
                    view.notifyLoadingError()
                })
    }

    override fun dispose() {
        concatObservable.dispose()
    }
}