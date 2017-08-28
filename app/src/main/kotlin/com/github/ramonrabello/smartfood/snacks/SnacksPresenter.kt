package com.github.ramonrabello.smartfood.snacks

import android.content.Context
import com.github.ramonrabello.smartfood.ingredients.Ingredient
import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * SnacksPresenter responsible to load all snacks features from REST API calls.
 */
class SnacksPresenter(private val context: Context, private val view: SnacksContract.View) : SnacksContract.Presenter {

    var snacksLocalRepository = SnacksLocalRepository(context)
    var snacksRemoteRepository = SnacksRemoteRepository()

    override fun loadSnacks() {

        val localRepositoryObservable = snacksLocalRepository.query()
                .filter { snacks -> snacks.isNotEmpty() }
                .subscribeOn(Schedulers.computation())

        val remoteRepositoryObservable = snacksRemoteRepository.query()
                .map { snackModel ->
                    Observable.create<SnackModel> { subscriber ->
                        snacksLocalRepository.add(snackModel)
                        subscriber.onComplete()
                    }.subscribeOn(Schedulers.computation()).subscribe()
                }.subscribeOn(Schedulers.io())

        // concatenate observables from local and remote repository
        val concatObservable = Observable.concat(localRepositoryObservable, remoteRepositoryObservable)
//                .flatMap { snacks -> snacks }
//        concatObservable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {snacks -> },
//                        {onError -> })

//        (localRepositoryObservable, remoteRepositoryObservable)
//
//                .subscribe(
//                        { onNext->
//                            view.showSnacks(onNext)
//
//        })
    }

    override fun dispose() {
        //concatObservable.()
    }
}