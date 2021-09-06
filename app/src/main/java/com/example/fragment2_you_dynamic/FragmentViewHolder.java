package com.example.fragment2_you_dynamic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class FragmentViewHolder extends RecyclerView.ViewHolder {
    private TextView tv1;
    private TextView tv2;
    private ImageView img;
    public FragmentViewHolder(@NonNull View itemView) {

        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tv1 = itemView.findViewById(R.id.tvText);
        tv2 = itemView.findViewById(R.id.tvText1);
        img = itemView.findViewById(R.id.img);
    }
    public void setData(ResponseModel responseModel){
       tv1.setText(responseModel.getTitle());
        tv2.setText(responseModel.getSubTitle());
        if(responseModel.getImage()!=null){
            Glide.with(img).load(responseModel.getImage()).into(img);
        }

    }
}
