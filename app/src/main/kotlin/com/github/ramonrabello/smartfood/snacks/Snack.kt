package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.ingredients.Ingredient
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * JSON model representing a SnackJsonModel.
 */
data class Snack(val id:Int,
                 val name:String,
                 private @SerializedName("ingredients") val ingredientIds:IntArray,
                 val image:String) {

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
}