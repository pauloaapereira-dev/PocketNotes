package com.pp.pocketnotes.presentation.save

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pp.pocketnotes.domain.PocketResult
import com.pp.pocketnotes.domain.pocket.model.PocketItem
import com.pp.pocketnotes.domain.pocket.usecases.SavePocketItem
import com.pp.pocketnotes.presentation.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PocketSaveViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val savePocketItem: SavePocketItem,
) : ViewModel() {

    private val _savingState = MutableStateFlow<PocketSavingState>(PocketSavingState.Idle)
    val savingState: Flow<PocketSavingState> = _savingState

    fun savePocketItem(uri: String) {
        viewModelScope.launch(dispatcher) {
            when (savePocketItem.invoke(PocketItem(uri = uri))) {
                is PocketResult.Success -> {
                    _savingState.emit(PocketSavingState.Success)
                }
                is PocketResult.Failure -> {
                    _savingState.emit(PocketSavingState.Failure)
                }
            }
        }
    }

}