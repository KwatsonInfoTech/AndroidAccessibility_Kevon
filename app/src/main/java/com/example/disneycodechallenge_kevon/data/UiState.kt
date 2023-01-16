package com.example.disneycodechallenge_kevon.data

data class UiState (
    var GuestsHaveReservationCounter:Int=0,
    var GuestsNeedReservationCounter:Int=0,
    val bGuestNeedReservation:Boolean=false,
    val bGuestHaveReservation:Boolean=false,
    var footerNoticeMsg: Boolean = false

    )