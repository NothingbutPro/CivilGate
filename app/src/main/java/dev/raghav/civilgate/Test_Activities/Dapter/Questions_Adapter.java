package dev.raghav.civilgate.Test_Activities.Dapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.raghav.civilgate.Const_Files.Questions_jJava;
import dev.raghav.civilgate.Dapter.Level_Adapter;
import dev.raghav.civilgate.R;

public class Questions_Adapter extends RecyclerView.Adapter<Questions_Adapter.MyViewHolder> {
    List<Questions_jJava> questionsJJavas ;
    ArrayList personImages;
    Context context;
    public Questions_Adapter(Context context, List<Questions_jJava> questionsJJavas) {
        this.context = context;
        this.questionsJJavas = questionsJJavas;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.que_style, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        for(int p=0;p< 20;p++)
        {
            Log.d("value of p" , ""+p);
            myViewHolder.id.setText(String.valueOf(p));

        }
    }

    @Override
    public int getItemCount() {
        return 30;
//        return questionsJJavas.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView id;
     //   ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            id = (TextView) itemView.findViewById(R.id.que_sty);
      //      image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}