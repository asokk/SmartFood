package com.github.ramonrabello.smartfood.ingredients

import com.github.ramonrabello.smartfood.shared.model.mapper.Mapper
import com.github.ramonrabello.smartfood.snacks.SnackModel
import com.github.ramonrabello.smartfood.snacks.SnackRealm

/**
 * Created by ramonrabello on 22/08/17.
 */
class IngredientRealmToIngredientMapper : Mapper<IngredientRealm, Ingredient> {

    override fun map(from: IngredientRealm) =
            Ingredient(from.id, from.name, from.price, from.image)

}