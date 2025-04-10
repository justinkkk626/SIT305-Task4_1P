// TaskDetailActivity.java
package com.example.task_4p.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.task_4p.R;
import com.example.task_4p.model.Task;
import com.example.task_4p.viewmodel.TaskViewModel;

public class TaskDetailActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView textViewTitle = findViewById(R.id.text_view_title);
        TextView textViewDescription = findViewById(R.id.text_view_description);
        TextView textViewDueDate = findViewById(R.id.text_view_due_date);
        Button buttonEdit = findViewById(R.id.button_edit);
        Button buttonDelete = findViewById(R.id.button_delete);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        Intent intent = getIntent();
        if (intent.hasExtra("task")) {
            task = (Task) intent.getSerializableExtra("task");

            textViewTitle.setText(task.getTitle());
            textViewDescription.setText(task.getDescription());
            textViewDueDate.setText(task.getDueDate());
        }

        buttonEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(TaskDetailActivity.this, AddEditTaskActivity.class);
            editIntent.putExtra("task", task);
            startActivity(editIntent);
        });

        buttonDelete.setOnClickListener(v -> {
            taskViewModel.delete(task);
            finish();
        });
    }
}
