package com.example.chronosaurusrevision.ui.Classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClassesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Classes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}