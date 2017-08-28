package com.github.ramonrabello.smartfood.snacks
import com.github.ramonrabello.smartfood.ingredients.IngredientRealm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ramonrabello on 22/08/17.
 */
data class SnackRealm(@PrimaryKey var id: Int = 0,
                      var name: String = "",
                      var image: String = "",
                      var price: Float = 0.0f) : RealmObject() {

    var ingredients:RealmList<IngredientRealm>? = null

    object Fields {
        val ID: String = "ID"
    }
}