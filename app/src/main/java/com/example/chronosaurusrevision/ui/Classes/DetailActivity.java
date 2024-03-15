package com.example.chronosaurusrevision.ui.Classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chronosaurusrevision.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView detailCourse, detailProf, detailTime, detailPlace, detailDays, detailSec;
    ImageView detailImage;
    FloatingActionButton deleteButton, updateButton;
    String key = "";
    //String imageUrl = "";
    private Context context;
    private List<DataClass> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailCourse = findViewById(R.id.detailCourse);
        detailProf = findViewById(R.id.detailProf);
        detailTime = findViewById(R.id.detailTime);
        detailPlace = findViewById(R.id.detailPlace);
        detailDays = findViewById(R.id.detailDays);
        detailSec = findViewById(R.id.detailSec);
        deleteButton = findViewById(R.id.deleteButton);
        updateButton = findViewById(R.id.updateButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailProf.setText(bundle.getString("Professor"));
            detailCourse.setText(bundle.getString("Course"));
            detailTime.setText(bundle.getString("Times"));
            detailPlace.setText(bundle.getString("Place"));
            detailDays.setText(bundle.getString("Days"));
            detailSec.setText(bundle.getString("Sec"));
            key = bundle.getString("Key");
            //Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("chronosaurus");

                View view = LayoutInflater.from(DetailActivity.this).inflate(R.layout.confirm_delete, null);

                Button no = view.findViewById(R.id.dltNo);
                Button yes = view.findViewById(R.id.dltYes);

                AlertDialog deleteConfirm = new AlertDialog.Builder(DetailActivity.this).setView(view).create();
                deleteConfirm.setCancelable(false);
                //deleteConfirm.setView(R.layout.confirm_delete);
                //AlertDialog dialog = deleteConfirm.create();
                deleteConfirm.show();

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reference.child(key).removeValue();
                        deleteConfirm.dismiss();
                        Toast.makeText(DetailActivity.this, "Class Deleted", Toast.LENGTH_LONG).show();
                        //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteConfirm.dismiss();
                    }
                });
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(DetailActivity.this).inflate(R.layout.confirm_edit, null);

                Button no = view.findViewById(R.id.editNo);
                Button yes = view.findViewById(R.id.editYes);

                AlertDialog editConfirm = new AlertDialog.Builder(DetailActivity.this).setView(view).create();
                editConfirm.setCancelable(false);
                //deleteConfirm.setView(R.layout.confirm_delete);
                //AlertDialog dialog = deleteConfirm.create();
                editConfirm.show();

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                                .putExtra("Course", detailCourse.getText().toString())
                                .putExtra("Professor", detailProf.getText().toString())
                                .putExtra("Times", detailTime.getText().toString())
                                .putExtra("Place", detailPlace.getText().toString())
                                .putExtra("Days", detailDays.getText().toString())
                                .putExtra("Sec", detailSec.getText().toString())
                                .putExtra("Key", key);
                        DetailActivity.this.startActivity(intent);
                        finish();
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editConfirm.dismiss();
                    }
                });
            }
        });
    }
}