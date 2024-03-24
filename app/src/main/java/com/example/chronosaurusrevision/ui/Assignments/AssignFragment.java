package com.example.chronosaurusrevision.ui.Assignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chronosaurusrevision.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AssignFragment extends Fragment implements AssignmentAdapter.OnEditButtonClickListener, AssignmentAdapter.OnDeleteButtonClickListener {
    private AssignViewModel assignViewModel;
    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;

    private static final int REQUEST_ADD_ASSIGNMENT = 1;
    private static final int REQUEST_EDIT_ASSIGNMENT = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assign, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle FAB click event by starting AddAssignmentActivity
                startActivityForResult(new Intent(getActivity(), AddAssignmentActivity.class), REQUEST_ADD_ASSIGNMENT);
            }
        });

        assignViewModel = new ViewModelProvider(this).get(AssignViewModel.class);
        assignViewModel.getAssignmentListLiveData().observe(getViewLifecycleOwner(), assignments -> {
            // Update RecyclerView when assignment list changes
            adapter.setAssignmentList(assignments);
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new AssignmentAdapter(getActivity(), assignViewModel.getAssignmentList());

        adapter.setEditButtonClickListener(new AssignmentAdapter.OnEditButtonClickListener() {
            @Override
            public void onEditButtonClick(int position, Assignment assignment) {
                // Handle edit button click
                Intent intent = new Intent(getActivity(), EditAssignmentActivity.class);
                intent.putExtra("title", assignment.getTitle());
                intent.putExtra("dueDate", assignment.getDueDate());
                intent.putExtra("associatedClass", assignment.getAssociatedClass());
                intent.putExtra("details", assignment.getDetails());
                intent.putExtra("position", position);
                startActivityForResult(intent, REQUEST_EDIT_ASSIGNMENT);
            }
        });

        adapter.setDeleteButtonClickListener(this); // Set the delete button click listener
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_ASSIGNMENT && resultCode == getActivity().RESULT_OK && data != null) {
            // Handle result from AddAssignmentActivity
            String title = data.getStringExtra("title");
            String dueDate = data.getStringExtra("dueDate");
            String associatedClass = data.getStringExtra("associatedClass");
            String details = data.getStringExtra("details");

            // Create new Assignment object
            Assignment newAssignment = new Assignment(title, dueDate, associatedClass, details);

            // Add new assignment to ViewModel
            assignViewModel.addAssignment(newAssignment);
        } else if (requestCode == REQUEST_EDIT_ASSIGNMENT && resultCode == getActivity().RESULT_OK && data != null) {
            // Handle result from EditAssignmentActivity
            String title = data.getStringExtra("title");
            String dueDate = data.getStringExtra("dueDate");
            String associatedClass = data.getStringExtra("associatedClass");
            String details = data.getStringExtra("details");
            int position = data.getIntExtra("position", -1);

            if (position != -1) {
                // Create updated Assignment object
                Assignment updatedAssignment = new Assignment(title, dueDate, associatedClass, details);

                // Update assignment in ViewModel
                assignViewModel.updateAssignment(position, updatedAssignment);
            } else {
                Toast.makeText(getActivity(), "Invalid position", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Handle edit button click to navigate to EditAssignmentActivity
    @Override
    public void onEditButtonClick(int position, Assignment assignment) {
        Intent intent = new Intent(getActivity(), EditAssignmentActivity.class);
        intent.putExtra("assignment", (CharSequence) assignment); // Pass the assignment object to EditAssignmentActivity
        intent.putExtra("position", position); // Pass the position of the item being edited
        startActivityForResult(intent, REQUEST_EDIT_ASSIGNMENT); // Start activity for result
    }

    // Handle delete button click to delete the item
    @Override
    public void onDeleteButtonClick(int position) {
        assignViewModel.removeAssignment(position); // Remove the assignment from ViewModel
    }
}
