package com.github.ramonrabello.smartfood

import junit.framework.Assert
import org.junit.Test

/**
 * Created by ramonrabello on 20/08/17.
 */
class PriceTest {

//    @Test
//    fun shouldGetLightPrice(){
//        val ingredientes = 3
//        val portionValue = 1.20
//        val total = 20
//        val promoPrice = (portions * portionValue) - (portions - 1) * portionValue
//        Assert.assertEquals(22.40, total - promoPrice)
//    }

    @Test
    fun shouldGetPremiumPriceWhenThreePortions(){
        val portions = 3
        val portionValue = 1.20
        val total = 20
        val promoPrice = (portions - 1).times(portionValue)
        Assert.assertEquals(22.40, (total + promoPrice))
    }

    @Test
    fun shouldGetPremiumPriceWhenMoreThanThreePortions(){
        val portions = 6
        val portionValue = 1.20
        val total = 20
        val promoPrice = (portions - 2).times(portionValue)
        Assert.assertEquals(24.80, (total + promoPrice))
    }
}