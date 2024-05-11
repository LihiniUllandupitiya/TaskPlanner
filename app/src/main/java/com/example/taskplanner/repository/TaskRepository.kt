package com.example.taskplanner.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.taskplanner.database.TaskDatabase
import com.example.taskplanner.models.Task
import com.example.taskplanner.utils.Resource
import com.example.taskplanner.utils.Resource.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskRepository(application: Application) {
    private val taskDao = TaskDatabase.getInstance(application).taskDao



    fun insertTask(task: Task) = MutableLiveData<Resource<Long>>().apply {
        postValue(Loading())
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = taskDao.insertTask(task)
                postValue(Success(result.toString()))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }
}