package com.example.chronosaurusrevision.ui.Assignments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AssignViewModel extends ViewModel {

    private final MutableLiveData<List<Assignment>> assignmentListLiveData;
    private List<Assignment> assignmentList;

    public AssignViewModel() {
        assignmentList = new ArrayList<>();
        assignmentListLiveData = new MutableLiveData<>(assignmentList);
    }

    public LiveData<List<Assignment>> getAssignmentListLiveData() {
        return assignmentListLiveData;
    }

    public void addAssignment(Assignment assignment) {
        assignmentList.add(assignment);
        assignmentListLiveData.setValue(assignmentList);
    }

    public void updateAssignment(int position, Assignment updatedAssignment) {
        if (position >= 0 && position < assignmentList.size()) {
            assignmentList.set(position, updatedAssignment);
            assignmentListLiveData.setValue(assignmentList);
        }
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public Assignment getAssignment(int position) {
        if (position >= 0 && position < assignmentList.size()) {
            return assignmentList.get(position);
        }
        return null;
    }

    public void removeAssignment(int position) {
        if (position >= 0 && position < assignmentList.size()) {
            assignmentList.remove(position);
            assignmentListLiveData.setValue(assignmentList);
        }
    }
}
