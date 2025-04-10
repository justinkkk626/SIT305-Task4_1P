// TaskListActivity.java
package com.example.task_4p.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import com.example.task_4p.R;
import com.example.task_4p.model.Task;
import com.example.task_4p.viewmodel.TaskViewModel;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        TaskAdapter adapter = new TaskAdapter();
        recyclerView.setAdapter(adapter);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                adapter.submitList(tasks);
            }
        });

        Button buttonAddTask = findViewById(R.id.button_add_task);
        buttonAddTask.setOnClickListener(view ->  {
            Intent intent = new Intent(TaskListActivity.this, AddEditTaskActivity.class);
            startActivity(intent);
        });
    }
}
