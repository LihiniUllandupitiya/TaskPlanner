package com.example.taskplanner.dao


import androidx.room.*
import com.example.taskplanner.models.Task

@Dao
interface TaskDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long


}