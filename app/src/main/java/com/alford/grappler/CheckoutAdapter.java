package com.alford.grappler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by WilliamAlford on 4/12/17.
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckOutViewHolder> {

    private List<Positions> mPositions;

    public CheckoutAdapter(List<Positions> positions) {mPositions = positions;

    }



    @Override
    public CheckOutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());



        return new CheckOutViewHolder(inflater.inflate(R.layout.item_in_store, parent, false));

    }

    @Override
    public void onBindViewHolder(final CheckOutViewHolder holder, final int position) {
        final Positions currentPosition = mPositions.get(position);


        int resId = holder.mItemImageLogoBig.getContext().getResources().getIdentifier(currentPosition.getmImageBig(),"drawable",holder.mItemImageLogoBig.getContext().getPackageName());
        holder.mItemImageLogoBig.setImageResource(resId);

        holder.mPostionNameTextView.setText(currentPosition.getmPositionName());

        holder.mRemoveThisParticular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper.getInstance(v.getContext()).updateCart(currentPosition.getmId(),0);

                Toast.makeText(v.getContext(),"Learn this positions another time",Toast.LENGTH_SHORT).show();

                mPositions.remove(currentPosition);

                notifyItemRemoved(holder.getAdapterPosition());




            }
        });



        holder.mPlaceInCartImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //v.getContext().startActivity(intent);

            }
        });

    }

    //Method for resetting adapter

    public void resetAdapter (){
        mPositions.clear();
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return mPositions.size();
    }
}
