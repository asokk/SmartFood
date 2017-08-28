package com.github.ramonrabello.smartfood.ingredients

import com.github.ramonrabello.smartfood.shared.model.mapper.Mapper

/**
 * Created by ramonrabello on 22/08/17.
 */
class IngredientToIngredientRealmMapper : Mapper<Ingredient, IngredientRealm> {

    override fun map(from: Ingredient) =
            IngredientRealm(from.id, from.name, from.price, from.image)

}