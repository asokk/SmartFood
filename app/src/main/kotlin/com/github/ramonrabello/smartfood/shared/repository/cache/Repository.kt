package com.github.ramonrabello.smartfood.shared.repository.cache

import io.reactivex.Observable


/**
 * Base interface for reactive repository following Repository Pattern.
 */
interface Repository<T> {
    fun add(item:T)
    fun add(items: Iterable<T>)
    fun update(item:T)
    fun remove(item:T)
    fun query():Observable<T>
    fun close()
}