package com.github.ramonrabello.smartfood.shared.model.mapper

/**
 * Base mapper for data.
 */
interface Mapper<in From, out To>{
    fun map(from:From):To
}