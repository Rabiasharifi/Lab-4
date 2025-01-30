package com.example.androidlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private EditText editText;
    private CheckBox checkBox;
    private Switch switchButton;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);  // Using LinearLayout layout

        // Initialize UI elements
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
        switchButton = findViewById(R.id.switchButton);
        imageButton = findViewById(R.id.imageButton);

        // Button click listener to update TextView and show Toast
        button.setOnClickListener(view -> {
            String inputText = editText.getText().toString();
            textView.setText(inputText);

            // Show a Toast with translated message
            // Access French resource strings
            String toastMessage = getResources().getString(R.string.toast_message);

            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
        });

        // Checkbox change listener to show Snackbar with Undo action
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Dynamically create the message based on the checkbox state (on or off)
            String snackMessage = getString(R.string.checkbox_message, isChecked ? "on" : "off");
            Snackbar.make(findViewById(R.id.linearLayout), snackMessage, Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.undo), v -> checkBox.setChecked(!isChecked))  // Undo action
                    .show();
        });
    }
}
