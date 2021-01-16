package com.anStudios.bookingstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.recentholder> {

    private ArrayList<RecentModelClass> RecentarrayList;
    private Context context;

    public RecentAdapter(ArrayList<RecentModelClass> recentarrayList, Context context) {
        RecentarrayList = recentarrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public recentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recent_booking_layout,parent,false);
        return new recentholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recentholder holder, int position) {
        holder.bookingto.setText(RecentarrayList.get(position).getBookingTo());
        holder.bookingfrom.setText(RecentarrayList.get(position).getBookingFrom());
        holder.customerName.setText(RecentarrayList.get(position).getCustomerName());
        Glide.with(context).load(RecentarrayList.get(position).getPhotoUrl()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return RecentarrayList.size();
    }

    public class recentholder extends RecyclerView.ViewHolder {
        private CircleImageView photo;
        private TextView date;
        private TextView customerName;
        private TextView bookingfrom;
        private TextView bookingto;
        public recentholder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.recentCustomerPhoto);
            date=itemView.findViewById(R.id.recentbookingDate);
            customerName=itemView.findViewById(R.id.recentCustomerName);
            bookingfrom=itemView.findViewById(R.id.recentFromplace);
            bookingto=itemView.findViewById(R.id.recentToPlace);

        }
    }
}
