package com.example.androidlabs;


import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ToDoItem> toDoList = new ArrayList<>();
    private ToDoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.todoListView);
        EditText editText = findViewById(R.id.todoEditText);
        Switch urgentSwitch = findViewById(R.id.urgentSwitch);
        Button addButton = findViewById(R.id.addButton);

        adapter = new ToDoAdapter(this, toDoList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (!text.isEmpty()) {
                toDoList.add(new ToDoItem(text, urgentSwitch.isChecked()));
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Do you want to delete this?")
                    .setMessage("The selected row is " + position)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        toDoList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }
}



