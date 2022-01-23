package com.pp.pocketnotes.data

interface EntityMapper<S, O> {
    fun mapToDomain(source: S): O
    fun mapFromDomain(source: O): S
}