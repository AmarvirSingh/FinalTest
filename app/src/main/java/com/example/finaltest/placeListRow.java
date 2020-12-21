package com.example.finaltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeListRow extends BaseAdapter {
    private ArrayList<details> det = new ArrayList<>();
    LayoutInflater inflater;

    public placeListRow(ArrayList<details> det, Context context) {
        this.det = det;
        inflater = inflater.from(context);
    }

    @Override
    public int getCount() {
        return det.size();
    }

    @Override
    public Object getItem(int position) {
        return det.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderView holder = new HolderView();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            holder.adapterPlaceName = convertView.findViewById(R.id.adapterPlaceName);
            holder.adapterImage = convertView.findViewById(R.id.adapterImageView);
            holder.adapterPrice = convertView.findViewById(R.id.adapterPrice);
            convertView.setTag(holder);
        }
        else {
            convertView.getId();

        }


        int gid = convertView.getResources().getIdentifier(det.get(position).getPlaceImage(), "mipmap", convertView.getContext().getPackageName());
        holder.adapterImage.setImageResource(gid);
        holder.adapterPlaceName.setText(det.get(position).getPlace());
        holder.adapterPrice.setText(String.valueOf(det.get(position).getPrice()));


        return convertView;
    }
    static class HolderView{
        TextView adapterPlaceName,adapterPrice;
        ImageView adapterImage;
    }
}
