package com.geekfreakdeveloper.todolist;

import android.content.Context;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> toDoList;

    public RecyclerViewAdapter(ArrayList<String> toDoList, Context context)
    {
        this.toDoList = toDoList;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {

        String taskList = toDoList.get(position);
        holder.selectionState.setText(taskList);
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public CheckBox selectionState;

        public ViewHolder(View view) {
            super(view);

            selectionState = (CheckBox)view.findViewById(R.id.checkBox);


            view.setOnClickListener(this);

            selectionState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                       Toast.makeText(context,"Selected",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, "Unselected", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    }

