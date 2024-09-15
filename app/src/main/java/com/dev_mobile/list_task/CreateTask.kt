package com.dev_mobile.list_task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_mobile.list_task.ui.theme.ListtaskTheme
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(
    backScreen: () -> Unit
) {

    var openSelectDate by remember {
        mutableStateOf(false)
    }

    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""


//    var selectedDate by remember {
//        mutableStateOf<Long?>(null)
//    }
    //TODO CONTROLE DENTRO POP-UP DATE
//    if (selectedDate != null) {
//        val date = Date(selectedDate!!)
//    }


    if (openSelectDate) {
        DatePickerDialog(onDismissRequest = {
            //TODO FECHA DATA
        }, confirmButton = {
            //TODO CONFIRMA DATA
        }, dismissButton = {

        }) {
            DatePicker(state = datePickerState)
        }
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Add Nova Tarefa") })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Red)
        ) {
            //TODO CAMPO TEXTO AREA
            // SALVAR NOTA
            // HORAS
            // DATA
            // BOTÃO

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Green)
            ) {
//                OutlinedTextField(
//                    value = selectedDate,
//                    onValueChange = { },
//                    label = { Text("DOB") },
//                    readOnly = true,
//                    trailingIcon = {
//                        IconButton(onClick = { openSelectDate = !openSelectDate }) {
//                            Icon(
//                                imageVector = Icons.Default.DateRange,
//                                contentDescription = "Select date"
//                            )
//                        }
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(64.dp)
//                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { backScreen() }) {
                    Text("Salvar")
                }
            }
        }
    }
}

fun convertMillisToDate(it: Long) {

}

@Preview
@Composable
fun PreviewCreateTask() {
    ListtaskTheme {
        CreateTask({})
    }
}