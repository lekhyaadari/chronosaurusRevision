package com.example.chronosaurusrevision.ui.Classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chronosaurusrevision.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recCourse.setText(dataList.get(position).getDataName());
        holder.recProf.setText(dataList.get(position).getDataProf());
        holder.recTime.setText(dataList.get(position).getDataTime());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context ClassesFragment = null;
                Intent intent = new Intent(ClassesFragment, DetailActivity.class);
                intent.putExtra("Course", dataList.get(holder.getLayoutPosition()).getDataName());
                intent.putExtra("Professor", dataList.get(holder.getLayoutPosition()).getDataProf());
                intent.putExtra("Times", dataList.get(holder.getLayoutPosition()).getDataTime());
                intent.putExtra("Place", dataList.get(holder.getLayoutPosition()).getDataPlace());
                intent.putExtra("Days", dataList.get(holder.getLayoutPosition()).getDataDays());
                intent.putExtra("Sec", dataList.get(holder.getLayoutPosition()).getDataSec());
                intent.putExtra("Key", dataList.get(holder.getLayoutPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList (ArrayList<DataClass> searchList) {
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView recImage;
    TextView recCourse, recProf, recTime;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        //recImage = itemView.findViewById(R.id.recImage);
        recCourse = itemView.findViewById(R.id.recCourse);
        recProf = itemView.findViewById(R.id.recProf);
        recTime = itemView.findViewById(R.id.recTime);
        recCard = itemView.findViewById(R.id.recCard);

    }
}