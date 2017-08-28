package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.shared.repository.Specification
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by ramonrabello on 22/08/17.
 */
interface RealmSpecification:Specification {
    fun toRealmResults(realm: Realm): RealmResults<SnackRealm>
}