package com.pp.pocketnotes.presentation.list

import com.pp.pocketnotes.domain.pocket.model.PocketItem

sealed class PocketViewState {
    object Loading : PocketViewState()
    object Error : PocketViewState()
    data class Loaded(val pocketItems: List<PocketItem>) : PocketViewState()
}