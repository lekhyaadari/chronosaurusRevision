package com.example.chronosaurusrevision.ui.Tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TasksViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TasksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Academic Tasks");
    }

    public LiveData<String> getText() {
        return mText;
    }
}