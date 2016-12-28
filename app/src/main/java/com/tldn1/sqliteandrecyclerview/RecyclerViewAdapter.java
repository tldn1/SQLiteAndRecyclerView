package com.tldn1.sqliteandrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by X on 12/28/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    ArrayList<ContactModel> arrayList = new ArrayList<ContactModel>();

    public RecyclerViewAdapter(ArrayList<ContactModel> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ContactModel model = arrayList.get(position);
        holder.txtName.setText(model.getName());
        holder.txtLname.setText(model.getEmail());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtLname;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtLname = (TextView)itemView.findViewById(R.id.txtEmail);
        }
    }
}