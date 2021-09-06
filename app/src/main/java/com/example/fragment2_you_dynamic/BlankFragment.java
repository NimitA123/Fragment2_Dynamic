package com.example.fragment2_you_dynamic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BlankFragment extends Fragment {
   private Button btnCallApi;
   private List<ResponseModel> postModelList;
   private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        btnCallApi = view.findViewById(R.id.btnCallApi);
        recyclerView = view.findViewById(R.id.rvRecycleView);
        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallApi();
            }
        });
    }

    private void CallApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);

        apiService.getUser().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if(response.body()!=null){
                    postModelList = response.body();
                    Toast.makeText(getContext(), "We are Pass", Toast.LENGTH_LONG).show();
                    setRecycleView();
                }

            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), "We are failed", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setRecycleView() {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(postModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(fragmentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}