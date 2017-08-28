package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.ingredients.Ingredient

/**
 * Created by ramonrabello on 28/08/17.
 */
class SnackModel(val id:Int,
                 val name:String,
                 val ingredients:List<Ingredient>?,
                 val image:String) {

    fun getPrice(): Float {
        val totalPrice = 0.0f
        ingredients?.forEach { totalPrice.plus(it.price) }
        return totalPrice
    }

    fun getIngredientsDescription():String {
        val ingredientsDescription = ""
        ingredients?.forEach { it -> ingredientsDescription.plus(it.name).plus(", ") }
        return ingredientsDescription
    }
}