package com.example.chronosaurusrevision.ui.Assignments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chronosaurusrevision.databinding.FragmentAssignBinding;

public class AssignFragment extends Fragment {

    private FragmentAssignBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssignViewModel dashboardViewModel =
                new ViewModelProvider(this).get(AssignViewModel.class);

        binding = FragmentAssignBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAssign;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}