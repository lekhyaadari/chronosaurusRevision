package com.example.chronosaurusrevision.ui.Assignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chronosaurusrevision.R;

public class EditAssignmentActivity extends AppCompatActivity {
    private EditText editTitle, editDueDate, editAssociatedClass, editDetails;
    private Button saveChangesButton;

    private int position; // Variable to store the position of the assignment being edited

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_assignment);

        editTitle = findViewById(R.id.editTitle);
        editDueDate = findViewById(R.id.editDueDate);
        editAssociatedClass = findViewById(R.id.editAssociatedClass);
        editDetails = findViewById(R.id.editDetails);
        saveChangesButton = findViewById(R.id.saveChangesButton);

        // Receive data from Intent extras sent from AssignFragment or EditAssignmentActivity
        Intent intent = getIntent();
        String originalTitle = intent.getStringExtra("title");
        String originalDueDate = intent.getStringExtra("dueDate");
        String originalAssociatedClass = intent.getStringExtra("associatedClass");
        String originalDetails = intent.getStringExtra("details");
        position = intent.getIntExtra("position", -1);

        // Pre-fill EditText fields with original data for editing
        editTitle.setText(originalTitle);
        editDueDate.setText(originalDueDate);
        editAssociatedClass.setText(originalAssociatedClass);
        editDetails.setText(originalDetails);

        // Set OnClickListener for saveChangesButton to handle saving edits
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get updated data from EditText fields
                String updatedTitle = editTitle.getText().toString();
                String updatedDueDate = editDueDate.getText().toString();
                String updatedAssociatedClass = editAssociatedClass.getText().toString();
                String updatedDetails = editDetails.getText().toString();

                // Create an Intent to pass data back to AssignFragment or EditAssignmentActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", updatedTitle);
                resultIntent.putExtra("dueDate", updatedDueDate);
                resultIntent.putExtra("associatedClass", updatedAssociatedClass);
                resultIntent.putExtra("details", updatedDetails);
                resultIntent.putExtra("position", position);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
