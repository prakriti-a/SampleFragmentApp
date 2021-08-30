package com.prakriti.samplefragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.HorizontalGridView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        List<String> tabsList = new ArrayList<>();
        tabsList.add("TAB1");
        tabsList.add("TAB2");
        tabsList.add("TAB3");

        HorizontalGridView horizontalGridView = findViewById(R.id.horizontalGridView);
        TabsAdapter tabsAdapter = new TabsAdapter(this, tabsList, getSupportFragmentManager());
        horizontalGridView.setAdapter(tabsAdapter);

//        FragmentOne mainFragment = FragmentOne.newInstance();
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.mainRelativeLayout, mainFragment, "FragmentOne")
//                    // add() -> ID of layout inside which you wanna add the fragment, fragment obj, Tag to identify fragment
//                .commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

}

/*
    every Activity has its own FragmentManager, maintains references to all fragments in an Activity
    FragmentTransactions -> begin transactions and commit them
 */