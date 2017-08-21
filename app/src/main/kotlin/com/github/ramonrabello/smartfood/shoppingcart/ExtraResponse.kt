package com.github.ramonrabello.smartfood.shoppingcart

import java.util.*

/**
 * Created by ramonrabello on 20/08/17.
 */
data class ExtraResponse(private val id:Int,
                         private val id_sandwich:Int,
                         private val extras:IntArray,
                         private val date:Long) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ExtraResponse

        if (id != other.id) return false
        if (id_sandwich != other.id_sandwich) return false
        if (!Arrays.equals(extras, other.extras)) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + id_sandwich
        result = 31 * result + Arrays.hashCode(extras)
        result = 31 * result + date.hashCode()
        return result
    }
}