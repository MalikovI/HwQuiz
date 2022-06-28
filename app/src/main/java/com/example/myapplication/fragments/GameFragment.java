package com.example.myapplication.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.GameModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGameBinding;


public class GameFragment extends Fragment {
   private FragmentGameBinding binding;
    private GameModel model;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String level = getArguments().getString("game");
        setUi(level);
        initClicks();

    }

    private void setUi(String level) {
        //   Glide.with(requireContext()).load(model.firstImg).into(binding.firstImg);
        //  Glide.with(requireContext()).load(model.secondImg).into(binding.secondImg);
        //  Glide.with(requireContext()).load(model.thirdImg).into(binding.thirdImg);
        //  Glide.with(requireContext()).load(model.fourthImg).into(binding.fourthImg);
        binding.countTv.setText(level);
    }

    private void initClicks() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.answerEt.getText().toString().trim().equalsIgnoreCase(model.answer)) {
                    Toast.makeText(requireContext(), "true", Toast.LENGTH_SHORT).show();
                } else {
                    binding.answerEt.setError("Вы ошиблись");
                }
            }
        });
        binding.hintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(requireContext())
                        .setMessage("Хорошо подумай")

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }
    
}