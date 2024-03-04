package com.example.chronosaurusrevision.ui.Assignments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssignViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AssignViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Assignments and Exams");
    }

    public LiveData<String> getText() {
        return mText;
    }
}