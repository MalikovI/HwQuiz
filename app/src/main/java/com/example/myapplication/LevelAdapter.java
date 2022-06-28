package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ItemLevelBinding;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.levelViewHolder> {
    ArrayList<GameModel> list;
    ItemClickListener listener;
    public LevelAdapter(ArrayList<GameModel>list, ItemClickListener listener){
        this.list = list;
        this.listener = listener;
    }
    @NonNull
    @Override
    public levelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLevelBinding binding =
                ItemLevelBinding.inflate(LayoutInflater.from(parent.getContext()),parent,
                        false);
        return new levelViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.levelViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class levelViewHolder extends RecyclerView.ViewHolder {
        ItemLevelBinding binding;
        public levelViewHolder(@NonNull ItemLevelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(GameModel gameModel) {
            binding.btnLvl.setText(gameModel.levelDisplay);
            binding.btnLvl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(gameModel);
                }
            });
        }
    }
}
