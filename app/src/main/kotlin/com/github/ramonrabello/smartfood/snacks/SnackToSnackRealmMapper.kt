package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.ingredients.Ingredient
import com.github.ramonrabello.smartfood.ingredients.IngredientRealm
import com.github.ramonrabello.smartfood.ingredients.IngredientRealmToIngredientMapper
import com.github.ramonrabello.smartfood.ingredients.IngredientToIngredientRealmMapper
import com.github.ramonrabello.smartfood.shared.model.mapper.Mapper
import io.realm.RealmList

/**
 * Created by ramonrabello on 22/08/17.
 */
class SnackToSnackRealmMapper : Mapper<SnackModel, SnackRealm> {

    var ingredientToIngredientRealmMapper = IngredientToIngredientRealmMapper()

    override fun map(from: SnackModel): SnackRealm {
        val ingredientList: RealmList<IngredientRealm> = RealmList()
        from.ingredients?.mapTo(ingredientList) {
            ingredientToIngredientRealmMapper.map(it)
        }
        return SnackRealm(from.id, from.name, from.image, from.getPrice(), ingredientList)
    }
}