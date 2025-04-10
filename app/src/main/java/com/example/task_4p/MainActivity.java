// MainActivity.java
package com.example.task_4p;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_4p.view.TaskListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(MainActivity.this, TaskListActivity.class);
        startActivity(intent);
        finish();
    }
}
