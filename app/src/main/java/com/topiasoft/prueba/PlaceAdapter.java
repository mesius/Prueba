package com.topiasoft.prueba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fm on 23/11/2016.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context mContext;
    int mLayoutResourceId;
    Place mData[] = null;

    public PlaceAdapter(Context context, int resource, Place[] data) {
        super(context, resource, data);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Nullable
    @Override
    public Place getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        PlaceHolder holder = null;

        //if we currently don’t have a row View to reuse..
        if(row == null){
            //Create a new View
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);
            holder = new PlaceHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
            }else{
            //Otherwise use an existing one
            holder = (PlaceHolder) row.getTag();
            }

        //Getting the data form the data array
        Place place = mData[position];

        //Setup and reuse the same listener for each row
        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);


        //setting the view to reflect the data we need to display
        holder.nameView.setText(place.mNameOfPlace);
        holder.zipView.setText(String.valueOf(place.mZipCode));

        //for getting the image
        int resID = mContext.getResources().getIdentifier(place.mNameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resID);


        //returning the row (because this is called getView after all)

        return row;
    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Place p = mData[viewPosition];
            Toast.makeText(getContext(),p.mPopup,Toast.LENGTH_SHORT).show();
        }
    };

    private class PlaceHolder {
        TextView nameView;
        TextView zipView;
        ImageView imageView;

    }
}
