package com.pp.pocketnotes.presentation.save

sealed class PocketSavingState {
    object Idle : PocketSavingState()
    object Success : PocketSavingState()
    object Failure : PocketSavingState()
}