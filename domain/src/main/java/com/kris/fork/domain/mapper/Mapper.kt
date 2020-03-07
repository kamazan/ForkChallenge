package com.kris.fork.domain.mapper

interface Mapper<Object, Result> {
    fun map(obj: Object): Result
}