package com.example.fragment2_you_dynamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {

        FragmentTransaction transaction  = fragmentManager.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        transaction.add(R.id.flContainer, blankFragment, "blanKFragment").commit();
    }
}