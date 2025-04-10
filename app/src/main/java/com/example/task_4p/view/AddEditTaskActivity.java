// AddEditTaskActivity.java
package com.example.task_4p.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.task_4p.R;
import com.example.task_4p.model.Task;
import com.example.task_4p.viewmodel.TaskViewModel;

public class AddEditTaskActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription, editTextDueDate;
    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextDueDate = findViewById(R.id.edit_text_due_date);
        Button buttonSave = findViewById(R.id.button_save);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        buttonSave.setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String dueDate = editTextDueDate.getText().toString();

        Task task = new Task(title, description, dueDate);
        taskViewModel.insert(task);

        finish();
    }
}
