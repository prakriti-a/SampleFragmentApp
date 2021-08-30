package com.prakriti.samplefragmentapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CustomTextView extends TextView implements View.OnFocusChangeListener {

    private static final String TAG = "CustomTextView";
    private Context context;
    private Drawable poster_bg;

    public CustomTextView(Context context) {
        super(context);
        this.context = context;
        initLayout();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initLayout();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initLayout();
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initLayout();
    }

    private void initLayout() {
        poster_bg = getResources().getDrawable(R.drawable.poster_focus, null);
        setFocusable(true);
        setOnFocusChangeListener(this);
//        setForeground(poster_bg);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v instanceof CustomTextView && v.isFocused()) {
            Log.i(TAG, "onFocusChange: " + v.isFocused());
            v.setForeground(poster_bg);
            Toast.makeText(context, "TextView focused!", Toast.LENGTH_SHORT).show();
        } else  {
            v.setForeground(null);
        }
    }
}