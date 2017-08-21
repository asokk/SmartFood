package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.shared.model.Price
import java.math.BigDecimal

/**
 * JSON model for an ingredient.
 */
data class Ingredient(val id:Int,
                      val name:String,
                      val price:BigDecimal){

}