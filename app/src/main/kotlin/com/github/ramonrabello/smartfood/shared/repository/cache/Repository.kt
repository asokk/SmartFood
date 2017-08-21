package com.github.ramonrabello.smartfood.shared.repository.cache

import com.github.ramonrabello.smartfood.shared.repository.Specification


/**
 * Base interface for repository following Repository Pattern.
 */
interface Repository<T> {
    fun add(item:T)
    fun add(items: Iterable<T>)
    fun update(item:T)
    fun remove(item:T)
    fun query(specification: Specification):MutableList<T>
}