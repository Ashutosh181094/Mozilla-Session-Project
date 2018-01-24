package com.example.a1505197.mozilla10;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 1505197 on 1/20/2018.
 */

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ProgrammingViewHolder>
{
    Context context;
    ArrayList<information> data;
    LayoutInflater inflater;
    public  MyCustomAdapter(Context context, ArrayList<information> data)
    {
        this.context=context;
        this.data=data;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public MyCustomAdapter.ProgrammingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.single_item,parent,false);
        MyCustomAdapter.ProgrammingViewHolder holder=new  MyCustomAdapter.ProgrammingViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(ProgrammingViewHolder holder, int position) {
        holder.textView.setText(data.get(position).title);
        holder.imageView.setImageResource(data.get(position).imageId);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public ProgrammingViewHolder(View itemView)
        {
            super(itemView);
         imageView=(ImageView) itemView.findViewById(R.id.imagecard);
            textView=(TextView) itemView.findViewById(R.id.cardtextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

}
