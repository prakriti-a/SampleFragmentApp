package com.prakriti.samplefragmentapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.widget.HorizontalGridView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TabsAdapter extends RecyclerView.Adapter<TabsAdapter.TabsVH> {

    private static final String TAG = "TabsAdapter";

    private Context context;
    private List<String> tabs;
    private Drawable poster_focus;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    public TabsAdapter(Context context, List<String> tabs, FragmentManager manager) {
        this.context = context;
        this.tabs = tabs;
        fragmentManager = manager;
        poster_focus = context.getResources().getDrawable(R.drawable.poster_focus, null);
    }

    @NonNull
    @Override
    public TabsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabs_layout, parent, false);
        return new TabsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabsVH holder, int position) {
        Log.i(TAG, "onBindViewHolder: " + position);

        holder.getTextView().setText(tabs.get(position));
        holder.getTextView().setFocusable(true);
        holder.getTextView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(v.isFocused()) {
                    v.setForeground(poster_focus);
                    // switch between tabs
                    switch(position) {
                        case 0: // initialise frag
                            fragment = FragmentOne.newInstance();
                            Log.i(TAG, "onFocusChange: fragment one");
                            break;
                        case 1:
                            fragment = FragmentTwo.newInstance();
                            Log.i(TAG, "onFocusChange: fragment two");
                            break;
                        case 2:
                            fragment = FragmentThree.newInstance();
                            Log.i(TAG, "onFocusChange: fragment three");
                            break;
                        default: fragment = null;
                            Log.e(TAG, "onFocusChange: default case executed");
                    }
                    fragmentManager.beginTransaction()
                            .replace(R.id.mainRelativeLayout, fragment, fragment.getTag())
//                            .add(R.id.mainRelativeLayout, fragment, fragment.getTag())
                            // add() -> ID of layout inside which you wanna add the fragment, fragment obj, Tag to identify fragment
                            .commit();
                    Log.i(TAG, "onFocusChange: fragment replaced");
                } else {
                    v.setForeground(null);
//                    if(fragment != null) {
//                        fragmentManager.beginTransaction().remove(fragment).commit();
//                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tabs.size();
    }

    public static class TabsVH extends RecyclerView.ViewHolder {

        private TextView textView;

        public TabsVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
