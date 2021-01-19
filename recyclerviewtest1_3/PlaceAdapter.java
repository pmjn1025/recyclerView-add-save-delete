package com.example.recyclerviewtest1_3;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.CustomViewHolder> implements OnItemClickListener{

    OnItemClickListener listener;
    ArrayList<PlaceData> placeDataArrayList;




    // 생성자
    public PlaceAdapter(ArrayList<PlaceData> placeDataArrayList) {
        this.placeDataArrayList = placeDataArrayList;

    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item1, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_place_name.setText(placeDataArrayList.get(position).getName());
        holder.tv_visit_date.setText(placeDataArrayList.get(position).getDate());
        holder.tv_visit_time.setText(placeDataArrayList.get(position).getTime());

        holder.itemView.setTag(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                System.out.println("리스너1");
                if(listener !=null){
                    System.out.println("리스너2");
                    listener.onItemClick(holder,v,position);
                }
            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                int position = holder.getAdapterPosition();
                System.out.println("포지션값:"+position);
                if(listener !=null){
                    listener.onItemLongClick(holder,v,position);
                }
                notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != placeDataArrayList ? placeDataArrayList.size() : 0 );
    }

    /*새로 추가한 부분*/
    public  void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onItemClick(CustomViewHolder holder, View view, int position) {
    }


    @Override
    public void onItemLongClick(CustomViewHolder holder, View view, int position) {

    }



    // item.xml 과 홀더를 연결 시켜 준다.
    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView tv_place_name;
        TextView tv_visit_date;
        TextView tv_visit_time;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_place_name = itemView.findViewById(R.id.tv_place_name);
            tv_visit_date = itemView.findViewById(R.id.tv_visit_date);
            tv_visit_time = itemView.findViewById(R.id.tv_visit_time);
        }
    }










}