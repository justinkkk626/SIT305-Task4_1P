// TaskAdapter.java
package com.example.task_4p.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_4p.R;
import com.example.task_4p.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private List<Task> tasks = new ArrayList<>();

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Task currentTask = tasks.get(position);
        holder.textViewTitle.setText(currentTask.getTitle());
        holder.textViewDueDate.setText(currentTask.getDueDate());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void submitList(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDueDate;

        public TaskHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDueDate = itemView.findViewById(R.id.text_view_due_date);
        }
    }
}
