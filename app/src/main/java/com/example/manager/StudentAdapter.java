package com.example.manager;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolderlocation>{


    ArrayList<Member> list;
    Context context;

    public StudentAdapter(Context context,ArrayList<Member> list){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolderlocation onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stud,parent,false);
        return new StudentAdapter.MyViewHolderlocation(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderlocation holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail=new Intent(context,details.class);
                detail.putExtra("sendingname",list.get(position).getName());
                detail.putExtra("sendingroll",list.get(position).getRoll());
                detail.putExtra("sendingsemester",list.get(position).getSemester());
                detail.putExtra("sendingbranch",list.get(position).getBranch());
                detail.putExtra("sendingphoneno",list.get(position).getPhone());
                detail.putExtra("sendingemail",list.get(position).getEmail());
                detail.putExtra("sendingdob",list.get(position).getDob());
                detail.putExtra("sendingmode",list.get(position).getMode());
                detail.putExtra("sendingfather",list.get(position).getFather());
                detail.putExtra("sendingmother",list.get(position).getMother());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolderlocation extends RecyclerView.ViewHolder {

        TextView textView;
        public MyViewHolderlocation(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView9);

        }
    }
}
