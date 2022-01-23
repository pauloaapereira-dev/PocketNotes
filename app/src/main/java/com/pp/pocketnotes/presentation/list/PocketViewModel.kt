package com.pp.pocketnotes.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.pocket.usecases.GetPocketItems
import com.pp.pocketnotes.domain.pocket.usecases.GetPocketItemsByTag
import com.pp.pocketnotes.domain.tags.model.Tag
import com.pp.pocketnotes.presentation.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PocketViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val getPocketItems: GetPocketItems,
    private val getPocketItemsByTag: GetPocketItemsByTag,
) : ViewModel() {

    var pocketState by mutableStateOf<PocketViewState>(PocketViewState.Loading)
        private set

    fun loadPocketItems(tag: Tag? = null) {
        viewModelScope.launch(dispatcher) {
            pocketState = PocketViewState.Loading

            val result = tag?.let { getPocketItemsByTag(it) } ?: getPocketItems()

            pocketState = when (result) {
                is PocketResult.Success -> PocketViewState.Loaded(result.data)
                is PocketResult.Failure -> PocketViewState.Error
            }
        }
    }

}