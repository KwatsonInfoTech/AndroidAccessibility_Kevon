package com.example.disneycodechallenge_kevon

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disneycodechallenge_kevon.viewModel.SelectionScreenViewModel
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SelectGuestScreen(viewModel: SelectionScreenViewModel = viewModel()) {


    Column {
        Spacer(modifier = Modifier.height(4.dp))
        BookingAppBar()
        Spacer(modifier = Modifier.height(18.dp))
        Header(text = "These Guests Have Reservations")
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumnReserved(0.45f, viewModel)
        Spacer(modifier = Modifier.height(18.dp))
        Header(text = "These Guests Need Reservations")
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumnNotReserved(1f, viewModel)
      //  Spacer(modifier = Modifier.height(2.dp))
       // Footer(1f,viewModel)


       // Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun BookingAppBar(){
    TopAppBar(
        title = {
            Text(
                text = "Select Guest",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
            )
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",
                )
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,

    )
}


@Composable
fun Header(text: String) {
    Text(text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .semantics { heading() })
}


@Composable
fun LazyColumnReserved(size: Float, viewmodel: SelectionScreenViewModel) {

    val list = listOf(
        "James Hardly",
        "Susan White",
        "Lucy Brown",
        "Harry Kane",
        "Kevin Duncan",
        "Harley Q",
        "Bruce Wayne",
        "Tom Stevens",

    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value};  tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToReservation()
                        } else {
                            viewmodel.removeFromReservation()
                        }
                        Log.i(
                            "GuestCounterReserved",
                            viewmodel.uiState.value.GuestsHaveReservationCounter.toString()
                        )
                    })
            ) {

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToReservation()
                        } else {
                            viewmodel.removeFromReservation()
                        }
                        Log.i(
                            "GuestCounterReserved",
                            viewmodel.uiState.value.GuestsHaveReservationCounter.toString()
                        )
                    },

                    )
                Text(
                    text = item,
                    maxLines = 2,
                )
            }
        })
    }
}

@Composable
fun LazyColumnNotReserved(size: Float, viewmodel: SelectionScreenViewModel) {
    val list = listOf(
        "Dustin wright",
        "Mia Jamma",
        "Tony kidd",
        "timmy Turner",
        "Designer dude",
        "Future Hendrixx",
        "Kendrick Taylor",
        "Marshall Mile",
        "Jon Snow",
        "Darius thatGuy"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight(size)) {
        items(items = list, itemContent = { item ->
            val checkedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .clearAndSetSemantics {
                        contentDescription =
                            "$item, checkbox is set to, ${checkedState.value}; tap to toggle"
                    }
                    .toggleable(value = checkedState.value, onValueChange = {
                        checkedState.value = it
                        if (it) {
                            viewmodel.addToNeedReservation()
                        } else {
                            viewmodel.removeNeedReservation()
                        }
                        Log.i(
                            "GuessCounterReserved",
                            viewmodel.uiState.value.GuestsHaveReservationCounter.toString()
                        )
                    })
            ) {
                Checkbox(checked = checkedState.value, onCheckedChange = {
                    checkedState.value = it
                    if (it) {
                        viewmodel.addToNeedReservation()
                    } else {
                        viewmodel.removeNeedReservation()
                    }
                    Log.i(
                        "GuessCounterReserved",
                        viewmodel.uiState.value.GuestsHaveReservationCounter.toString()
                    )
                })
                Text(
                    text = item, maxLines = 2
                )
            }
        })


    }

}




