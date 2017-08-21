package com.github.ramonrabello.smartfood.shared.model

import java.math.BigDecimal

/**
 * Created by ramonrabello on 20/08/17.
 */
abstract class Price(value: BigDecimal) {
    abstract fun getPrice(portions:Int):BigDecimal
}