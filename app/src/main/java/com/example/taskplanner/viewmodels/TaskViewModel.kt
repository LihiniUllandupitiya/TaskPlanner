package com.example.taskplanner.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskplanner.models.Task
import com.example.taskplanner.repository.TaskRepository
import com.example.taskplanner.utils.Resource

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskRepository = TaskRepository(application)


    fun insertTask(task: Task): MutableLiveData<Resource<Long>> {
        return taskRepository.insertTask(task)
    }
}