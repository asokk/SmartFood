package com.github.ramonrabello.smartfood.snacks

import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by ramonrabello on 22/08/17.
 */
class SnackByIdSpecification(private var id:Int) : RealmSpecification {

    override fun toRealmResults(realm: Realm): RealmResults<SnackRealm> {
        return realm.where(SnackRealm::class.java)
                .equalTo(SnackRealm.Fields.ID, id)
                .findAll()
    }
}