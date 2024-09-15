package com.dev_mobile.list_task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev_mobile.list_task.ui.theme.ListtaskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    openCreateTask: () -> Unit
) {

    ListtaskTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = { openCreateTask() }
                        ) {
                            Icon(Icons.Sharp.Menu, contentDescription = "menu")
                        }

                    }, title = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "My Tasks",
                            textAlign = TextAlign.Center
                        )

                    },
                    actions = {
                        IconButton(
                            onClick = {/*TODO*/ }
                        ) {
                            Icon(Icons.Sharp.Delete, "trash")
                        }
                    }
                )
            }

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    //TODO - CHAMA TASK-CARD
//                    TaskCard(title = , describe = )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        FloatingActionButton(
                            onClick = { openCreateTask() },
                            contentColor = Color.White,
                            containerColor = Color.Blue
                        ) {
                            Icon(Icons.Sharp.Add, "add")
                        }
                    }
                }
            }


        }
    }
}

@Preview
@Composable
fun PreviewHome() {
    Home({})
}