package com.example.disneycodechallenge_kevon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.disneycodechallenge_kevon.viewModel.SelectionScreenViewModel



@Composable
fun toDisplay(viewModel: SelectionScreenViewModel = viewModel()){

    Scaffold(
        topBar = {

        },

        content = {

            Column(modifier = Modifier.padding(it)) {
                SelectGuestScreen(viewModel)

            }
        },
        bottomBar = {
            footer(viewModel)

        },  backgroundColor = MaterialTheme.colors.background,

    )

}