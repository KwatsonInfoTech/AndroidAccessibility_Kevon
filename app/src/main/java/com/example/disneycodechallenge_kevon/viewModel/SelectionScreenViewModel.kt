package com.example.disneycodechallenge_kevon.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.disneycodechallenge_kevon.data.UiState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SelectionScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()



    fun removeNeedReservation() {

        uiState.value.GuestsNeedReservationCounter--
        if (uiState.value.GuestsNeedReservationCounter == 0) {
            _uiState.update { it.copy(bGuestNeedReservation = false) }
        }

    }

    fun addToNeedReservation() {
        uiState.value.GuestsNeedReservationCounter++
        if (uiState.value.GuestsNeedReservationCounter> 0) {
            _uiState.update { it.copy(bGuestNeedReservation = true) }
        }
    }


    fun removeFromReservation() {

        uiState.value.GuestsHaveReservationCounter--
        if (uiState.value.GuestsHaveReservationCounter == 0) {
            _uiState.update { it.copy(bGuestHaveReservation = false) }
        }

    }
    fun addToReservation() {
        uiState.value.GuestsHaveReservationCounter++
        if (uiState.value.GuestsHaveReservationCounter > 0) {
            _uiState.update { it.copy(bGuestHaveReservation = true) }
        }
    }



}




