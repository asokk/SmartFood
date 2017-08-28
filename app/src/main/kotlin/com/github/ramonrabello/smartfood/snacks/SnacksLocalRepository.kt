package com.github.ramonrabello.smartfood.snacks

import android.content.Context
import android.util.Log
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*

/**
 * Created by ramonrabello on 21/08/17.
 */
class SnacksLocalRepository(val context: Context) : Repository<SnackModel> {

    var realmConfig = RealmConfiguration.Builder(context).build()
    var realm = Realm.getInstance(realmConfig)
    var snackRealmToSnackMapper = SnackRealmToSnackMapper()
    lateinit var disposable: Disposable

    override fun add(item: SnackModel) {
        val snackRealm = SnackRealm()
        snackRealm.apply {
            id = item.id
            name = item.name
            price = item.getPrice()
            image = item.image
        }

        realm.beginTransaction()
        realm.copyToRealm(snackRealm)
        realm.commitTransaction()
    }

    override fun add(items: Iterable<SnackModel>) {
        for (item in items) {
            add(item)
        }
    }

    override fun update(item: SnackModel) {
        val snackRealm: SnackRealm? = realm.where(SnackRealm::class.java).equalTo(SnackRealm.Fields.ID, item.id).findFirst()

        snackRealm?.apply {
            id = item.id
            name = item.name
            price = item.getPrice()
            image = item.image
        }
        realm.apply {
            beginTransaction()
            copyToRealm(snackRealm)
            commitTransaction()
        }
    }

    override fun remove(item: SnackModel) {
        throw IllegalAccessException("Remove function not implemented.")
    }

    override fun query(): Observable<List<SnackModel>> {
        val snacksList = Collections.emptyList<SnackModel>()

        val snacksRealmList = realm.where(SnackRealm::class.java).findAll()
        snacksRealmList.forEach { snackRealm -> snacksList.add(snackRealmToSnackMapper.map(snackRealm)) }
        return Observable.fromArray(snacksList)
    }

    override fun queryById(id: Int): Observable<SnackModel> {
        val snackRealm: SnackRealm = realm.where(SnackRealm::class.java).equalTo(SnackRealm.Fields.ID, id).findFirst()
        return Observable.just(snackRealmToSnackMapper.map(snackRealm))
    }

    override fun close() {
        disposable.dispose()
    }
}