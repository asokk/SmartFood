package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.ingredients.Ingredient
import com.github.ramonrabello.smartfood.ingredients.IngredientRealmToIngredientMapper
import com.github.ramonrabello.smartfood.shared.model.mapper.Mapper

/**
 * Created by ramonrabello on 22/08/17.
 */
class SnackRealmToSnackMapper : Mapper<SnackRealm, SnackModel> {

    var ingredientRealmToIngredientMapper = IngredientRealmToIngredientMapper()

    override fun map(from: SnackRealm):SnackModel{
        val ingredientList:MutableList<Ingredient> = mutableListOf()
        from.ingredients?.mapTo(ingredientList) {
            ingredientRealmToIngredientMapper.map(it)
        }
        return SnackModel(from.id, from.name, ingredientList, from.image)
    }
}