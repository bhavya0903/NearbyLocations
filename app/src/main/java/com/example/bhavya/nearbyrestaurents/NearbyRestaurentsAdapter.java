package com.example.bhavya.nearbyrestaurents;

import android.app.Activity;
import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.nearby.Nearby;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bhavya on 04-09-2017.
 */

public class NearbyRestaurentsAdapter extends RecyclerView.Adapter<NearbyRestaurentsAdapter.CustomViewHolder> {

    Activity mActivity;
    Context context;
    MapsActivity mapsActivity;
    ArrayList<NearbyBean> nearbyBeanList;



    public NearbyRestaurentsAdapter(Context context,MapsActivity mapsActivity, ArrayList<NearbyBean> nearbyBeanArrayList) {
        this.context = context;
        this.mapsActivity = mapsActivity;
        this. nearbyBeanList= nearbyBeanArrayList;
        Collections.sort(nearbyBeanArrayList, new NearbyBean());
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row_layout, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int position) {
        customViewHolder.textView.setText(nearbyBeanList.get(position).getPlaceName());
        customViewHolder.tvFav.setText(String.valueOf((nearbyBeanList.get(position).getRating())));
    }

    @Override
    public int getItemCount() {
        if (nearbyBeanList == null)
            nearbyBeanList = new ArrayList<NearbyBean>();
        return nearbyBeanList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView,tvFav;

        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.tv_item);
            this.tvFav = (TextView) view.findViewById(R.id.tv_fav);

        }
    }

}
