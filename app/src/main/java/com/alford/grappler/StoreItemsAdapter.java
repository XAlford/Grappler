package com.alford.grappler;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by WilliamAlford on 4/11/17.
 */

public class StoreItemsAdapter extends RecyclerView.Adapter<PositionItemViewHolder> {

    private List<Positions> mPositions;

    public StoreItemsAdapter(List<Positions> positions) {
        mPositions = positions;
    }

    @Override
    public PositionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new PositionItemViewHolder(inflater.inflate(R.layout.item_in_store, parent, false));
    }

    @Override
    public void onBindViewHolder(final PositionItemViewHolder holder, int position) {
        final Positions currentPosition = mPositions.get(position);

        int resId = holder.mSmallImageView.getContext().getResources().getIdentifier(currentPosition.getmImageSmall(),"drawable",holder.mSmallImageView.getContext().getPackageName());
        holder.mSmallImageView.setImageResource(resId);

        holder.mPositionNameTextView.setText(currentPosition.getmPositionName());
        holder.mRemoveThisParticular.setVisibility(View.GONE);
        //holder.mSmallImageView.setBackgroundResource();

//
//        holder.mReturnToStoreImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), Store.class);
//                v.getContext().startActivity(intent);
//            }
//        });



//
//        holder.mGotoCheckOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(v.getContext(), Store.class);
//
//                intent.putExtra(Store.MOVE_KEY, mPositions.get(holder.getAdapterPosition()).getmId());
//            }
//        });
        holder.mLookAtDetailsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailView.class);

                intent.putExtra(DetailView.MOVE_KEY, mPositions.get(holder.getAdapterPosition()).getmId());

                v.getContext().startActivity(intent);

            }
        });


    }

    public void replaceData(List<Positions> positions) {
        mPositions.clear();
        mPositions.addAll(positions);
        notifyDataSetChanged();

    }






    @Override
    public int getItemCount() {
        return mPositions.size();
    }
}
