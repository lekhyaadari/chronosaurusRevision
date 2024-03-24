package com.example.chronosaurusrevision.ui.Classes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chronosaurusrevision.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {

    Button updateButton;
    EditText updateCourse, updateProf, updateTime, updatePlace, updateDays, updateSec;
    String key;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toast.makeText(UpdateActivity.this, "Running", Toast.LENGTH_SHORT).show();

        updateButton.findViewById(R.id.updateClassButton);
        updateCourse.findViewById(R.id.updateClass);
        updateProf.findViewById(R.id.updateProf);
        updateTime.findViewById(R.id.updateTime);
        updatePlace.findViewById(R.id.updatePlace);
        updateDays.findViewById(R.id.updateDays);
        updateSec.findViewById(R.id.updateSec);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            updateProf.setText(bundle.getString("Professor"));
            updateCourse.setText(bundle.getString("Course"));
            updateTime.setText(bundle.getString("Times"));
            updatePlace.setText(bundle.getString("Place"));
            updateDays.setText(bundle.getString("Days"));
            updateSec.setText(bundle.getString("Sec"));
            key = bundle.getString("Key");
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("chronosaurus").child(key);
        updateButton.setOnClickListener(v -> {
            updateData();
//                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
//                startActivity(intent);
        });
    }

//    public void saveData() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
//        builder.setCancelable(false);
//        builder.setView(R.layout.progress_layout);
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

    public void updateData(){
        String course = updateCourse.getText().toString().trim();
        String prof = updateProf.getText().toString().trim();
        String time = updateTime.getText().toString().trim();
        String days = updateDays.getText().toString().trim();
        String place = updatePlace.getText().toString().trim();
        String sec = updateSec.getText().toString().trim();

        DataClass dataClass = new DataClass(course, prof, time, place, days, sec);

        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(UpdateActivity.this, "help", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}