package br.com.caiopo.travelbuddy.model.resolver

import br.com.caiopo.travelbuddy.App

abstract class BaseResolver<T> {

    fun get(item: T?): String? {
        return App.context.getString(getRes(item ?: return null))
    }

    abstract fun getRes(item: T): Int
}
