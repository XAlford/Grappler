package com.alford.grappler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WilliamAlford on 4/10/17.
 */

public class PositionItemViewHolder extends RecyclerView.ViewHolder {
    View mRootView;
    TextView mPositionNameTextView, mPostionCostTextView;
    ImageView mSmallImageView;
    Button mLookAtDetailsButton;
    Button mGotoCheckOut;
    Button mReturnToStoreImageButton;
    ImageView mPlaceInCartButton;
    Button mRemoveThisParticular;



    public PositionItemViewHolder(View itemView) {
        super(itemView);

        mRootView = itemView;

        mSmallImageView = (ImageView) itemView.findViewById(R.id.item_logo);
        mPositionNameTextView = (TextView) itemView.findViewById(R.id.item_name);
        mPostionCostTextView = (TextView) itemView.findViewById(R.id.payment);
        mLookAtDetailsButton = (Button) itemView.findViewById(R.id.examine_button);
        mGotoCheckOut = (Button) itemView.findViewById(R.id.gotocheckout);
        mPlaceInCartButton = (ImageView) itemView.findViewById(R.id.buy_button);

        mRemoveThisParticular = (Button) itemView.findViewById(R.id.remover);

        //mReturnToStoreImageButton = (Button) itemView.findViewById(R.id.checkout_button);




    }
}
