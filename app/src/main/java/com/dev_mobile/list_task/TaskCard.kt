package com.dev_mobile.list_task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev_mobile.list_task.ui.theme.ListtaskTheme

@Composable
fun TaskCard(
    title: String,
    describe: String
) {

    var ckecked by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(14.dp),
        shape = CardDefaults.elevatedShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                Checkbox(
                    checked = ckecked,
                    onCheckedChange = {
                        ckecked = it
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(10.dp),
                        text = title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
                Text(
                    text = describe,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview
@Composable
fun TaskCardPreview() {
    ListtaskTheme {
        TaskCard(
            "Titulo",
            "Mensagem mais aihsd dwunjnsa dwoedjkjsddwedw wedwedwe reregrte efergerftr rtgrtgt rtgrtgtgrt effer"
        )
    }
}