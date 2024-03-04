package com.example.chronosaurusrevision.ui.Classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chronosaurusrevision.databinding.FragmentClassesBinding;

public class ClassesFragment extends Fragment {

    private FragmentClassesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClassesViewModel homeViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);

        binding = FragmentClassesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textClasses;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}