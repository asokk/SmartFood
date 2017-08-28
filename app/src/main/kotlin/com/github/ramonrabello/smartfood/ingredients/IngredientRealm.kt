package com.github.ramonrabello.smartfood.ingredients

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ramonrabello on 22/08/17.
 */
data class IngredientRealm(@PrimaryKey var id: Int = 0,
                           var name: String = "",
                           var price: Float = 0.0f,
                           var image: String = "") : RealmObject()