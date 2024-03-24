package com.example.chronosaurusrevision.ui.Assignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chronosaurusrevision.R;

public class AddAssignmentActivity extends AppCompatActivity {
    private EditText addTitle, addDueDate, addAssociatedClass, addDetails;
    private Button addAssignment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);

        addTitle = findViewById(R.id.addTitle);
        addDueDate = findViewById(R.id.addDueDate);
        addAssociatedClass = findViewById(R.id.addAssociatedClass);
        addDetails = findViewById(R.id.addDetails);
        addAssignment2 = findViewById(R.id.addAssignment2);

        addAssignment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditText fields
                String title = addTitle.getText().toString();
                String dueDate = addDueDate.getText().toString();
                String associatedClass = addAssociatedClass.getText().toString();
                String details = addDetails.getText().toString();

                // Create an Intent to pass data back to the calling activity or fragment
                Intent intent = new Intent();
                intent.putExtra("title", title);
                intent.putExtra("dueDate", dueDate);
                intent.putExtra("associatedClass", associatedClass);
                intent.putExtra("details", details);

                // Set the result code and data to be sent back
                setResult(RESULT_OK, intent);
                // Finish AddAssignmentActivity
                finish();
            }
        });
    }
}
