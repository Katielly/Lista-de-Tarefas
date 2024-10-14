package com.dev_mobile.list_task.viewmodel

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    //TODO PEGA LISTA DE TAREFAS SALVAS NO SHARED LOCAL
    var tasks = mutableListOf(
        TaskModel("Task1", "Seila2"),
        TaskModel("Task2", "Seila3"),
        TaskModel("Task3", "Seila4")
    )

    fun addTask(taskNew: TaskModel) {
        tasks.add(taskNew)
    }

    fun loadTask(): List<TaskModel> {
        return tasks
    }

    fun deleteTask(index: Int) {
        tasks.removeAt(index)
    }
}