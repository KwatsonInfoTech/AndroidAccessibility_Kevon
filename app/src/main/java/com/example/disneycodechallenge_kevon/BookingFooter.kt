package com.example.disneycodechallenge_kevon

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disneycodechallenge_kevon.viewModel.SelectionScreenViewModel


@Composable
fun notice(){

    Row {
        Icon(
            Icons.Default.Info,
            contentDescription = "reservation needed.",
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Text(
            text = "At least one Guest in the party must have a reservation. Guests without reservations must remain in the same booking party in order to enter.",
            fontSize = 15.sp
        )
    }
}

@Composable
fun footer(viewModel: SelectionScreenViewModel){

    BottomAppBar(
        modifier = Modifier
            .background(Color.Transparent)
            .height(125.dp)



    ) {

        val uiState by viewModel.uiState.collectAsState()


        Column {
            val context = LocalContext.current
            notice()
            Button(
                onClick = {
                    if (uiState.GuestsHaveReservationCounter != 0) {
                        Toast.makeText(context, " To Confirmation Screen", Toast.LENGTH_SHORT)
                            .show()
                    }else if (uiState.GuestsHaveReservationCounter == 0){
                      //  viewModel.footerNoticeMsgAppear()
                        Toast.makeText(context, "At least one guest with a valid Reservation is needed", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                enabled = (
                        (uiState.GuestsNeedReservationCounter > 0) || (uiState.GuestsHaveReservationCounter > 0)
                        ),

            ) {
                Text(text = "Continue", fontSize = 22.sp)

            }

        }

    }

}
