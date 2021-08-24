package com.delta.onsites.Calculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delta.onsites.R;
import com.delta.onsites.SharedViewModel;

public class OutputFragment extends Fragment {

    TextView answer;

    SharedViewModel viewModel;

    public OutputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        answer = view.findViewById(R.id.answer);

        answer.setText("0.0");

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getAnswer().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                answer.setText(aDouble.toString());
            }
        });
    }

    //public void updateAns(double ans)
    //{
    //    answer.setText(ans + "");
    //}
}