package com.example.chronosaurusrevision.ui.Assignments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chronosaurusrevision.R;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    private List<Assignment> assignmentList;
    private Context context;
    private OnEditButtonClickListener editButtonClickListener;
    private OnDeleteButtonClickListener deleteButtonClickListener;

    public AssignmentAdapter(Context context, List<Assignment> assignmentList) {
        this.context = context;
        this.assignmentList = assignmentList;
    }

    public interface OnEditButtonClickListener {
        void onEditButtonClick(int position, Assignment assignment);
    }

    public interface OnDeleteButtonClickListener {
        void onDeleteButtonClick(int position);
    }

    public void setEditButtonClickListener(OnEditButtonClickListener listener) {
        this.editButtonClickListener = listener;
    }

    public void setDeleteButtonClickListener(OnDeleteButtonClickListener listener) {
        this.deleteButtonClickListener = listener;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new AssignmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignmentList.get(position);
        holder.bind(assignment);

        // Set OnClickListener for editButton to handle editing the assignment
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editButtonClickListener != null) {
                    editButtonClickListener.onEditButtonClick(position, assignment);
                }
            }
        });

        // Set OnClickListener for deleteButton to handle deleting the assignment
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteButtonClickListener != null) {
                    deleteButtonClickListener.onDeleteButtonClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public void setAssignmentList(List<Assignment> assignments) {
        this.assignmentList = assignments;
        notifyDataSetChanged(); // Notify adapter of data change
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView dueDateTextView;
        private TextView associatedClassTextView;
        private TextView detailsTextView;
        private ImageButton editButton;
        private ImageButton deleteButton;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            dueDateTextView = itemView.findViewById(R.id.dueDate);
            associatedClassTextView = itemView.findViewById(R.id.associatedClass);
            detailsTextView = itemView.findViewById(R.id.details);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        public void bind(Assignment assignment) {
            titleTextView.setText(assignment.getTitle());
            dueDateTextView.setText(assignment.getDueDate());
            associatedClassTextView.setText(assignment.getAssociatedClass());
            detailsTextView.setText(assignment.getDetails());

            // Set OnClickListener for editButton to handle editing the assignment
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (editButtonClickListener != null) {
                            editButtonClickListener.onEditButtonClick(position, assignment);
                        }
                    }
                }
            });

            // Set OnClickListener for deleteButton to handle deleting the assignment
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (deleteButtonClickListener != null) {
                            deleteButtonClickListener.onDeleteButtonClick(position);
                        }
                    }
                }
            });
        }
    }
}
