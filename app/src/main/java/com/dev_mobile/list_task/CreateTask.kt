package com.dev_mobile.list_task

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.sharp.BookmarkBorder
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_mobile.list_task.ui.theme.ListtaskTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@SuppressLint("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(
    backScreen: () -> Unit
) {
    var taskDescription by remember { mutableStateOf("") }
    var categoryTask by remember { mutableStateOf("") }

    val currentTime = Calendar.getInstance()

    var timeText by remember { mutableStateOf("") }

    val timePickerDialog = TimePickerDialog(
        LocalContext.current, { _, hourOfDay, minute ->
            timeText = String.format(
                "%02d:%02d %s",
                if (hourOfDay % 12 == 0) 12 else hourOfDay % 12,
                minute,
                if (hourOfDay >= 12) "PM" else "AM"
            )
        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime.get(Calendar.MINUTE), false
    )

    var dateText by remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            val date = Calendar.getInstance()
            date.set(year, month, dayOfMonth)
            dateText = SimpleDateFormat("E, MMM d, yyyy", Locale.getDefault()).format(date.time)
        },
        currentTime.get(Calendar.YEAR),
        currentTime.get(Calendar.MONTH),
        currentTime.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Add Nova Tarefa",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Top
            ) {

                TextField(
                    value = taskDescription,
                    onValueChange = { taskDescription = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(152.dp),
                    label = { Text("Tarefa") },
                )

                Spacer(modifier = Modifier.padding(10.dp))

                AssistChip(onClick = { }, label = {
                    TextField(value = categoryTask,
                        onValueChange = { categoryTask = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Add categoria") })
                }, leadingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.BookmarkBorder,
                        contentDescription = "Task Category"
                    )
                })

                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(value = timeText,
                    onValueChange = {},
                    label = { Text("Horario") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { timePickerDialog.show() }) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = "Select Time"
                            )
                        }
                    })

                OutlinedTextField(value = dateText,
                    onValueChange = {},
                    label = { Text("Data") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { datePickerDialog.show() }) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Select Date"
                            )
                        }
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = { backScreen() }, colors = ButtonDefaults.buttonColors(
                        Color.Blue
                    ), shape = ShapeDefaults.ExtraSmall
                ) {
                    Text("Salvar")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCreateTask() {
    ListtaskTheme {
        CreateTask({})
    }
}