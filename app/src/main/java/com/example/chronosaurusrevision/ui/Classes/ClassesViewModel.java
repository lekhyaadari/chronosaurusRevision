package com.example.chronosaurusrevision.ui.Classes;

import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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