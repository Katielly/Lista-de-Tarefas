package com.dev_mobile.list_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev_mobile.list_task.ui.theme.ListtaskTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListtaskTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Home(
                            openCreateTask = { navController.navigate("createTask") },
                        )
                    }
                    composable("createTask") {
                        CreateTask(
                            backScreen = { navController.navigate("home") }
                        )
                    }
                }
            }
        }
    }

}