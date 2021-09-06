package com.example.fragment2_you_dynamic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {
    private List<ResponseModel> list;
    public FragmentAdapter(List<ResponseModel> list){

        this.list = list;
    }



    @NonNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position) {
        ResponseModel responseModel = list.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
