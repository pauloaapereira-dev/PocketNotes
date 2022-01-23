package com.pp.pocketnotes.domain

sealed class PocketResult<out T> {
    data class Success<T>(val data: T) : PocketResult<T>()
    data class Failure(val error: Exception) : PocketResult<Nothing>()
}