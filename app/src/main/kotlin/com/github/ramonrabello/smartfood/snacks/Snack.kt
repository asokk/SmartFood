package com.github.ramonrabello.smartfood.promo

import com.github.ramonrabello.smartfood.shared.model.Item
import com.github.ramonrabello.smartfood.shared.model.Price
import com.github.ramonrabello.smartfood.snacks.Ingredient
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

/**
 * JSON model representing a Snack.
 */
data class Snack(val id:Int,
                 val name:String,
                 @SerializedName("ingredients") val ingredientIds:IntArray,
                 val image:String) {

    lateinit var ingredientList:List<Ingredient>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Snack

        if (id != other.id) return false
        if (name != other.name) return false
        if (!Arrays.equals(ingredientIds, other.ingredientIds)) return false
        if (image != other.image) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + Arrays.hashCode(ingredientIds)
        result = 31 * result + image.hashCode()
        return result
    }

    fun getPrice(): BigDecimal {
        val totalPrice = BigDecimal(0)
        ingredientList.forEach { totalPrice.plus(it.price) }
        return totalPrice
    }
}