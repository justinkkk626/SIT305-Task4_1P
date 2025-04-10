// TaskRepository.java
package com.example.task_4p.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.task_4p.database.TaskDao;
import com.example.task_4p.database.TaskDatabase;
import com.example.task_4p.model.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;
    private final ExecutorService executorService;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void insert(Task task) {
        executorService.execute(() -> taskDao.insert(task));
    }

    public void update(Task task) {
        executorService.execute(() -> taskDao.update(task));
    }

    public void delete(Task task) {
        executorService.execute(() -> taskDao.delete(task));
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
}
