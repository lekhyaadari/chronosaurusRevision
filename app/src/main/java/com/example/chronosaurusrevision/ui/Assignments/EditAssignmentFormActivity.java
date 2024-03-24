package com.example.chronosaurusrevision.ui.Assignments;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chronosaurusrevision.R;

public class EditAssignmentFormActivity extends AppCompatActivity {
    private EditText editTitle, editDueDate, editAssociatedClass, editDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_assignment); // Change to edit_assignment.xml

        editTitle = findViewById(R.id.editTitle);
        editDueDate = findViewById(R.id.editDueDate);
        editAssociatedClass = findViewById(R.id.editAssociatedClass);
        editDetails = findViewById(R.id.editDetails);

        // Retrieve data passed from EditAssignmentActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String originalTitle = extras.getString("title");
            String originalDueDate = extras.getString("dueDate");
            String originalAssociatedClass = extras.getString("associatedClass");
            String originalDetails = extras.getString("details");

            // Pre-fill EditText fields with original data for editing
            editTitle.setText(originalTitle);
            editDueDate.setText(originalDueDate);
            editAssociatedClass.setText(originalAssociatedClass);
            editDetails.setText(originalDetails);
        }
    }
}
